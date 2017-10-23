package vm;

public class Product
		implements iCountable {
	protected String id;
	protected double price;
	protected String title;

	public Product(String id, double price, String title) {
		this.id = id;
		this.price = price;
		this.title = title;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override public String toString() {
		return "vm.Product{" + "id='" + id + '\'' + ", price=" + price + ", title='" + title + '\'' + '}';
	}
}
