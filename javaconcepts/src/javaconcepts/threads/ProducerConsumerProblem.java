package javaconcepts.threads;

import java.util.LinkedList;
import java.util.Queue;

class Resource {

	//queue as fixed buffer size
    Queue<Integer> q = new LinkedList<Integer>();
    int bufferSize = 10;

    synchronized void get(Thread t) 
    {
        if (q.isEmpty()) 
        {
            try 
            {
			    System.out.println(t.getName()+" is now in wait state");
                wait();
				System.out.println(t.getName()+" is now in "+t.getState());
                
            } 
            catch (InterruptedException e) 
            {
                System.out.println("InterruptedException caught");
            }
        }
        else
        {
        	System.out.println(t.getName()+" "+"["+t.getId()+"]"+" csume<--"+q.remove()+" buffer size= "+q.size());
        	notifyAll();
        }
        try 
        {
            Thread.sleep(90);
        } 
        catch (InterruptedException e) 
        {
            System.out.println("Exception Occured");
        
        }
    }

    synchronized void put(int x, Thread t) 
    {
        if (q.size() >= bufferSize) 
        {
            try 
            {
                System.out.println(t.getName()+" is now in wait state");
                wait();
				System.out.println(t.getName()+" is now in "+t.getState());
            } 
            catch (InterruptedException e) 
            {
                System.out.println("InterruptedException caught");
            }
        }
        if(q.size() < bufferSize)
        {
	        q.add(x);
	        System.out.println(t.getName()+" "+"["+t.getId()+"]"+" feeds-->"+x+" buffer size= "+q.size());
	        notifyAll();
	    }
        try 
        {
            Thread.sleep(100);
        } 
        catch (InterruptedException e) 
        {
            System.out.println("catch of sleep");
        }
    }
}

class Producer implements Runnable 
{
    Resource qp;
    Thread t;

    Producer(Resource q, String name) 
    {
        this.qp = q;
        t = new Thread(this,name);
        t.start();
    }

    public void run() 
    {
        int i = 0;

        while (i<4) 
        {
            qp.put(i++,t);

        }
    }
}

class Consumer implements Runnable 
{

    Resource qc;
    Thread t;
    Consumer(Resource q,String name) 
    {

        this.qc = q;
        t = new Thread(this,name);
        t.start();
    }

    public void run()  	
    {
        while (true) 
        {
            qc.get(t);
        }

    }
}

public class ProducerConsumerProblem 
{

    public static void main(String[] args)
	{
	Resource q = new Resource();
    Producer p1 = new Producer(q,"producer 1");
    Producer p2 = new Producer(q,"producer 2");
    Consumer c1 = new Consumer(q,"consumer 1");
    Consumer c2 = new Consumer(q,"consumer 2");
	try
	{
	  
	  p1.t.join();
	  p2.t.join();
	  c1.t.join();
	  c2.t.join(); 
	  
	}catch(Exception e){e.printStackTrace();}
    }
}
 