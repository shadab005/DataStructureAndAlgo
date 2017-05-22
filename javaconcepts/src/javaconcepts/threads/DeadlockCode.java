package javaconcepts.threads;

public class DeadlockCode {

	
	/*
	 * wait(p)   wait(q)
	 * wait(q)   wait(p)
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resources q = new Resources();
	    Producers p1 = new Producers(q,"producer 1");
	    Consumers c1 = new Consumers(q,"consumer 1");
	    System.out.println("Exiting Main");
	}

}

class Resources {
	String r1="resource 1";
	String r2="resource 2";
	void getP(String name){
		synchronized (r1) {
			System.out.println("Aquired r1 by " + name);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Waiting for r2 by " + name);
			synchronized (r2) {
				System.out.println("Held r2 by " + name);
			}
		}
		
	}
    void getQ(String name){
    	synchronized (r2) {
    		System.out.println("Aquired r2 by " + name);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Waiting for r1 by " + name);
			synchronized (r1) {
				System.out.println("Held r1 by " + name);	
			}
		}
	}
}

class Producers implements Runnable {

	Resources r;
	Thread t;
	String name;
	Producers(Resources q, String name) 
    {
        this.r = q;
        this.name=name;
        t = new Thread(this,name);
        t.start();
    }
	@Override
	public void run() {
		r.getP(name);
	}
	
}
class Consumers implements Runnable {

	Resources r;
	Thread t;
	String name;
	Consumers(Resources q, String name) 
    {
		this.name=name;
        this.r = q;
        t = new Thread(this,name);
        t.start();
    }
	@Override
	public void run() {
		r.getQ(name);
	}
	
}
