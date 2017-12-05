package javaconcepts.threads;

public class RunnableDemo implements Runnable{

	//Thread th;
	RunnableDemo(String name)
    {
     //  th=new Thread(this,name);//second step is to create a thread object using runnable as argument and then call the start method
      // th.start();
       
    }
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" started here...... ");
		for(int i=0;i<4;i++)
        {
           System.out.println(" Inside "+name+"  i= "+i);
           try
           {
             Thread.sleep(1000);
           }catch(Exception e)
           {
             System.out.println("Error is "+e);
           }
        }
           System.out.println(name+" ends here=======>");
		
	}
	

	public static void main(String[] args) {
		 Runnable r1 = new RunnableDemo("Test1");
		 Runnable r2 = new RunnableDemo("Test2");
		 new ThreadDemo(r1).start();
		 //new Thread(r2).start();
		 Thread  th1=Thread.currentThread();
		 for(int i=0;i<4;i++)
	        {
              System.out.println(" Inside "+th1.getName()+"    i= "+i);
	             try
	             {
	               Thread.sleep(1000);
	             }catch(Exception e)
	             {
	                System.out.println("Error is "+e);
	             }
      	}
			
      	System.out.println(th1.getName()+"  thread ends here=======>");
	}

}
