package business_layer;


public class BaseProduct extends MenuItem {
    private String bname;
    private int bprice;
    
	public BaseProduct(String name, int price) {

		this.bname = name;
		this.bprice = price;
	}
	
	public String getName() {
		return bname;
	}
	public void setName(String s) {
		this.bname=s;
	}
	
	public void setPrice(int f) {
		this.bprice=f;
	}
	
	public int  computePrice() {
		
		return this.bprice;
		
	}
	public int  getPrice() {
		
		return this.bprice;
		
	}
    public String info() {
    //	System.out.println(" nybvtrcds"+ bname+"  ");
    	return bname;
    }
}
