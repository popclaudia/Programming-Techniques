package PT2019.monom;

import PT2019.operatii.Parsare;

public class Monom implements Comparable{
	public Integer coef;
	public Integer putere;
	public Double c;

	public Monom (int c, int p,double cf){
		this.coef=c;
		this.putere=p;
		this.c=cf;
	}

	public Monom (Double c, int p){
		this.c=c;
		this.putere=p;
	}

	public int compareTo(Object arg0) {
		Monom x=(Monom) arg0;
		return -this.putere.compareTo(x.putere);
	}
	
	public String toString() {
		if(coef==-1 && putere==1)
			return "-"+"x";
		if(coef==-1&&putere>1)
			return "-x^"+putere;
		if(coef==1)
		{if(putere==1)
			return "x";
		if (putere>1)
			return"x"+"^"+putere;
		}
		if((coef>1||coef<-1) && putere>1)
			return coef+"x"+ "^" +putere;

		if(coef!=0 && putere==0)
			return coef.toString();
		if(coef!=0 && coef!=-1 && putere==1)
			return coef.toString()+"x";

		return " ";
	}
	public String toStringDouble() {
		if(c==-1 && putere==1)
			return "-"+"x";
		if(c==-1&&putere>1)
			return "-x^"+putere;
		if(c==1)
		{if(putere==1)
			return "x";
		if (putere>1)
			return"x"+"^"+putere;
		}
		if((c!=1||c!=-1) && putere>1)
			return c+"x"+ "^" +putere;

		if(c!=0 && putere==0)
			return c.toString();
		if(c!=0 && c!=-1 && putere==1)
			return c.toString()+"x";

		return " ";
	}
}
