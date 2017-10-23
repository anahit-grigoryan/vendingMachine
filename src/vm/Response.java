package vm;

public class Response {
	private Product product;
	private Balance changeBalance;

	public Response(Product product, Balance changeBalance) {
		this.product = product;
		this.changeBalance = changeBalance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Balance getChangeBalance() {
		return changeBalance;
	}

	public void setChangeBalance(Balance changeBalance) {
		this.changeBalance = changeBalance;
	}

	@Override public String toString() {
		return "vm.Response{" + "product=" + product + ", changeBalance=" + changeBalance + '}';
	}
}
