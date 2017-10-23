package vm;

import java.util.ArrayList;
import java.util.List;

public class VM {
	private List<Universal> productList;
	private Balance vmBalance;

	public VM(List<Universal> productList, Balance vmBalance) {
		this.productList = productList;
		this.vmBalance = vmBalance;
	}

	public VM(){
		this.productList = new ArrayList<Universal>();
		this.vmBalance = new Balance(new ArrayList<Universal>());
	}

	public List<Universal> getProductList() {
		return productList;
	}

	public void setProductList(List<Universal> productList) {
		this.productList = productList;
	}

	public Balance getVmBalance() {
		return vmBalance;
	}

	public void setVmBalance(Balance vmBalance) {
		this.vmBalance = vmBalance;
	}

	public void addProduct(Product product, int qty){
		Universal.add(this.productList,product,qty);
	}


	//TODO:implements when have time
	public void addProducts(List<Universal> productList){
		//this.productList+=productList;
	}

	public boolean canReturnChange(Double totalMoneyToReturn){
		return this.vmBalance.getReturnChange(totalMoneyToReturn,null) != null;
	}

	private void subProduct(Universal universalProduct) {
		universalProduct.removeCount(1);
	}

	/**
	 * @param request
	 * @return
	 */
	public Response order(Request request){
		Universal universalProduct = Universal.hasObject(this.productList, request.getProduct());
		try{
			if(universalProduct!=null && universalProduct.getQuantity()>0) {
				Product product = (Product) universalProduct.getObject();
				Double userTotalMoney = request.getUserBalance().getTotal();
				Double productPrice = product.getPrice();

				if(userTotalMoney >= productPrice ){
					double changeMoney=userTotalMoney - productPrice;
					if(this.canReturnChange(changeMoney)){
						this.vmBalance.addBalance(request.getUserBalance());
						Response response = new Response(product,this.vmBalance.getReturnChange(changeMoney,null));
						this.vmBalance.subBalance(response.getChangeBalance());
						this.subProduct(universalProduct);

						return response;

					}else {
						throw new Exception("Can't return change");
					}
				}else{
					throw new Exception("User vm.Balance is Not Enough");
				}
			}else {
				throw new Exception("vm.Product Not Found");
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}


	@Override public String toString() {
		return "vm.VM{" + "productList=" + productList + ", vmBalance=" + vmBalance + '}';
	}
}
