package batman_test.shahz.jchat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class ServerGui extends JFrame
{
	private static final long serialVersionUID = 1L;
	public SocketServer server;
    public Thread serverThread;
	public JButton b1,b2;
	public JTextArea ta;
	public JTextField tf;
	public JScrollPane tAreaScrollPane;
	public JPanel p1;
	public ServerGui()
	{
	 b1=new JButton("start server");
	 b1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
             jb1ActionPerformed(evt);
         }
     });
	 b2=new JButton("  terminate ");
	 b2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
             jb2ActionPerformed(evt);
         }
     });
	 tf=new JTextField("13000",10);
	 b2.setEnabled(false);
	 p1=new JPanel();
	 p1.add(new JLabel("port no:"));
	 p1.add(tf);
	 p1.add(b1);
	 p1.add(b2);
	 p1.setBorder(BorderFactory.createEtchedBorder(Color.gray,Color.BLACK));
	 ta = new JTextArea(10,60);
	 ta.setLineWrap(true);       // wrap line
	 ta.setWrapStyleWord(true);  // wrap line at word boundary
	 ta.setBackground(new Color(204, 238, 241)); // light blue
	 tAreaScrollPane = new JScrollPane(ta);
	 tAreaScrollPane.setBorder(BorderFactory.createEtchedBorder(Color.gray,Color.BLACK));
	 tAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	 Container cp = this.getContentPane();
	 cp.setLayout(new BorderLayout(5, 5));
	 cp.add(p1, BorderLayout.NORTH);
	 cp.add(tAreaScrollPane, BorderLayout.CENTER);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setTitle("jServer");
	 setSize(730, 450);
	 setVisible(true);
	}
	
	private void jb1ActionPerformed(ActionEvent evt)//start server button
	{
		server = new SocketServer(this,Integer.parseInt(tf.getText()));
		b1.setEnabled(false);
        b2.setEnabled(true);
        tf.setEnabled(false);
	}
	private void jb2ActionPerformed(ActionEvent evt)//terminate button
	{
		ta.append("Server terminating....");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		ta.setText("");
		b2.setEnabled(false);
		b1.setEnabled(true);
		//server.stop();
		System.out.println("Announcing sever going down");
		server.Announce("serverdown", "SERVER", "goodbye");	
		System.out.println("stoping client thread");
		server.stopClientThread();
		System.out.println("server closing");
		server.close();
		System.out.println("server stopping");
		server.stop();
		System.out.println("successful stop");
		
	}
	public static void main(String[] args) 
	{
		System.out.println("server application running");
		try 
		{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception ex)
        {
            System.out.println("Look & Feel exception");
        }
		SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new ServerGui(); // Let the constructor do the job
	         }
	      });
	}

}