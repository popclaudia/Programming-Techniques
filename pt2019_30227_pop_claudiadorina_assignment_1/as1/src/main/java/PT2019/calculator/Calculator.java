package PT2019.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import PT2019.GUI.Gui;
import PT2019.monom.Monom;
import PT2019.operatii.App;
import PT2019.operatii.OperatiiPolinoame;
import PT2019.operatii.Parsare;
import PT2019.polinom.Polinom;

public class Calculator {
	static Polinom p1;
	static Polinom p2;
	static Polinom rez;
	static Polinom rest;
	String p;
	App a= new App();
	String pp;
	Gui g;
	Parsare pars=new Parsare();
	OperatiiPolinoame op;
	public Calculator () {};

	public Calculator( Gui g, OperatiiPolinoame op ) {
		this.g=g;
		this.op=op;

		this.g.addListener(new AddListener());
		this.g.mulListener(new MulListener());
		this.g.divListener(new DivListener());
		this.g.subListener(new SubListener());
		this.g.derListener(new DerListener());
		this.g.intListener(new IntListener());
	}
	public void takeIt(Polinom p,Polinom pp ) {
		p1=p;
		p2=pp;
	}

	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			p= g.getFirstPolinom();
			pp= g.getSecondPolinom();
			a.takeTheInput(p, pp);
			if(pars.mesaj().equals("")) {
				redu();
				rez= op.aduna(p1, p2);
				Collections.sort(rez.listaMonoame);
				g.setResult(op.detalii(rez));
				g.displayErrorMessage("");
			}
			else
				g.displayErrorMessage(pars.mesaj());
			pars.mesaj="";
		}
	}
	
	class MulListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			p= g.getFirstPolinom();
			pp= g.getSecondPolinom();
			a.takeTheInput(p, pp);
			if(pars.mesaj().equals("")) {
				redu();
				rez= op.inmulteste(p1, p2);
				Collections.sort(rez.listaMonoame);
				reduRez();
				g.setResult(op.detalii(rez));
				g.displayErrorMessage("");
			}
			else
				g.displayErrorMessage(pars.mesaj());
			pars.mesaj="";
		}
	}
	
	class DivListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			p= g.getFirstPolinom();
			pp= g.getSecondPolinom();
			a.takeTheInput(p, pp);
			if(pp.equals(""))
				g.displayErrorMessage("Introduceti cel de-al doilea polinom!");
			else
			{
				g.displayErrorMessage("");
				if(pars.mesaj().equals("")) {
					redu();
					rez= op.imparte(p1, p2);
					rest=op.setRest();
					Collections.sort(rez.listaMonoame);
					reduRez();
					Collections.sort(rest.listaMonoame);
					reduRest();
					g.setResult(op.detaliiDouble2(rez,rest));
					g.displayErrorMessage("");
				}
				else
					g.displayErrorMessage(pars.mesaj());
				pars.mesaj="";
			}
		}
	}
	
	class SubListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			p= g.getFirstPolinom();
			pp= g.getSecondPolinom();
			a.takeTheInput(p, pp);
			if(pars.mesaj().equals("")) {
				redu();
				rez= op.scade(p1, p2);
				reduRez();
				Collections.sort(rez.listaMonoame);
				g.setResult(op.detalii(rez));
				g.displayErrorMessage("");
			}
			else
				g.displayErrorMessage(pars.mesaj());
			pars.mesaj="";
		}
	}
	
	class DerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			p= g.getFirstPolinom();
			pp= g.getSecondPolinom();
			a.takeTheInput(p, pp);
			if(pars.mesaj().equals("")) {
				redu();
				rez= op.deriveaza(p1, p2);
				Collections.sort(rez.listaMonoame);
				reduRez();
				g.setResult(op.detalii(rez));
				g.displayErrorMessage("");
			}
			else
				g.displayErrorMessage(pars.mesaj());
			pars.mesaj="";
		}
	}
	
	class IntListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			p= g.getFirstPolinom();
			pp= g.getSecondPolinom();
			a.takeTheInput(p, pp);
			if(pars.mesaj().equals("")) {
				redu();
				rez= op.integreaza(p1, p2);
				Collections.sort(rez.listaMonoame);
				reduRez();
				g.setResult(op.detaliiDouble(rez));
				g.displayErrorMessage("");
			}
			else
				g.displayErrorMessage(pars.mesaj());
			pars.mesaj="";
		}
	}

	public void sorteaza() {
		Collections.sort(p1.listaMonoame);
		Collections.sort(p2.listaMonoame);
	}
	
	public void reduRez() {
		op.elementeAsemenea(rez);
	}
	
	public void reduRest() {
		op.elementeAsemenea(rest);
	}
	
	public void redu() {
		op.elementeAsemenea(p1);
		op.elementeAsemenea(p2);
	}
}
