package model;

public class Orders {
	private int id_c;
	private int id_p;
	private int cantitate;
	public Orders(int id_c, int id_p, int cantitate) {

		this.id_c = id_c;
		this.id_p = id_p;
		this.cantitate = cantitate;
	}
	public Orders() {
		
	}
	public int getId_c() {
		return id_c;
	}
	public void setId_c(int id_c) {
		this.id_c = id_c;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	@Override
	public String toString() {
		return "Order [id_c=" + id_c + ", id_p=" + id_p + ", cantitate=" + cantitate + "]";
	}
	
	
	
}
