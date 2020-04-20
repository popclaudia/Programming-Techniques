package model;

public class Product {
	private int id_p;
	private String denumire;
	private String marca;
	private int pret;
	private int nr_produse;
	public Product(int id_p, String denumire, String marca, int pret, int nr_produse) {
		this.id_p = id_p;
		this.denumire = denumire;
		this.marca = marca;
		this.pret = pret;
		this.nr_produse = nr_produse;
	}
	public Product() {
		
	}
	
	
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public int getNr_produse() {
		return nr_produse;
	}
	public void setNr_produse(int nr_produse) {
		this.nr_produse = nr_produse;
	}
	@Override
	public String toString() {
		return "Product [id_p=" + id_p + ", denumire=" + denumire + ", marca=" + marca + ", pret=" + pret
				+ ", nr_produse=" + nr_produse + "]";
	}
	
	
}
