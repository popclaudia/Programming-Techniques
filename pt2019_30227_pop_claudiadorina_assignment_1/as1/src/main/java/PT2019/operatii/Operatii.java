package PT2019.operatii;

import PT2019.polinom.Polinom;

public interface Operatii {
	
	public Polinom elementeAsemenea(Polinom p);
	
	public Polinom aduna(Polinom a, Polinom b);
	
	public Polinom scade(Polinom a, Polinom b);
	
	public Polinom inmulteste(Polinom a, Polinom b);
	
	public Polinom imparte (Polinom a, Polinom b);
	
	public Polinom deriveaza(Polinom a, Polinom b);
	
	public Polinom integreaza(Polinom a, Polinom b);
	
	
	

}
