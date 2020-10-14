import java.util.Date;

public class Product {

	private String id;
	private String name;
	private long price;
	private int quantity;
	private Date creationDate;
	
	
	public Product(String id, String name, long price, int quantity, Date creationDate) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.creationDate = creationDate;
	}
	
	
//	public Product() {
//		super();
//	}
	
	
	
	public void setId(String Id) {
		this.id = Id;
	}
	
	public String getId() {
		return id;
	}
	
	
	public void setName(String Name) {
		this.name = Name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setPrice(long Price) {
		this.price = Price;
	}
	
	public long getPrice() {
		return price;
	}
	
	
	
	public void setQuantity(int Quantity) {
		this.quantity = Quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setCreationDate(Date CreationDate) {
		this.creationDate = CreationDate;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
}
