package presentation_layer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GuiU extends JFrame implements ActionListener {
    public GuiA a;
    public GuiW w;
   public  GuiC c;
	JFrame jf=new JFrame("User");
	JPanel pane=new JPanel();

	JLabel l0=new JLabel("Choose user:");
	JLabel l1=new JLabel("@PlanetGRILLRestaurants");
	
	Font f= new Font("Calibri",Font.BOLD,20);
	Font ff= new Font("Calibri",Font.BOLD,17);
	Font fff= new Font("Calibri",Font.ITALIC,12);

	JButton b1=new JButton("Administrator ");
	JButton b2=new JButton("Waiter");
	JButton b3=new JButton("Chef ");

	//constructor
	public GuiU(GuiA a,GuiW w, GuiC c) {
		this.a=a;
		this.c=c;
		this.w=w;
		layout();
		adaugareComponente();
		defop();
	}
	
	//sranjarea componentelor
	public void layout() {
		pane.setLayout(null);
		l0.setBounds(50, 30, 200, 30);
		l0.setFont(f);
		
		l1.setFont(fff);
		
		b1.setBounds(60, 70, 140, 30);
		b1.setFont(ff);
		b2.setFont(ff);
		b3.setFont(ff);
		b2.setBounds(60, 120, 140, 30);
		b3.setBounds(60, 170, 140, 30);
		
		l1.setBounds(63, 217, 140, 30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b1.setBackground(new Color(60,90,20));
		b2.setBackground(new Color(60,110,20));
		b3.setBackground(new Color(60,130,20));
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		b3.setForeground(Color.WHITE);
		 pane.setBackground(new Color(250,240,200));
		
	}

	public void adaugareComponente() {

		pane.add(l0);
		pane.add(l1);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		
	}
	/*
	public  void ed1Listener(ActionListener m) {
		edc.addActionListener(m);
	}
	public  void ed2Listener(ActionListener m) {
		edp.addActionListener(m);
	}
	
	public  void orderListener(ActionListener m) {
		order.addActionListener(m);
	}
*/
	
	
	
	
	public void defop() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(260, 275);	
		jf.setContentPane(pane);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(10, 5);
	}

	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		JButton button=(JButton) arg.getSource();
		
		 if(button.equals(b1)) {
			 a.jf.setVisible(true);		 
		 }
		 if(button.equals(b2)) {
			 w.jf.setVisible(true);		 
		 }
		 if(button.equals(b3)) {
			 c.jf.setVisible(true);		 
		 }
	}
	

}

