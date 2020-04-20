package PT2019.demo.as1;

import PT2019.monom.Monom;
import PT2019.operatii.OperatiiPolinoame;
import PT2019.polinom.Polinom;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{   OperatiiPolinoame op=new OperatiiPolinoame();
    Polinom p1=new Polinom();
    Polinom p2=new Polinom();
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testAdd(){
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	p2.listaMonoame.add(new Monom(1,1,1.0));
    	p2.listaMonoame.add(new Monom(2,0,2.0));
    	rez.listaMonoame.add(new Monom(1,2,1.0));
    	rez.listaMonoame.add(new Monom(3,1,3.0));
    	rez.listaMonoame.add(new Monom(7,0,7.0));
    	p3=op.aduna(p1, p2);
        assertTrue(op.detalii(p3).equals(op.detalii(rez)));
     }
    public void testAdd1(){
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	p2.listaMonoame.add(new Monom(1,1,1.0));
    	p2.listaMonoame.add(new Monom(2,0,2.0));
    	rez.listaMonoame.add(new Monom(1,2,1.0));
    	rez.listaMonoame.add(new Monom(3,1,3.0));
    	rez.listaMonoame.add(new Monom(7,6,7.0));
    	p3=op.aduna(p1, p2);
        assertTrue(!op.detalii(p3).equals(op.detalii(rez)));
     }
    public void testSub(){
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	p2.listaMonoame.add(new Monom(1,1,1.0));
    	p2.listaMonoame.add(new Monom(2,0,2.0));
    	rez.listaMonoame.add(new Monom(1,2,1.0));
    	rez.listaMonoame.add(new Monom(1,1,1.0));
    	rez.listaMonoame.add(new Monom(3,0,3.0));
    	p3=op.scade(p1, p2);
        assertTrue(op.detalii(p3).equals(op.detalii(rez)));
     }
    public void testSub1(){
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	p2.listaMonoame.add(new Monom(1,1,1.0));
    	p2.listaMonoame.add(new Monom(2,0,2.0));
    	rez.listaMonoame.add(new Monom(1,2,1.0));
    	rez.listaMonoame.add(new Monom(3,1,3.0));
    	rez.listaMonoame.add(new Monom(7,0,7.0));
    	p3=op.scade(p1, p2);
        assertTrue(!op.detalii(p3).equals(op.detalii(rez)));
     }
    public void testMul(){
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	p2.listaMonoame.add(new Monom(1,1,1.0));
    	rez.listaMonoame.add(new Monom(1,3,1.0));
    	rez.listaMonoame.add(new Monom(2,2,2.0));
    	rez.listaMonoame.add(new Monom(5,1,5.0));
    	p3=op.inmulteste(p1, p2);
        assertTrue(op.detalii(p3).equals(op.detalii(rez)));
      }
    public void testMul1(){
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	p2.listaMonoame.add(new Monom(1,1,1.0));
    	rez.listaMonoame.add(new Monom(1,3,1.0));
    	rez.listaMonoame.add(new Monom(2,2,2.0));
    	rez.listaMonoame.add(new Monom(5,5,5.0));
    	p3=op.inmulteste(p1, p2);
        assertTrue(!op.detalii(p3).equals(op.detalii(rez)));
      }
     public void testDiv(){
     	Polinom p3=new Polinom();
     	Polinom rez=new Polinom();
     	p1.listaMonoame.add(new Monom(1,2,1.0));
     	p1.listaMonoame.add(new Monom(2,1,2.0));
     	p1.listaMonoame.add(new Monom(2,0,2.0));
     	p2.listaMonoame.add(new Monom(1,1,1.0));
     	p2.listaMonoame.add(new Monom(1,0,1.0));
     	p3=op.imparte(p1, p2);
     	rez=op.setRest();
         assertTrue(op.detaliiDouble2(p3,rez).equals("  x+1.0  Rest:  1.0"));

      }
     public void testDiv1(){
    	 	Polinom p3=new Polinom();
         	Polinom rez=new Polinom();
         	p1.listaMonoame.add(new Monom(1,2,1.0));
         	p1.listaMonoame.add(new Monom(2,1,2.0));
         	p1.listaMonoame.add(new Monom(2,0,2.0));
         	p2.listaMonoame.add(new Monom(1,1,1.0));
         	p2.listaMonoame.add(new Monom(1,0,1.0));
         	p3=op.imparte(p1, p2);
         	rez=op.setRest();
             assertTrue(!op.detaliiDouble2(p3,rez).equals("  x^5+1.0  Rest:  1.0"));

      }
     public void testDer(){
    	    	Polinom p3=new Polinom();
    	    	Polinom rez=new Polinom();
    	    	p1.listaMonoame.add(new Monom(1,2,1.0));
    	    	p1.listaMonoame.add(new Monom(2,1,2.0));
    	    	p1.listaMonoame.add(new Monom(5,0,5.0));
    	    	rez.listaMonoame.add(new Monom(2,1,2.0));
    	    	rez.listaMonoame.add(new Monom(2,0,2.0));
    	    	p3=op.deriveaza(p1, p2);
    	        assertTrue(op.detalii(p3).equals(op.detalii(rez)));
    	      
      }
     public void testDer1(){
    	 Polinom p3=new Polinom();
	    	Polinom rez=new Polinom();
	    	p1.listaMonoame.add(new Monom(1,2,1.0));
	    	p1.listaMonoame.add(new Monom(2,1,2.0));
	    	p1.listaMonoame.add(new Monom(5,0,5.0));
	    	rez.listaMonoame.add(new Monom(2,1,2.0));
	    	rez.listaMonoame.add(new Monom(5,0,5.0));
	    	p3=op.deriveaza(p1, p2);
	        assertTrue(!op.detalii(p3).equals(op.detalii(rez)));
      }
     public void testInt(){
    	 Polinom p3=new Polinom();
	    	Polinom rez=new Polinom();
	    	p1.listaMonoame.add(new Monom(3,2,3.0));
	    	rez.listaMonoame.add(new Monom(1,2,1.0));
	    	p3=op.integreaza(p1,p2);
	        assertTrue(!op.detaliiDouble(p3).equals(op.detaliiDouble(rez)));
      }
    public void testInt1()
    {
    	Polinom p3=new Polinom();
    	Polinom rez=new Polinom();
    	p1.listaMonoame.add(new Monom(3,2,3.0));
    	rez.listaMonoame.add(new Monom(1,5,1.0));
    	p3=op.integreaza(p1,p2);
        assertTrue(!op.detaliiDouble(p3).equals(op.detaliiDouble(rez)));
    }
}
