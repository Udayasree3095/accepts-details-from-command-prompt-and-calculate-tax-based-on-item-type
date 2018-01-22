
public class ItemEncaps {
	
	String name, price, quantity, type;

	public ItemEncaps(String name, String type, String quantity, String price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
