package PT2019.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import PT2019.operatii.App;

import javax.swing.*;

public class Gui extends JFrame {

	JFrame jf=new JFrame("Calculator de polinoame");

	JPanel in=new JPanel();
	JPanel butoane=new JPanel();
	JPanel intDef=new JPanel();
	JPanel out=new JPanel();
	JPanel pane=new JPanel();

	JLabel l1=new JLabel("Introduceți primul polinom:");
	JLabel l2=new JLabel("Introduceți cel de-al doilea polinom:");
	JLabel l3=new JLabel("Rezultatul operației:");
	JLabel l4=new JLabel("    Selectați operația:");
	JLabel mesaj=new JLabel("",SwingConstants.LEFT);

	JTextField tf1=new JTextField(30);
	JTextField tf2=new JTextField(30);
	JTextField tf3=new JTextField(60);

	Font f= new Font("SansSerif",Font.ITALIC,16);

	JButton op1=new JButton("   +   ");
	JButton op2=new JButton("   -   ");
	JButton op3=new JButton("   *   ");
	JButton op4=new JButton("   /   ");
	JButton op5=new JButton("   '   ");
	JButton op6=new JButton("   ∫   ");

	public Gui() {
		layout();
		adaugareComponente();
		defop();
	}
	public void layout() {

		tf3.setEnabled(false);
		l1.setFont (l1.getFont ().deriveFont (17.0f));
		l2.setFont (l2.getFont ().deriveFont (17.0f));
		l3.setFont (l3.getFont ().deriveFont (17.0f));
		l4.setFont (l4.getFont ().deriveFont (14.0f));
		op1.setFont (op1.getFont ().deriveFont (20.0f));
		op2.setFont (op2.getFont ().deriveFont (20.0f));
		op3.setFont (op3.getFont ().deriveFont (20.0f));
		op4.setFont (op4.getFont ().deriveFont (20.0f));
		op5.setFont (op5.getFont ().deriveFont (20.0f));
		op6.setFont (op6.getFont ().deriveFont (20.0f));

		tf1.setFont(f);
		tf2.setFont(f);
		tf3.setFont(f);

		in.setLayout(new BoxLayout(in,BoxLayout.Y_AXIS));
		butoane.setLayout(new BoxLayout(butoane,BoxLayout.X_AXIS));
		intDef.setLayout(new BoxLayout(intDef,BoxLayout.X_AXIS));
		out.setLayout(new BoxLayout(out,BoxLayout.Y_AXIS));
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));

		in.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		butoane.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		intDef.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 140));
		out.setBorder(BorderFactory.createEmptyBorder(1, 10, 15, 10));
		pane.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 10));
		mesaj.setForeground(Color.RED);
	}

	public void adaugareComponente() {

		in.add(l1);
		in.add(tf1);
		in.add(l2);
		in.add(tf2);
		in.add( Box.createRigidArea(new Dimension(0,15)) );
		in.add(l4);

		butoane.add(op1);
		butoane.add( Box.createRigidArea(new Dimension(15,0)) );
		butoane.add(op2);
		butoane.add( Box.createRigidArea(new Dimension(15,0)) );
		butoane.add(op3);
		butoane.add( Box.createRigidArea(new Dimension(15,0)) );
		butoane.add(op4);
		butoane.add( Box.createRigidArea(new Dimension(15,0)) );
		butoane.add(op5);
		butoane.add( Box.createRigidArea(new Dimension(15,0)) );
		butoane.add(op6);
		pane.add( Box.createRigidArea(new Dimension(0,15)) );

		out.add(l3);
		out.add(tf3);
		out.add( mesaj );

		pane.add(in);
		pane.add(butoane);
		pane.add(intDef);
		pane.add( Box.createRigidArea(new Dimension(0,15)) );
		pane.add(out);
		pane.add( Box.createRigidArea(new Dimension(0,30)) );
	}

	public void addListener(ActionListener m) {
		op1.addActionListener(m);
	}
	public void mulListener(ActionListener m) {
		op3.addActionListener(m);
	}
	public void divListener(ActionListener m) {
		op4.addActionListener(m);
	}
	public void subListener(ActionListener m) {
		op2.addActionListener(m);
	}
	public void derListener(ActionListener m) {
		op5.addActionListener(m);
	}
	public  void intListener(ActionListener m) {
		op6.addActionListener(m);
	}

	public String getFirstPolinom(){
		return tf1.getText();
	}
	public String getSecondPolinom(){
		return tf2.getText();
	}

	public void displayErrorMessage(String m) {
		mesaj.setText(m);
	}
	public void setResult(String polinom) {
		tf3.setText(polinom);
	}

	public void defop() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(650, 430);	
		jf.setContentPane(pane);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(5, 5);
	}

}
