package presentation_layer;

import java.util.*;
import java.util.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiC extends JFrame implements Observer, ActionListener {
	private List<Observer> observers = new ArrayList<Observer>();

	JFrame jf = new JFrame("Chef");
	JPanel pane = new JPanel();
	JLabel l0 = new JLabel("@Chef");
	JLabel wt = new JLabel("Waiting new order.");
	JLabel ready = new JLabel("Food is ready!");
	JLabel thick;
	Font f = new Font("SansSerif", Font.BOLD, 17);
	JButton takeFood = new JButton(" Take it to the client");
 
	public GuiC() {
		ImageIcon img = new ImageIcon("thick.png");
		thick = new JLabel(img);
		layout();
		defop();
	}

	public void layout() {
		pane.setLayout(null);
		l0.setBounds(30, 25, 100, 30);
		l0.setFont(f);
		wt.setBounds(100, 100, 150, 20);
		ready.setBounds(100, 100, 150, 20);

		thick.setBounds(140, 160, 95, 87);

		takeFood.setBounds(100, 280, 150, 30);

		takeFood.setBackground(new Color(255, 250, 100));

		pane.setBackground(new Color(250, 240, 200));

		takeFood.addActionListener(this);

		pane.add(wt);
		pane.add(l0);
	}
	

	public void defop() {
		jf.setSize(350, 380);
		jf.setContentPane(pane);
		jf.setResizable(false);
		jf.setLocation(300, 65);
	}

	public void update(Observable arg0, Object arg1) {
		Timer t=new Timer();
		wt.setText("           Cooking.....");
		

		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		               wt.setText("          Food is  ready!"); // your code here
		               pane.add(thick);
		               pane.add(takeFood);
		               pane.repaint();
		            }
		        }, 
		        6000 
		);
		
		
		
		
	}

	public void actionPerformed(ActionEvent arg) {
       
			wt.setText("Waiting a new order.");
			pane.remove(thick);
			pane.remove(takeFood);
			pane.repaint();
	}
}
