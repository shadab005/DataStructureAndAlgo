package javaconcepts.threads;

public class RunnableDemo implements Runnable{

	Thread th;
	RunnableDemo(String name)
    {
       th=new Thread(this,name);//second step is to create a thread object using runnable as argument and then call the start method
       th.start();
       System.out.println(th.getName()+" started here...... ");
    }
	
	@Override
	public void run() {
		for(int i=0;i<4;i++)
        {
           System.out.println(" Inside "+th.getName()+"  i= "+i);
           try
           {
             th.sleep(1000);
           }catch(Exception e)
           {
             System.out.println("Error is "+e);
           }
        }
           System.out.println(th.getName()+" ends here=======>");
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 RunnableDemo rd=new RunnableDemo("Test1");
		 RunnableDemo rd2=new RunnableDemo("Test2");
		 Thread  th1=Thread.currentThread();
		 for(int i=0;i<4;i++)
	        {
              System.out.println(" Inside "+th1.getName()+"    i= "+i);
	             try
	             {
	               th1.sleep(1000);
	             }catch(Exception e)
	             {
	                System.out.println("Error is "+e);
	             }
      	}
			
      	System.out.println(th1.getName()+"  thread ends here=======>");
	}

}
