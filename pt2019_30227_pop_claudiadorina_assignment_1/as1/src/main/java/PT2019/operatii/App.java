package PT2019.operatii;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PT2019.GUI.Gui;
import PT2019.calculator.Calculator;
import PT2019.polinom.Polinom;


public class App 
{

	public void takeTheInput( String s1, String s2 )
	{   
		Pattern p=Pattern.compile("([+-]?[^-+]+)");
		Matcher m1=p.matcher(s1);
		Matcher m2=p.matcher(s2);
		Parsare pars1=new Parsare();
		Parsare pars2=new Parsare();
		Polinom polinom1=new Polinom();
		Polinom polinom2=new Polinom();
		int x=0 ;
		while(m1.find()) {
			x++;
			pars1.adaugaMonom(m1.group(1));
		}
		x=0;
		while(m2.find()) {
			x++;
			pars2.adaugaMonom(m2.group(1));
		}

		pars1.validare(polinom1);
		pars2.validare(polinom2);
		Calculator c=new Calculator();
		c.takeIt(polinom1, polinom2);
		c.sorteaza();

	}

}
