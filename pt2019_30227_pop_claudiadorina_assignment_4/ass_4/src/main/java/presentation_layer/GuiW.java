package presentation_layer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import business_layer.MenuItem;

public class GuiW extends JFrame {

	JFrame jf = new JFrame("Waiter");

	JPanel pane = new JPanel();

	JLabel l0 = new JLabel("@Waiter");
	JLabel l1 = new JLabel("Number of products ordered:");
	JLabel l2 = new JLabel("Table number:");

	JTextField tf1 = new JTextField(5);
	JTextField tf2 = new JTextField(5);
 
	public List<JComboBox> comboOrder = new ArrayList<JComboBox>();
    
	JTable cl;

	Font f = new Font("SansSerif", Font.BOLD, 17);

	JButton b1 = new JButton("Add new order");
	JButton b4 = new JButton("Select Items");
	JButton b2 = new JButton("View all orders");
	JButton b3 = new JButton("Generate bill");

	// constructor
	public GuiW() {
		layout();
		adaugareComponente();
		defop();
	}

	// sranjarea componentelor
	public void layout() {
		pane.setLayout(null);
		l0.setBounds(30, 30, 150, 30);
		l0.setFont(f);
		l1.setBounds(15, 120, 180, 20);
		l2.setBounds(210, 120, 100, 20);

		tf1.setBounds(182, 120, 20, 20);
		tf2.setBounds(295, 120, 20, 20);

		b1.setBounds(50, 370, 150, 30);
		b3.setBounds(260, 370, 150, 30);
		b4.setBounds(326, 120, 110, 20);
		
		b2.setBounds(50, 70, 150, 30);

		b1.setBackground(new Color(240, 250, 100));
		b2.setBackground(new Color(220, 250, 100));
		b3.setBackground(new Color(250, 250, 100));
		b4.setBackground(new Color(230, 250, 100));

		pane.setBackground(new Color(250, 240, 200));

	}

	public void adaugareComponente() {
		pane.add(l0);
		pane.add(l1);
		pane.add(tf1);
		pane.add(l2);
		pane.add(tf2);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);

	}

	public String getnr() {
		return tf1.getText();
	}

	public String gettable() {
		return tf2.getText();
	}

	public void addO(ActionListener m) {
		b4.addActionListener(m);
	}
	
	public void placeO(ActionListener m) {
		b1.addActionListener(m);
	}

	public void viewO(ActionListener m) {
		b2.addActionListener(m);
	}

	public void bill(ActionListener m) {
		b3.addActionListener(m);
	}

	public void order(DefaultTableModel a) {
		JFrame j=new JFrame();
		j.setSize(900, 230);
		cl = new JTable(a);
		cl.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s1=new JScrollPane(cl);
		//s1.setBounds(40, 135, 730, 130);
		j.setVisible(true);
		j.setContentPane(s1);
		j.setResizable(false);
		j.setLocation(100, 490);
	}

	public void combo(ArrayList<MenuItem> m, int nr) {
		int loc=150;
		int loc2=40;
		Vector<String> v = new Vector<String>();
		for (MenuItem me : m) {
			v.add(me.getName());	
		}
		for (int i = 0; i < nr; i++) {
			Vector<String> ve = new Vector<String>();
			ve.addAll(v);
			comboOrder.add(new JComboBox<String>(v));
			comboOrder.get(i).setBounds(loc2, loc, 150, 25);
			pane.add(comboOrder.get(i));
			loc+=30;
			if(loc==360) {
				loc=150;
				loc2=210;
			}
		}
		pane.repaint();
	}

	public void defop() {
		// jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(455, 450);
		jf.setContentPane(pane);
		jf.setResizable(false);
		jf.setLocation(400, 35);
	}

}
