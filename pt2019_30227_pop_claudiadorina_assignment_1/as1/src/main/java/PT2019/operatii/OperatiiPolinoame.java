package PT2019.operatii;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import PT2019.monom.Monom;
import PT2019.polinom.Polinom;

public class OperatiiPolinoame implements Operatii{

	public Polinom p3=new Polinom();

	public Polinom elementeAsemenea(Polinom p) {

		for(int i=0;i<p.listaMonoame.size();i++)
			for(int j=i+1;j<p.listaMonoame.size();j++)
				if (p.listaMonoame.get(i).putere==p.listaMonoame.get(j).putere)
				{p.listaMonoame.get(i).coef+=p.listaMonoame.get(j).coef;
				p.listaMonoame.get(i).c+=p.listaMonoame.get(j).c;
				p.listaMonoame.remove(p.listaMonoame.get(j));
				j--;
				}
		return p;		
	}
	
	public Polinom aduna(Polinom p1, Polinom p2) {
		Polinom s=new Polinom();
		s.listaMonoame.addAll(p1.listaMonoame);

		for(int i=0;i<s.listaMonoame.size();i++)
			for(int j=0;j<p2.listaMonoame.size();j++)
				if (s.listaMonoame.get(i).putere==p2.listaMonoame.get(j).putere)
				{s.listaMonoame.get(i).coef+=p2.listaMonoame.get(j).coef;
				s.listaMonoame.get(i).c+=p2.listaMonoame.get(j).c;
				p2.listaMonoame.remove(p2.listaMonoame.get(j));
				if(s.listaMonoame.get(i).coef==0||s.listaMonoame.get(i).c==0)
					s.listaMonoame.remove(s.listaMonoame.get(i));
				}
		s.listaMonoame.addAll(p2.listaMonoame);
		return s;
	}
	
	public Polinom scade(Polinom p1, Polinom p2) {
		Polinom dif=new Polinom();
		dif.listaMonoame.addAll(p1.listaMonoame);

		for(int i=0;i<dif.listaMonoame.size();i++)
			for(int j=0;j<p2.listaMonoame.size();j++)
				if (dif.listaMonoame.get(i).putere==p2.listaMonoame.get(j).putere)
				{dif.listaMonoame.get(i).coef-=p2.listaMonoame.get(j).coef;
				dif.listaMonoame.get(i).c-=p2.listaMonoame.get(j).c;
				p2.listaMonoame.remove(p2.listaMonoame.get(j));
				if(dif.listaMonoame.get(i).coef==0||dif.listaMonoame.get(i).c==0)
					dif.listaMonoame.remove(dif.listaMonoame.get(i));
				}
		for(int j=0;j<p2.listaMonoame.size();j++)
		{p2.listaMonoame.get(j).coef=-p2.listaMonoame.get(j).coef;
		p2.listaMonoame.get(j).c=-p2.listaMonoame.get(j).c;

		}
		dif.listaMonoame.addAll(p2.listaMonoame);   
		return dif;
	}

	public Polinom inmulteste(Polinom p1, Polinom p2) {
		Polinom inm=new Polinom();
		for(int i=0;i<p1.listaMonoame.size();i++)
			for(int j=0;j<p2.listaMonoame.size();j++)
			{   Monom m=new Monom(0,0,0.0);
			m.coef=p1.listaMonoame.get(i).coef*p2.listaMonoame.get(j).coef;
			m.c=p1.listaMonoame.get(i).c*p2.listaMonoame.get(j).c;
			m.putere=p1.listaMonoame.get(i).putere+p2.listaMonoame.get(j).putere;
			inm.listaMonoame.add(m);
			}		  
		return inm;
	}

	public Polinom imparte(Polinom a, Polinom b) {
		Polinom cat=new Polinom();
		Polinom rest=new Polinom();
		rest.listaMonoame.addAll(a.listaMonoame);
		while(!(rest.listaMonoame.isEmpty())&&rest.listaMonoame.get(0).putere >= b.listaMonoame.get(0).putere) {
			Monom m=new Monom(0,0,0.0);
			Polinom p=new Polinom();
			m.coef=rest.listaMonoame.get(0).coef/b.listaMonoame.get(0).coef;
			m.c=rest.listaMonoame.get(0).c/b.listaMonoame.get(0).c;
			m.putere=rest.listaMonoame.get(0).putere-b.listaMonoame.get(0).putere;
			p.listaMonoame.add(m);
			cat=aduna(cat,p);
			cat=elementeAsemenea(cat);
			rest=(scade(rest, inmulteste(p, b)));
			Collections.sort(rest.listaMonoame);
			rest=elementeAsemenea(rest);
		}
		p3.listaMonoame.clear();
		p3.listaMonoame.addAll(rest.listaMonoame);
		setRest();
		return cat;

	}
	public Polinom setRest() {
		return p3;
	}
	public Polinom deriveaza(Polinom p1, Polinom p2) {
		p3.listaMonoame.addAll(p1.listaMonoame);

		for(int i=0;i<p3.listaMonoame.size();i++)
		{p3.listaMonoame.get(i).coef*=p3.listaMonoame.get(i).putere;
		p3.listaMonoame.get(i).putere-=1;
		if(p3.listaMonoame.get(i).coef==0)
			p3.listaMonoame.remove(p3.listaMonoame.get(i));
		}

		return p3;
	}
	public Polinom integreaza(Polinom p1, Polinom p2) {

		for(int i=0;i<p1.listaMonoame.size();i++)
		{Monom m=new Monom(0.0,0)	;
		m.c=p1.listaMonoame.get(i).coef*1.0/(p1.listaMonoame.get(i).putere+1);
		m.putere=p1.listaMonoame.get(i).putere+1;
		p3.listaMonoame.add(m);
		}

		return p3;
	}

	public String detalii(Polinom r) {
		String s=" ";
		for(Monom x:r.listaMonoame) {
			if(x.coef<0 || r.listaMonoame.get(0).putere==x.putere)
				s=s+" "+x;
			else
				s=s+"+"+x;}

		p3.listaMonoame.clear();
		return s;
	}
	public String detaliiDouble(Polinom r) {
		String s=" ";
		for(Monom x:r.listaMonoame) {
			if(x.c<0|| r.listaMonoame.get(0).putere==x.putere)
				s=s+" "+x.toStringDouble();
			else
				s=s+"+"+x.toStringDouble();}
		p3.listaMonoame.clear();
		return s;
	}
	public String detaliiDouble2(Polinom r,Polinom p3) {
		String s=" ";
		if(r.listaMonoame.isEmpty())
			s="0";
		else
			for(Monom x:r.listaMonoame) {
				if(x.c<0|| r.listaMonoame.get(0).putere==x.putere)
					s=s+" "+x.toStringDouble();
				else
					s=s+"+"+x.toStringDouble();}

		s+="  Rest: ";
		if(p3.listaMonoame.isEmpty())
			s+="  0";
		else	
			for(Monom x:p3.listaMonoame) {
				if(p3.listaMonoame.isEmpty())
					s+="opip";
				if(x.c<0|| p3.listaMonoame.get(0).putere==x.putere)
					s=s+" "+x.toStringDouble();
				else
					s=s+"+"+x.toStringDouble();}
		p3.listaMonoame.clear();

		return s;
	}

}
