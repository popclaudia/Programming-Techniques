package presentation_layer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GuiA extends JFrame {

	JFrame jf=new JFrame("Administrator");

	JPanel pane=new JPanel();

	JLabel l0=new JLabel("@Administrator");
	
      
	public JRadioButton base=new JRadioButton("Composite Product",true);
	public JRadioButton compose=new JRadioButton("Base Product");
    ButtonGroup bgroup = new ButtonGroup();
	
	JLabel del=new JLabel("Select menu item");
	JLabel ed=new JLabel("Select item to edit");
	
	JLabel l2=new JLabel("Name:");
	JLabel l3=new JLabel("Price:");
	

	JTextField tf1=new JTextField(5);
	JTextField tf2=new JTextField(5);
	
	
	JTextField tf3=new JTextField(5);
	JTextField tf4=new JTextField(5);
	
	JComboBox<Integer> comboedit=new JComboBox<Integer>();
	JComboBox<Integer> combodelete=new JComboBox<Integer>();

	JTextField tf13=new JTextField(5);

	JTable cl;
	
	Font f= new Font("SansSerif",Font.BOLD,17);

	JButton b1=new JButton("Add new menu item");
	JButton b2=new JButton("Edit menu item");
	JButton b3=new JButton("Delete menu item");
	JButton b4=new JButton("Show full menu");


	//constructor
	public GuiA() {
		bgroup.add(base);
	    bgroup.add(compose);
	    for(int i=0;i<=50;i++) 
	    {
	    comboedit.addItem(new Integer(i));
	    combodelete.addItem(new Integer(i));
	    }
		layout();
		adaugareComponente();
		defop();
	}
	
	//sranjarea componentelor
	public void layout() {
		pane.setLayout(null);
		l0.setBounds(30, 25, 150, 30);
		l0.setFont(f);
		del.setBounds(50, 272, 150, 25);
		ed.setBounds(50, 203, 150, 25);
		
		
		base.setBounds(50, 105, 140, 20);
		compose.setBounds(200, 105, 140, 20);
		
		
		l2.setBounds(50, 130, 50, 20);
		l3.setBounds(250, 130, 50, 20);
		
		
		tf1.setBounds(90, 130, 150, 25);
		tf2.setBounds(290, 130, 40, 25);
		
		tf3.setBounds(150, 230, 150, 25);
		tf4.setBounds(310, 230, 50, 25);
		
		b1.setBounds(50, 70, 180, 30);
		b2.setBounds(50, 170, 180, 30);
		b3.setBounds(250, 270, 180, 30);
		b4.setBounds(270, 40, 180, 30);
		
		comboedit.setBounds(50, 230, 70, 25);
		combodelete.setBounds(170, 270, 70, 30);
		
		
		b1.setBackground(new Color(200,250,100));
		b2.setBackground(new Color(210,250,100));
		b3.setBackground(new Color(220,250,100));
		b4.setBackground(new Color(190,250,100));
		pane.setBackground(new Color(250,240,200));
		base.setBackground(new Color(250,240,200));
		compose.setBackground(new Color(250,240,200));
		
	}

	public void adaugareComponente() {

		pane.add(l0);
		pane.add(base);
		pane.add(compose);
		pane.add(l2);
		pane.add(tf1);
		pane.add(l3);
		pane.add(tf2);
		pane.add(tf3);
		pane.add(tf4);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);
		pane.add(del); 
		pane.add(ed); 
		pane.add(comboedit);
		pane.add(combodelete);
		
	}
	
	public String getName(){
		return tf1.getText();
	}
	public String getPrice(){
		return tf2.getText();
	}
	public String getN(){
		return tf3.getText();
	}
	public String getP(){
		return tf4.getText();
	}
	
	
	public void add(ActionListener m) {
		b1.addActionListener(m);
	}
	public void edit(ActionListener m) {
		b2.addActionListener(m);
	}
	public void delete(ActionListener m) {
		b3.addActionListener(m);
	}
	public void view(ActionListener m) {
		b4.addActionListener(m);
	}
	
	public Integer getSelectedItem1(){
		return (Integer) comboedit.getSelectedItem();
	}
	public Integer getSelectedItem2(){
		return (Integer) combodelete.getSelectedItem();
	}
	

	public void  menu(DefaultTableModel a) {//////////////////////////
		JFrame j=new JFrame();
		j.setSize(400, 550);
		cl = new JTable(a);
		cl.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s1=new JScrollPane(cl);
		j.setVisible(true);
		j.setContentPane(s1);
		j.setResizable(false);
		j.setLocation(950, 5);
	}
	
	public void defop() {
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 400);	
		jf.setContentPane(pane);
		jf.setResizable(false);
		jf.setLocation(500, 5);
	}
	

}
