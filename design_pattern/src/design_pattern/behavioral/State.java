package design_pattern.behavioral;

/*
 * It lets you change the behavior of a class when the state changes.
 */

class StopWatch {
	StopWatchState state;
	public void start() {state.start();}
	public void stop() {state.stop();}
	public void pause() {state.pause();}
	public void resume() {state.resume();}
	//should be called by other class like StopWatchState class. 
	//other approach is to let this class only change state in each of hthe above method
	//Not the method below is not public
	void setState(StopWatchState state) {this.state  = state;}
}

interface StopWatchState{
	public void start();
	public void stop();
	public void pause();
	public void resume(); 
}
class Running implements StopWatchState {
	StopWatch stopWatch;
	Running(StopWatch stopWatch){
		this.stopWatch = stopWatch;
	}
	public void start() {throw new RuntimeException("StopWatch is already running");}
	public void stop() {
		System.out.println("Stop Watch is stopped");
		stopWatch.setState(new Idle());
	}
	public void pause() {
		System.out.println("Stop Watch is paused");
		stopWatch.setState(new Suspended());
	}
	public void resume() {throw new RuntimeException("StopWatch is already running");}
}
//Accordingly immplement other States
class Idle implements StopWatchState {
	public void start() {}
	public void stop() {}
	public void pause() {}
	public void resume() {}
}
class Suspended implements StopWatchState {
	public void start() {}
	public void stop() {}
	public void pause() {}
	public void resume() {}
}
public class State {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
