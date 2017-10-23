package vm;

public class Request {
	private Product product;
	private Balance userBalance;

	public Request(Product product, Balance userBalance) {
		this.product = product;
		this.userBalance = userBalance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(String Product) {
		this.product = product;
	}

	public Balance getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(Balance userBalance) {
		this.userBalance = userBalance;
	}

	@Override public String toString() {
		return "vm.Request{" + "product='" + product + '\'' + ", userBalance=" + userBalance + '}';
	}
}
