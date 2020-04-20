package queues;
import java.util.*;
public class Client {
	private int arrival;
	private int finish=0;
	private int service;
	
	public Client(int a, int s) {
		this.arrival=a;
		this.service=s;
		this.finish=this.arrival+this.service;
	}

	public int getService() {
		return service;
	}

	public void serving() {
		this.service--;
	}
	public int  waiting() {
		int waiting=0;
		waiting=this.finish-this.service-this.arrival;
		if(waiting<0)
			return 0;
		return waiting;
	}

	public int getArrival() {
		return arrival;
	}
	
	public int getFinish() {
		
		return this.arrival+this.service;
	}
	
public String toString() {
	return "   Timpul de servire necesar al clientului: "+getService()+"\n";
}
}
