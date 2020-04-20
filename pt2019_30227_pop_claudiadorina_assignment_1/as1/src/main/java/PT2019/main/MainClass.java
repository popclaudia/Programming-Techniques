package PT2019.main;

import PT2019.GUI.Gui;
import PT2019.calculator.Calculator;
import PT2019.operatii.App;
import PT2019.operatii.OperatiiPolinoame;

public class MainClass {

	public static void main(String[] args) {
		Gui g=new Gui(); 
		OperatiiPolinoame op=new OperatiiPolinoame();
		Calculator c=new Calculator(g,op);

	}

}
