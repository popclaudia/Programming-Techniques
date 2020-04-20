package simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import gui.Gui;
import queues.Client;
import queues.Program;
import queues.Service;
import as2.Assignment2.Main;


public class Simulator implements Runnable {
	 Program p;
	 Gui g;
	 int minAr = 0;
	 int maxAr = 7;
	 int minServ =4;
	 int maxServ = 55;
	 int numberQueues = 5;
	 int simulationTime = 566666;
	 int currentTime = 0;
	 int finishComing=0;
	 
	 //avg
	 public int totalTime=0;
	 public int clNo=0;
		 
		public Simulator(Gui g) {
			this.g=g;
			this.g.startListener(new StartListener());	
		}
		
		class StartListener implements ActionListener{

			public void actionPerformed(ActionEvent arg0) {

				minAr=Integer.parseInt(g.getarg1());
				maxAr=Integer.parseInt(g.getarg2());
				minServ=Integer.parseInt(g.getarg3());
				maxServ=Integer.parseInt(g.getarg4());
				numberQueues=Integer.parseInt(g.getarg5());
				simulationTime=Integer.parseInt(g.getarg6());
				
	            p=new Program(numberQueues,g,finishComing);
	            p.startService();
	            Main m=new Main();
	            m.startSimulation();
			}
		}
		private void incTime (int period) {
			this.totalTime += period;
		}
		private void incClients() {
			this.clNo++;
		}
		private float getAverageServiceTime() {
			return totalTime/(float)clNo;
		}
		//generate a random client in a period of time
		private static Client generateRandomClient (int time,int minService, int maxService) {
			Random random = new Random();
			int service = minService+random.nextInt(maxService - minService +1 );
			return new Client(time, service);
		}
		
		public void run() {
            int servT=0,emptyT=0;
			while(currentTime < simulationTime) {
				Client client = generateRandomClient(currentTime, minServ, maxServ);
				clNo ++;
				incTime(client.getService());
				servT+=client.getService();
				
				if(client.getArrival()<=currentTime) {
				try {
					p.distr(client);
					g.displayLog(p.toString(clNo));
					g.displayLog("\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				}
				g.displayLog(client.toString());
				g.displayLog("\n");
				try {
					currentTime ++;
					for(int i=0;i<p.getS().size();i++) {
						StringBuilder stringBuilder = new StringBuilder();
						for(Client c : p.getS().get(i).getC()) {
							stringBuilder.append(" ☺ ");
						}
						g.displayQ(stringBuilder.toString(), i);
					}
					//the time until the next client comes
					Random random = new Random();
					int rand = minAr+random.nextInt(maxAr-minAr);
					
					Thread.sleep(1000);
				   Thread.sleep(rand*1000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		}   int notEmpty=1;
		emptyT=servT;
			while(notEmpty!=0) {
				notEmpty=0;
						for(int k=0;k<p.getS().size();k++)
							if(p.s.get(k).c.size()>0)
								notEmpty++;
						
				for(int i=0;i<p.getS().size();i++) {
					StringBuilder stringBuilder = new StringBuilder();
					for(Client c : p.getS().get(i).getC()) {
						stringBuilder.append(" ☺ ");
					}
					g.displayQ(stringBuilder.toString(), i);
				}
				currentTime ++;
			}
			for(Service s: p.getS()) {
				s.stop();
			}
			g.displayResults("   \n  End of simulation process.\n");
			g.displayResults("       ○ The average waiting time is:\n");
			g.displayResults("             • "+getAverageServiceTime()+" minute.\n");
			g.displayResults("       ○ Serving time:\n");
			g.displayResults("             • "+servT+" minute.\n");
			g.displayResults("       ○ Average empty time for a queue:\n");
			g.displayResults("             • "+ totalTime/(float)numberQueues+" minute.\n");
			Thread.currentThread().interrupt();
			currentTime=0;
			clNo=0;
			totalTime=0;
			
	}
	
	
}
