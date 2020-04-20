package as2.Assignment2;

import gui.Gui;
import queues.Program;
import simulation.Simulator;


public class Main  {
	static Simulator s;
	public void startSimulation() {
		 Thread thread = new Thread(s);
         thread.start();
	}

  public static void main (String[] args) {
	 Gui g=new Gui();
	 s=new Simulator(g);
  }

}