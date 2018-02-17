package batman_test.shahz.jchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ServerThread extends Thread //this class handles each client message sending and receiving on separate thread
{ 
	
    public SocketServer server = null;
    public Socket socket = null;
    public int ID = -1;//ID is the port number
    public String username = "";
    public ObjectInputStream streamIn  =  null;
    public ObjectOutputStream streamOut = null;
    public ServerGui ui;
    public boolean keepRunning;
    public ServerThread(SocketServer server, Socket socket)
    {  
    	super();
        this.server = server;
        this.socket = socket;
        ID     = socket.getPort();
        ui = server.ui;
    }
    public void open() throws IOException
    {  
        streamOut = new ObjectOutputStream(socket.getOutputStream());//stream to send message to this client
        streamOut.flush();
        streamIn = new ObjectInputStream(socket.getInputStream()); //stream to receive message from this client
    }
    
    
    public void send(Message msg)//this method is for sending message to this client having Socket socket
    {
        try 
        {
            streamOut.writeObject(msg);
            streamOut.flush();
        } 
        catch (IOException ex) 
        {
            System.out.println("Exception [SocketClient : send(...)]");
        }
    }
    
    public void run()
    {  
       	ui.ta.append("\nServer Thread " + ID + " running.");
       	   keepRunning=true;
           while (keepRunning)
           {  
       	    try{  
       	    	   Message msg = (Message) streamIn.readObject();
       	    	   server.handle(ID, msg);
       	    	
               }
               catch(Exception ioe)
               {  
               	System.out.println(ID + " ERROR reading zzz: " + ioe.getMessage());
                   server.remove(ID);
                   keepRunning=false;
               }
           }
    }
    
    public int getID()
    {  
	    return ID;
    }
       
    public void close() throws IOException 
    {  
    	if (socket != null)    socket.close();
        if (streamIn != null)  streamIn.close();
        if (streamOut != null) streamOut.close();
    }
}
