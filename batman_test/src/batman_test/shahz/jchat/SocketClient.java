package batman_test.shahz.jchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SocketClient implements Runnable
{
	public int port;
    public String serverAddr;
    public Socket socket;
    public ClientGui gui;
    public ObjectInputStream in;
    public ObjectOutputStream out;
    public boolean keepRunning;
    SocketClient(ClientGui ui) throws IOException
    {
    	gui=ui;
    	serverAddr=ui.serverAddr;
    	this.port =ui.port;
    	socket = new Socket(InetAddress.getByName(serverAddr), port);
    	out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
    }
    
    @SuppressWarnings({ "unchecked" })
	@Override
	public void run() //thread running to receive messages
    {
    	keepRunning = true;
    	Message msg;
        while(keepRunning)
        {
        	try
        	{
        		System.out.println("msg");
        		msg=(Message)in.readObject();
        		System.out.println("in msg");
        		if(msg.type.equals("message"))
        		{
        			if(msg.recipient.equals(gui.username))
        			{
                        gui.ta.append("["+msg.sender +" > Me] : " + msg.content + "\n");
                    }
        			else if(msg.sender.equals(gui.username))
        			{
                        //gui.ta.append("["+ msg.sender +" > "+ msg.recipient +"] : " + msg.content + "\n");
                        gui.ta.append("[ Me > "+ msg.recipient +"] : " + msg.content + "\n");
                    }
        			else
        			{
        				gui.ta.append("["+ msg.sender +" > "+ msg.recipient +"] : " + msg.content + "\n");
        			}
        		}
        		else if(msg.type.equals("login"))
        		{
        			if(msg.content.equals("TRUE"))
        			{
        				System.out.println("loginng success");
        				gui.ta.append("[SERVER > Me] : Login Successful\n");
        				gui.b2.setEnabled(false);
        				gui.b4.setEnabled(true);
        				gui.t3.setEnabled(false);
            			gui.t4.setEnabled(false);
            			gui.b0.setEnabled(true);//disconnect
            			gui.model.addElement("                  **Online Friends**\n");
            			gui.model.addElement("All");
            			
        			}
        			else
        			{
        				JOptionPane.showMessageDialog(gui,"Either username or password is not correct");
        			}
        		}
        		else if(msg.type.equals("newuser"))
        		{
        			if(!msg.content.equals(gui.username))
        			{
                        boolean exists = false;
                        for(int i = 0; i < gui.model.getSize(); i++)
                        {
                            if(gui.model.getElementAt(i).equals(msg.content))
                            {
                                exists = true; break;
                            }
                        }
                        if(!exists){ gui.model.addElement(msg.content); }
                    }
        		}
        		else if(msg.type.equals("signout"))
        		{
                    if(msg.content.equals(gui.username))
                    {
                        gui.ta.append("["+ msg.sender +" > Me] : Bye\n");
                        gui.b1.setEnabled(true); 
                        gui.b4.setEnabled(false); 
                        gui.t1.setEnabled(true); 
                        gui.t2.setEnabled(true);
                        gui.b0.setEnabled(false);//disconnect
            			gui.model.removeAllElements();
                        //gui.clientThread.stop();
                        this.close();
                        keepRunning=false;
                    }
                    else
                    {
                        gui.model.removeElement(msg.content);
                        gui.ta.append("["+ msg.sender +" > All] : "+ msg.content +" has signed out\n");
                    }
                    
                }
        		else if(msg.type.equals("signup"))//will implement it later
        		{
        			
        		}
        		else if(msg.type.equals("test"))
        		{
        			gui.b1.setEnabled(false);
        			gui.t1.setEnabled(false);
        			gui.t2.setEnabled(false);
        			gui.b2.setEnabled(true);//login
        			gui.t3.setEnabled(true);
        			gui.t4.setEnabled(true);
        		}
        		else if(msg.type.equals("serverdown"))
        		{
        		
        			gui.ta.append("["+ msg.sender +" > Me] : Bye Server shutting down :(\n\t\tBut Have a cheerful day  :)\n");
                    gui.b1.setEnabled(true); //connect
                    gui.b4.setEnabled(false); //send
                    gui.t1.setEnabled(true); //host address field
                    gui.t2.setEnabled(true);//port address fielld
                    gui.b0.setEnabled(false);//disconnect
        			gui.model.removeAllElements();
                   // this.close();
                    keepRunning=false;
        		}
        		
        	}
        	catch(Exception e)
        	{
        		System.out.println("connection error"+e);
        		keepRunning=false;
        	}        	
        }
		
	}
    
        
    public void sendMessage(Message msg)//function send messages to server
    {
    	try 
		{
            out.writeObject(msg);
            out.flush();
            System.out.println("Outgoing : "+msg.toString());
            
        } 
        catch (IOException ex) 
		{
            System.out.println("Exception SocketClient send()");
            gui.ta.append("[Application > Me] : Connection Error unable to send message\n");
        }
    }
    
    public void close()
    {
        try
        {
        
         if (out != null) out.close();
    	 if (in != null) in.close();
    	 if (socket != null) socket.close();
    	}catch(Exception e)
    	{
    		System.out.println("Unable to disconnect");
    	}
        
    }

	
}
