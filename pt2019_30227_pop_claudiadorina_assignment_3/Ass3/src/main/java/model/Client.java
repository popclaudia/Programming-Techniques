package model;

public class Client {
	private int id_c;
	private String name;
	private String address;
	private String phone;
	private String e_mail;
	
	public Client(int id, String n, String ida,String p, String m) {
		this.id_c=id;
		this.name=n;
		this.address=ida;
		this.phone=p;
		this.e_mail=m;
		
	}
	public Client( String n, String ida,String p, String m) {

		this.name=n;
		this.address=ida;
		this.phone=p;
		this.e_mail=m;
		
	}
	public Client() {
	
		
	}
	
	
	

	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public String getName() {
		return name;
	}

	public void setNume(String nume) {
		this.name = nume;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String id_a) {
		this.address = id_a;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	@Override
	public String toString() {
		return "Client [id_c=" + id_c + ", nume=" + name + ", id_a=" + address + ", phone=" + phone + ", e_mail=" + e_mail
				+ "]";
	}
	
	

}
