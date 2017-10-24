package vm.products;

import vm.Product;

public class Fanta
		extends Product {
	private double size;

	/**
	 * @param price
	 * @param size
	 */
	public Fanta(int price, double size) {
		super("B", price, "Fanta");
		this.size = size;
	}

	/**
	 * @return size
	 */
	public double getSize() {
		return size;
	}

	/**s
	 * @param size
	 */
	public void setSize(double size) {
		this.size = size;
	}
}
