package module.uber;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;

/*
 * Server side class to request cabs so that it can be assigned a trip.
 */
public class CabSelector {

	Executor executor;
	CabServiceConnectionManager cabServiceConnectionManager;
	
	public Cab requestAll(List<Cab> cabs) {
		RequestPacket requestPacket = new RequestPacket();
	    for(Cab cab: cabs) {
	    	executor.execute(new CabRequestInvokerTask(requestPacket, cabServiceConnectionManager.getCabService(cab.getId()), cab));
	    }
	    Cab cab = requestPacket.getCab();
		return cab;
	}
	
	
	private class CabRequestInvokerTask implements Runnable{
		RequestPacket requestPacket;
		CabService cabService;
		Cab cab;
		CabRequestInvokerTask(RequestPacket r, CabService s, Cab cab){
			requestPacket = r;
			cabService = s;
			this.cab = cab;
		}
		
		public void run() {
			while(!requestPacket.done) {
			   boolean hasAccepted = cabService.requestForRideConfirmation();
			   if(hasAccepted) requestPacket.accept(cab);
			   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	}
	
	private class RequestPacket{
		//Single size queue
		SynchronousQueue<Cab> queue;
		private boolean done;
		
		RequestPacket(){
			queue = new SynchronousQueue<>();
		}
		
		public Cab getCab() {
			Cab cab = null;
			try {
				cab = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			done = true;
			return cab;
		}
		
		public void accept(Cab cab) {
			try {
				queue.put(cab);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
