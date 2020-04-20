package PT2019.operatii;

import java.util.ArrayList;

import PT2019.calculator.Calculator;
import PT2019.monom.Monom;
import PT2019.polinom.Polinom;

public class Parsare {
	
	    ArrayList<String> s=new ArrayList <String> ();
	    Integer coef=0;
	    Integer putere=0;
	    int k,m,neg=0,eroare=0;
	    int necunoscuta=0;
	    public static char x='x';
	    public static String mesaj="";
	    Monom monom=new Monom(0,0,0.0);
	    
         public void adaugaMonom(String a) {
        	 s.add(a);
         }
         
         public void validare(Polinom p) {
        	 
        	 for(String i: s) {
        		 coef=0;
        		 putere=0;
        		 k=0; m=1;
        		 neg=0;
        		 if(i.charAt(0)=='+')
        			 k++;
        		 if(i.charAt(0)=='-') {
        			 k++;
        			 neg=1;}
        		 
        		 while(k<i.length()&&i.charAt(k)>='0'&&i.charAt(k)<='9') {
        			 coef=coef*m+((int) i.charAt(k)-'0');
        			 k++;
        			 m=10;		 
        		 }
        		 if(coef==0) 
        			 coef=1;
        		 if(k==i.length())
        			 putere=0;
        		 
        		 if(k<i.length() && i.charAt(k)>='a' && i.charAt(k)<='z' && necunoscuta==0) {
        			 x=i.charAt(k); //necunoscuta
        		     necunoscuta=1;
        		 }
        		 if(k<i.length() && i.charAt(k)!=x )
        			 mesaj="Date de intrare invalide. Reintroduceți datele!";
        		 if(neg==1)
        			 coef=-coef;
        		 if(++k<i.length())
        			 if(i.charAt(k)=='^')
        				 {k++;
        				 while(k<i.length()&&i.charAt(k)>='0'&&i.charAt(k)<='9') {
                			 putere=putere*m+((int) i.charAt(k)-'0');
                			 k++;
                			 m=10;		 
                		 }
        				 if(k<i.length())
        					 mesaj="Date de intrare invalide!";
        				 }
        			 else if(i.charAt(k)!='^')
        				 	mesaj="Date de intrare invalide!";
                    if(x==i.charAt(i.length()-1))
                    	putere=1;
                    if(!mesaj.equals(""))
                    	eroare=1;
                    
                    if(eroare==0) {
                    	monom=new Monom(coef,putere,coef*1.0);
                    	p.creeazaPolinom(monom);
                    }
        	 }
         }
         public String mesaj() {
        	 return mesaj;
         }
        	 
}
