package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame {

	JFrame jf=new JFrame(" Queuing based system");

	JPanel in=new JPanel();
	JPanel out=new JPanel();
	JPanel st=new JPanel();
	JPanel qus=new JPanel();
	JPanel pane=new JPanel();

	JLabel l1=new JLabel("Minimum interval of arriving time:");
	JLabel l2=new JLabel("Maximum interval of arriving time:");
	JLabel l3=new JLabel("Minimum service time:");
	JLabel l4=new JLabel("Maximum service time:");
	JLabel l5=new JLabel("Number of queues:");
	JLabel l6=new JLabel("Simulation interval:");
	JLabel res=new JLabel("Simulation results:");

	JTextField tf1=new JTextField(5);
	JTextField tf2=new JTextField(5);
	JTextField tf3=new JTextField(5);
	JTextField tf4=new JTextField(5);
	JTextField tf5=new JTextField(5);
	JTextField tf6=new JTextField(5);
	JTextField tf7=new JTextField(5);
	JTextField tf8=new JTextField(5);

	JTextArea q[]=new JTextArea[5];
	JTextArea log=new JTextArea(6,20);
	JTextArea results=new JTextArea(6,20);

	JScrollPane s=new JScrollPane(log);
	JScrollPane s2=new JScrollPane(results);
	
	Font f= new Font("SansSerif",Font.ITALIC,14);

	JButton start=new JButton("Start simulation ");

	//constructor
	public Gui() {
		text();
		layout();
		adaugareComponente();
		defop();
	}
	//crearea zonei pentru afisarea evolutiei cozilor
	public void text() {
		for(int i=0;i<5;i++) {
			q[i]=new JTextArea(1,20);
			q[i].setFont(q[i].getFont ().deriveFont (28f));
			q[i].setForeground(new Color(128,0,128));
			q[i].setBackground(new Color(250,245,210));
			
		}
	}
	//sranjarea componentelor
	public void layout() {
		start.setFont (start.getFont ().deriveFont (13.5f));
		start.setAlignmentX(CENTER_ALIGNMENT);
		res.setAlignmentX(CENTER_ALIGNMENT);
		results.setAlignmentX(CENTER_ALIGNMENT);
		results.setEditable(false);
		tf1.setPreferredSize(new Dimension(1,3));
		q[0].setEditable(false);
		q[1].setEditable(false);
		q[2].setEditable(false);
		q[3].setEditable(false);
		q[4].setEditable(false);
		log.setEditable(false);
		log.setFont(log.getFont ().deriveFont (14f));
        qus.setLayout(new BoxLayout(qus,BoxLayout.Y_AXIS));
		in.setLayout(new GridLayout(6,2,5,5));
		out.setLayout(new BoxLayout(out,BoxLayout.Y_AXIS));
		st.setLayout(new BoxLayout(st,BoxLayout.Y_AXIS));
		pane.setLayout(new GridLayout(2,2,5,5));
		in.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		qus.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		out.setBorder(BorderFactory.createEmptyBorder(1, 10, 15, 10));
		pane.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
		st.setBorder(BorderFactory.createEmptyBorder(10, 20, 30, 20));
	}

	public void adaugareComponente() {

		in.add(l1);
		in.add(tf1);
		in.add(l2);
		in.add(tf2);
		in.add(l3);
		in.add(tf3);
		in.add(l4);
		in.add(tf4);
		in.add(l5);
		in.add(tf5);
		in.add(l6);
		in.add(tf6);
		
		qus.add(q[0]);
		qus.add( Box.createRigidArea(new Dimension(0,7)) );
		qus.add(q[1]);
		qus.add( Box.createRigidArea(new Dimension(0,7)) );
		qus.add( q[2] );
		qus.add( Box.createRigidArea(new Dimension(0,7)) );
		qus.add( q[3] );
		qus.add( Box.createRigidArea(new Dimension(0,7)) );
		qus.add( q[4]);
		
		out.add( s );

		pane.add(in);
		pane.add(qus);
		pane.add(st);
		st.add(start);
		st.add( Box.createRigidArea(new Dimension(0,7)) );
		st.add(res);
		st.add( Box.createRigidArea(new Dimension(0,7)) );
		st.add(s2);
		pane.add(out);
	}
	
	
	public void startListener(ActionListener m) {
		start.addActionListener(m);
	}
	public String getarg1(){
		return tf1.getText();
	}
	public String getarg2(){
		return tf2.getText();
	}
	public String getarg3(){
		return tf3.getText();
	}
	public String getarg4(){
		return tf4.getText();
	}
	public String getarg5(){
		return tf5.getText();
	}
	public String getarg6(){
		return tf6.getText();
	}

	public void displayQ(String m,int i) {
		q[i].setText(m);
	}

	public void displayLog(String m) {
		log.append(m);
	}
	public void displayResults(String m) {
		results.append(m);
	}

	public void defop() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(870, 550);	
		jf.setContentPane(pane);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(5, 5);
	}

}
