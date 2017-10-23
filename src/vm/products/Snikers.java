package vm.products;

import vm.Product;

public class Snikers
		extends Product {
	private String type;

	/**
	 * @param price
	 * @param type
	 */
	public Snikers(double price, String type) {
		super("D", price, "Snikers");
		this.type = type;
	}

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
}
