package batman_test.shahz.jchat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SocketServer implements Runnable
{
	public ServerThread clients[];
    public ServerSocket server = null;
    public Thread       thread = null;
    public int clientCount = 0, port = 13000;
    public ServerGui ui;
    //public Connection  con=null;
	//public ResultSet  rs=null;
	//public PreparedStatement  pst=null;  
    SocketServer(ServerGui gui, int Port)
    {
    	this.ui=gui;
    	this.port=Port;
    	clients = new ServerThread[50];
    	try
    	{  
    	    server = new ServerSocket(port);
    	    port = server.getLocalPort();
    	    ui.ta.append("Server startet. IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort());
    	    try 
    	    {
    	    	//Class.forName("com.mysql.jdbc.Driver");  
				//con = DriverManager.getConnection("jdbc:mysql://localhost:8888/jtalk", "myuser", "tiger");
				JOptionPane.showMessageDialog(ui,"Database connected");
			} catch (Exception e)
			{
				System.out.println("Lol");
				JOptionPane.showMessageDialog(ui,"Error in connection"+e);
				//e.printStackTrace();
			}
    	    start(); 
    	    
		}
    	catch(IOException ioe)
    	{  
                ui.ta.append("\nCan not bind to port " + port + ": " + ioe.getMessage()); 
    	}
    }
    public void start()
    {  
    	if (thread == null)
    	{  
            thread = new Thread(this); 
	        thread.start();
    	}
	}
	@Override
	public void run()//this method waits continuously for new client
	{
		while (thread != null)
		{  
            try
            {  
            	ui.ta.append("\nWaiting for a client ..."); 
	            addThread(server.accept()); 
	        }
	        catch(Exception ioe)
	        { 
                ui.ta.append("\nServer accept error: \n");
            }
        }
		
	}
	private void addThread(Socket socket) 
	{
		if (clientCount < clients.length)
		{  
	        ui.ta.append("\nClient accepted: " + socket);
		    clients[clientCount] = new ServerThread(this, socket);
		    try{  
		      	clients[clientCount].open(); 
		        clients[clientCount].start();  
		        clientCount++; 
		    }
		    catch(IOException ioe)
		    {  
		      	ui.ta.append("\nError opening thread: " + ioe); 
		    } 
		}
		else{
	            ui.ta.append("\nClient refused: maximum " + clients.length + " reached.");
		}
		
	}
	public synchronized void handle(int ID, Message msg) 
	{
		if(msg.type.equals("message"))
		{
			if(msg.recipient.equals("All"))
			{
                Announce("message", msg.sender, msg.content);
            }
            else
            {
                findUserThread(msg.recipient).send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
                clients[findClient(ID)].send(new Message(msg.type, msg.sender, msg.content, msg.recipient));
            }
		}
		else if(msg.type.equals("test"))
		{
            clients[findClient(ID)].send(new Message("test", "SERVER", "OK", msg.sender));
        }
		else if(msg.type.equals("login"))
		{
			    if(findUserThread(msg.sender) == null)
			    {
				    try 
				    {
				    	System.out.println("kkkkkkkkkkkkkkkkkkkkkk");
						//pst=con.prepareStatement("select  * from  userdetails  where  name=? and password=?");
						//pst.setString(1,msg.sender);
						//pst.setString(2,msg.content);
						System.out.println(msg.sender+" |||||||||||||||| "+msg.content);
					//	rs=pst.executeQuery();
						//if(rs.next())
						//{
							System.out.println("ppppppppp");
							clients[findClient(ID)].username = msg.sender;
		                    clients[findClient(ID)].send(new Message("login", "SERVER", "TRUE", msg.sender));
		                    Announce("newuser", "SERVER", msg.sender);
		                    SendUserList(msg.sender);
						//}
						/*else
						{
							clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
						}*/
					} 
				    catch (Exception e) 
					{
				    	System.out.println("lollzzzzzzzzzzzzzzzz"+"\n"+e);
						//e.printStackTrace();
						clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
					}
                    
             }
             else
             {
                clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender));
             }
		}
		else if(msg.type.equals("signout"))
		{
			Announce("signout", "SERVER", msg.sender);
            remove(ID); 
		}
		else if(msg.type.equals("exit"))
		{
			 remove(ID);
			Announce("signout", "SERVER", msg.sender);
            
		}
		
	}
	
	public void Announce(String type, String sender, String content)
	{
        Message msg = new Message(type, sender, content, "All");
        for(int i = 0; i < clientCount; i++){
            clients[i].send(msg);
        }
    }
	public void SendUserList(String toWhom)
	{
        for(int i = 0; i < clientCount; i++){
            findUserThread(toWhom).send(new Message("newuser", "SERVER", clients[i].username, toWhom));
        }
    }
	//problem may arise if two clients are running on same port number
	private int findClient(int ID)//return index of the client array of this particular client with given port no
	{  
    	for (int i = 0; i < clientCount; i++)
    	{
        	if (clients[i].getID() == ID)
        	{
               return i;
            }
	    }
	    return -1;
    }
	
	 public ServerThread findUserThread(String usr)
	 {
	        for(int i = 0; i < clientCount; i++)
	        {
	            if(clients[i].username.equals(usr))
	            {
	                return clients[i];
	            }
	        }
	        return null;
	    }
	 public synchronized void remove(int ID)
	 {  
	        int pos = findClient(ID);
	        if (pos >= 0)
	        {  
	            ServerThread toTerminate = clients[pos];
	            ui.ta.append("\nRemoving client thread " + ID + " at " + pos);
		        if (pos < clientCount-1)
		        {
	                for (int i = pos+1; i < clientCount; i++)
	                {
	                    clients[i-1] = clients[i];
		            }
		        }
		        clientCount--;
		        try
		        {  
		      	  toTerminate.close(); 
		        }
		        catch(IOException ioe)
		        {  
		      	  //ui.ta.append("\nError closing thread: " + ioe); 
		        	System.out.println("\nError closing thread: " + ioe);
		        }
		        toTerminate.keepRunning=false; 
		    }
	  }
	
	@SuppressWarnings("deprecation")
    public void stop()
	{  
        if (thread != null){  
            thread.stop(); 
	    thread = null;
	}
    }
	public void stopClientThread()
	{
		for(int i = 0; i < clientCount; i++)
		{
           
            try 
            {
				clients[i].close();
				 clients[i].keepRunning=false;
			} catch (IOException e)
			{
				System.out.println("Unable to stop client thread");
				e.printStackTrace();
			}
        }
		
	}
	public void close() 
	{
		
		if(server!=null)
			try {
				server.close();
			} catch (IOException e) 
			{
				System.out.println("closing server socket");
				e.printStackTrace();
			}
		
		/*if(con!=null)
		{
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(ui,"Database connection close error");
				e.printStackTrace();
			}
		}*/
	}
}
