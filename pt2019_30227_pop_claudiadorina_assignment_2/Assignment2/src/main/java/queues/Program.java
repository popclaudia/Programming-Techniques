package queues;

import java.util.ArrayList;

import gui.Gui;
import simulation.Simulator;

public class Program {
	Simulator sim;
	public ArrayList<Service> s;
	private int snr;
	
	public Program(int nr,Gui g,int a) {
		this.snr=nr;
		s=new ArrayList<Service>();
       addServices(nr,g,a);
	}
	public void addServices(int nr,Gui g,int a) {
		for(int i=0;i<nr;i++) 
			s.add(new Service(g,a) );	
	}

	public ArrayList<Service> getS() {
		return s;
	}

	public int getSnr() {
		return snr;
	}

	public void setSnr(int snr) {
		this.snr = snr;
	}
	
	public void startService() {
		for(Service ss:s) {
			Thread t=new Thread(ss);
			t.start();
		}
		
	}
	
	public int getEcoQueue() {
		int min=10000;
		int orderNumber=0;
		for(int i=0;i<snr;i++)
			if(s.get(i).getWtime()<min) {
			min=s.get(i).getWtime();
			orderNumber=i;
			}
		return orderNumber;
	}
	
	public void distr(Client client)throws InterruptedException{
		int i=getEcoQueue();
		s.get(i).inc(client.getService());
		s.get(i).addClients(client);
	}
	
public String toString(int clNb) {
	return "   Clientul "+clNb  +" s-a asezat la coada "+ getEcoQueue()+".";
}
}
