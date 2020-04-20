package presentation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame {

	JFrame jf=new JFrame("Orders");

	JPanel pane=new JPanel();

	JLabel l0=new JLabel("Clients");
	JLabel l1=new JLabel("id_c");
	JLabel l2=new JLabel("name");
	JLabel l3=new JLabel("address");
	JLabel l4=new JLabel("phone");
	JLabel l5=new JLabel("e_mail");
	
	JLabel l66=new JLabel("Products");
	JLabel l6=new JLabel("id_p");
	JLabel l7=new JLabel("denumire");
	JLabel l8=new JLabel("marca");
	JLabel l9=new JLabel("pret");
	JLabel l10=new JLabel("nr_produse");
	
	JLabel l111=new JLabel("Orders");
	JLabel l11=new JLabel("Client id");
	JLabel l12=new JLabel("Product id");
	JLabel l13=new JLabel("cantitate");

	JTextField tf1=new JTextField(5);
	JTextField tf2=new JTextField(5);
	JTextField tf3=new JTextField(5);
	JTextField tf4=new JTextField(5);
	JTextField tf5=new JTextField(5);
	
	JTextField tf6=new JTextField(5);
	JTextField tf7=new JTextField(5);
	JTextField tf8=new JTextField(5);
	JTextField tf9=new JTextField(5);
	JTextField tf10=new JTextField(5);
	
	JComboBox<Integer> tf11=new JComboBox<Integer>(/*v1*/);
	JComboBox<Integer> tf12=new JComboBox<Integer>(/*v2*/);

	JTextField tf13=new JTextField(5);


	JTable cl;
	
	JTable pr;
	
	JTable or;
	
	Font f= new Font("SansSerif",Font.BOLD,17);

	JButton listc=new JButton("List all ");
	JButton listp=new JButton("List all");
	JButton delc=new JButton("Delete item ");
	JButton delp=new JButton("Delete item ");
	JButton insc=new JButton("Insert ");
	JButton insp=new JButton("Insert ");
	JButton edc=new JButton("Edit ");
	JButton edp=new JButton("Edit ");
	JButton order=new JButton("Place Order ");

	//constructor
	public Gui() {
		layout();
		adaugareComponente();
		defop();
	}
	
	//sranjarea componentelor
	public void layout() {
		pane.setLayout(null);
		l0.setBounds(30, 25, 100, 30);
		l0.setFont(f);
		l1.setBounds(40, 50, 100, 20);
		l2.setBounds(90, 50, 100, 20);
		l3.setBounds(210, 50, 100, 20);
		l4.setBounds(360, 50, 100, 20);
		l5.setBounds(490, 50, 100, 20);
		
		
		tf1.setBounds(40, 70, 40, 23);
		tf2.setBounds(90, 70, 110, 23);
		tf3.setBounds(210, 70, 140, 23);
		tf4.setBounds(360, 70, 120, 23);
		tf5.setBounds(490, 70, 160, 23);
		
		listc.setBounds(50, 100, 100, 25);
		delc.setBounds(160, 100, 150, 25);
		insc.setBounds(320, 100, 100, 25);
		edc.setBounds(430, 100, 100, 25);


		l66.setBounds(30, 270, 100, 30);
		l66.setFont(f);
		l6.setBounds(40, 295, 100, 20);
		l7.setBounds(90, 295, 100, 20);
		l8.setBounds(210, 295, 100, 20);
		l9.setBounds(360, 295, 100, 20);
		l10.setBounds(490, 295, 100, 20);
		
		tf6.setBounds(40, 315, 40, 23);
		tf7.setBounds(90, 315, 110, 23);
		tf8.setBounds(210, 315, 140, 23);
		tf9.setBounds(360, 315, 120, 23);
		tf10.setBounds(490, 315, 160, 23);
		
		listp.setBounds(50, 345, 100, 25);
		delp.setBounds(160, 345, 150, 25);
		insp.setBounds(320, 345, 100, 25);
		edp.setBounds(430, 345, 100, 25);
		
		l111.setBounds(30, 510, 100, 30);
		l11.setBounds(40, 530, 100, 20);
		l12.setBounds(100, 530, 100, 20);
		l13.setBounds(170, 530, 100, 20);
		tf11.setBounds(40, 550, 50, 23);
		tf12.setBounds(100, 550, 50, 23);
		tf13.setBounds(170, 550, 50, 23);
		l111.setFont(f);
		
		order.setBounds(230, 540, 150, 25);
		
		
		listc.setBackground(new Color(250,250,100));
		delc.setBackground(new Color(240,250,100));
		insc.setBackground(new Color(230,250,100));
		edc.setBackground(new Color(220,250,100));
		
		delp.setBackground(new Color(200,250,100));
		insp.setBackground(new Color(190,250,100));
		edp.setBackground(new Color(180,250,100));
		
		listp.setBackground(new Color(210,250,100));
		
		 order.setBackground(new Color(170,250,100));
		 pane.setBackground(new Color(250,240,200));
		
	}

	public void adaugareComponente() {

		pane.add(l0);
		pane.add(l1);
		pane.add(tf1);
		pane.add(l2);
		pane.add(tf2);
		pane.add(l3);
		pane.add(tf3);
		pane.add(l4);
		pane.add(tf4);
		pane.add(l5);
		pane.add(tf5);
		pane.add(l6);
		pane.add(l66);
		pane.add(l7);
		pane.add(l8);
		pane.add(l9);
		pane.add(l10);
		pane.add(l11);
		pane.add(l111);
		pane.add(l12);
		pane.add(l13);
		pane.add(tf6);
		pane.add(tf7);
		pane.add(tf8);
		pane.add(tf9);
		pane.add(tf10);
		pane.add(tf13);
		pane.add(listc);
		pane.add(delc);
		pane.add(insc);
		pane.add(edc);
		pane.add(listp);
		pane.add(delp);
		pane.add(insp);
		pane.add(edp);
		pane.add(order);
		
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
	
	public void list1Listener(ActionListener m) {
		listc.addActionListener(m);
	}
	public void list2Listener(ActionListener m) {
		listp.addActionListener(m);
	}
	public void del1Listener(ActionListener m) {
		delc.addActionListener(m);
	}
	public void del2Listener(ActionListener m) {
		delp.addActionListener(m);
	}
	public void ins1Listener(ActionListener m) {
		insc.addActionListener(m);
	}
	public void ins2Listener(ActionListener m) {
		insp.addActionListener(m);
	}
	public  void ed1Listener(ActionListener m) {
		edc.addActionListener(m);
	}
	public  void ed2Listener(ActionListener m) {
		edp.addActionListener(m);
	}
	
	public  void orderListener(ActionListener m) {
		order.addActionListener(m);
	}

	public String getidc(){
		return tf1.getText();
	}
	public String getname(){
		return tf2.getText();
	}
	public String getaddr(){
		return tf3.getText();
	}
	public String getphone(){
		return tf4.getText();
	}
	public String getmail(){
		return tf5.getText();
	}
	public String getidp(){
		return tf6.getText();
	}
	public String getden(){
		return tf7.getText();
	}
	public String getmarca(){
		return tf8.getText();
	}
	public String getpret(){
		return tf9.getText();
	}
	public String getnrp(){
		return tf10.getText();
	}
	
	public Integer getco(){
		return (Integer) tf11.getSelectedItem();
	}
	public Integer getcp(){
		return (Integer) tf12.getSelectedItem();
	}
	public String getcant(){
		return tf13.getText();
	}
	public void  table1(DefaultTableModel a) {
		cl = new JTable(a);
		cl.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s1=new JScrollPane(cl);
		s1.setBounds(40, 135, 730, 130);
		pane.add(s1);
	}
	public void  table2(DefaultTableModel a) {
		pr = new JTable(a);
		pr.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s2=new JScrollPane(pr);
		s2.setBounds(40, 380, 730, 130);
		pane.add(s2);
	}
	public void  table3(DefaultTableModel a) {
		or = new JTable(a);
		or.setPreferredScrollableViewportSize(new Dimension(500,50));
		JScrollPane s3=new JScrollPane(or);	
		s3.setBounds(40, 585, 730, 80);
		pane.add(s3);
	}
	public void  combo(Vector<Integer> v1,Vector<Integer> v2) {
		tf11=new JComboBox<Integer>(v1);
		tf12=new JComboBox<Integer>(v2);
		tf11.setBounds(40, 550, 50, 23);
		tf12.setBounds(100, 550, 50, 23);
		//tf11.firePopupMenuWillBecomeVisible();
		//tf12.firePopupMenuWillBecomeVisible();
		pane.add(tf11);
		pane.add(tf12);
	}
	
	public void understock(int a) {
		JOptionPane.showMessageDialog(this, "Nu exista suficiente produse in stoc!\n Numar produse existente: "+a+".");
	}
	
	
	
	public void defop() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(800, 710);	
		jf.setContentPane(pane);
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setLocation(5, 5);
	}
	

}
