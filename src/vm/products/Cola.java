package vm.products;

import vm.Product;

public class Cola
		extends Product {
	private double size;

	/**
	 * @param price
	 * @param size
	 */
	public Cola(double price, double size) {
		super("A", price, "Cola");
		this.size = size;
	}

	/**
	 *
	 * @return size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size
	 */
	public void setSize(double size) {
		this.size = size;
	}
}
