package queues;

import java.util.concurrent.ArrayBlockingQueue;

import gui.Gui;

public class Service implements Runnable {
static Gui g;
public ArrayBlockingQueue <Client> c;
public int removed=0;
public int stop=1;
public int wtime;
static int justServing;
public Service (Gui g,int a) {
	this.c=new ArrayBlockingQueue<Client>(30);
	this.g=g;
	this.justServing=a;
}
public synchronized void addClients (Client cl) throws InterruptedException{
	this.c.put(cl);
	inc(cl.getService());
}
public void stop() {
	this.stop=1;
}
public void start() {
	this.stop=0;
}
public void inc(int time) {
	this.wtime+=time;
}
public void dec(int time) {
	this.wtime-=time;
}
public int getWtime() {
	return this.wtime;
}
public ArrayBlockingQueue<Client> getC(){
	return this.c;
}
public void run() {
	while(stop==1) {
		if(!c.isEmpty()) {
			Client client=c.peek();
			if(client.getService()>0)
				client.serving();
			else
			{
				c.remove();		
				 g.displayLog("   Un nou client a fost servit de casa si a parasit coada.\n\n");
				}}
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
	}
	Thread.currentThread().interrupt();
	
}
}
