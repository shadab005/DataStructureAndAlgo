package batman_test.shahz.jchat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ClientGui extends JFrame
{

	private static final long serialVersionUID = 1L;
	public SocketClient client;
	public int port;
	public String serverAddr, username, password;
	public Thread clientThread;
	public JLabel l1,l2,l3,l4; 
	public JButton b1,b2,b3,b4,b5,b0;
	public JTextField t1,t2,t3,t4,t5;
	public JTextArea ta;
	public JScrollPane tAreaScrollPane,jsp;
	JPanel p1,p2,p3,p4,mp;
	@SuppressWarnings("rawtypes")
	public JList l;
	@SuppressWarnings("rawtypes")
	public DefaultListModel model;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ClientGui()
	{
		p1 = new JPanel(new GridLayout(2, 6, 10, 2));
		l1=new JLabel("  Host Address :");
		t1=new JTextField("localhost",20);
		l2=new JLabel("Host Port : ");
		t2=new JTextField("13000",7);
		b1=new JButton("connect");
		b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });
		l3=new JLabel("  Username :");
		t3=new JTextField(20);
		t3.setEnabled(false);
		l4=new JLabel("Password :");
		t4=new JPasswordField("",7);
		t4.setEnabled(false);
		b2=new JButton("login");
		b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });
		b2.setEnabled(false);
		b3=new JButton("signup");
		b3.setEnabled(false);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(b1);
		b0=new JButton("disconnect");
		b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jb0ActionPerformed(evt);
            }
        });
		b0.setEnabled(false);
		p1.add(b0);
		p1.add(l3);
		p1.add(t3);
		p1.add(l4);
		p1.add(t4);
		p1.add(b2);
		p1.add(b3);
		p1.setBorder(BorderFactory.createEtchedBorder(Color.gray,Color.LIGHT_GRAY));
		ta = new JTextArea(10,60);
		ta.setEditable(false);
	    //ta.setFont(new Font("Serif", Font.ITALIC, 13));
	    ta.setLineWrap(true);       // wrap line
	    ta.setWrapStyleWord(true);  // wrap line at word boundary
	    ta.setBackground(new Color(204, 238, 241)); // light blue
	    tAreaScrollPane = new JScrollPane(ta);
	    tAreaScrollPane.setBorder(BorderFactory.createEtchedBorder(Color.gray,Color.LIGHT_GRAY));
	    tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		l=new JList();
		l.setModel((model = new DefaultListModel()));
		
		l.setBorder(BorderFactory.createEtchedBorder(Color.gray,Color.LIGHT_GRAY));
		l4=new JLabel("   Message");
		t5=new JTextField();
		t5.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						
						jt5ActionPerformed(e);
					}
				}
		);
		b4=new JButton("       send       ");
		b4.setEnabled(false);
		b4.setSize(50,10);
		b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });
		p2=new JPanel(new BorderLayout(5,5));
		p2.add(l4,BorderLayout.WEST);
		p2.add(t5, BorderLayout.CENTER);
		p2.add(b4, BorderLayout.EAST);
		p2.setBorder(new EmptyBorder(0,0, 10, 10) );
		Container cp = this.getContentPane();
	    cp.setLayout(new BorderLayout(1,5));
	    cp.add(p1, BorderLayout.NORTH);
	    cp.add(tAreaScrollPane, BorderLayout.WEST);
	    cp.add(l, BorderLayout.CENTER);
	    cp.add(p2, BorderLayout.SOUTH);
		this.setTitle("jTalk");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(730, 450);
		this.setBounds(20, 20, 730, 450);
		//pack();
		this.setResizable(false);
		setVisible(true);
		this.addWindowListener(new WindowListener() {

            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) 
            { 
            	try{ 
            		if(client.keepRunning==true)
            		{	
            		 client.sendMessage(new Message("exit", username, ".bye", "SERVER"));
            		 client.close();
            		 client.keepRunning=false;
            		}
            		
            		}catch(Exception ex){} 
            	System.exit(0);
            }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) 
            {
            	t5.setFocusable(true);
            }
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) 
            {
            	t5.setFocusable(true);
            }
            @Override public void windowDeactivated(WindowEvent e) {}
        });
	}
	
	private void jb0ActionPerformed(ActionEvent evt)//disconnect button
	{
		try{ 
			t3.setEnabled(false);
			t4.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b0.setEnabled(false);
			b4.setEnabled(false);
			b1.setEnabled(true);
			t1.setEnabled(true);
			t2.setEnabled(true);
			client.sendMessage(new Message("signout", username, ".bye", "SERVER"));
    		}
		    catch(Exception ex){} 
		
	}
	private void jb1ActionPerformed(ActionEvent evt)//connect button
	{
		serverAddr=t1.getText();
		port=Integer.parseInt(t2.getText());
		   if(!serverAddr.isEmpty() && !t2.getText().isEmpty())
		   {
            try{
                client = new SocketClient(this);
                clientThread = new Thread(client);
                clientThread.start();
                client.sendMessage(new Message("test", "testUser", "testContent", "SERVER"));
            }
            catch(Exception ex){
                ta.append("[Application > Me] : Server not found\n");
            }
        }
		
	}
	private void jb2ActionPerformed(ActionEvent evt)//login button
	{
		username = t3.getText();
        password = t4.getText();
        model.removeAllElements();
        if(!username.isEmpty() && !password.isEmpty()){
            client.sendMessage(new Message("login",username,password,"SERVER"));
        }
	}
	private void jb4ActionPerformed(ActionEvent evt)//send button
	{
		String msg = t5.getText();
		if(l.getSelectedValue()!=null)
		{
	        String recipient = l.getSelectedValue().toString();
	        
	        if(!msg.isEmpty() && !recipient.isEmpty()){
	            t5.setText("");
	            client.sendMessage(new Message("message", username, msg, recipient));
	        }
		}
	}
	private void jt5ActionPerformed(ActionEvent evt)//message field
	{
		String msg = t5.getText();
		if(l.getSelectedValue()!=null)
		{
	        String recipient = l.getSelectedValue().toString();
	        
	        if(!msg.isEmpty() && !recipient.isEmpty()){
	            t5.setText("");
	             
	            client.sendMessage(new Message("message", username, msg, recipient));
	        }
		}
	}
	public static void main(String[] args) 
	{
		System.out.println("client application running");
		try 
		{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex)
        {
            System.out.println("Look & Feel exception");
        }
		SwingUtilities.invokeLater(new Runnable()
		{
	         @Override
	         public void run() {
	            new ClientGui(); // Let the constructor do the job
	         }
	      });
	}

}
