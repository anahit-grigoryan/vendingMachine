package vm.products;

import vm.Product;

public class Sprite
		extends Product {
	private double size;

	/**
	 * @param price
	 * @param size
	 */
	public Sprite(double price, double size) {
		super("C", price, "Sprite");
		this.size = size;
	}

	/**
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
