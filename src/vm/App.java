package vm;

import vm.banknotes.Banknote100;
import vm.banknotes.Banknote200;
import vm.banknotes.Banknote50;
import vm.banknotes.Banknote500;
import vm.products.Cola;
import vm.products.Fanta;
import vm.products.Snikers;
import vm.products.Sprite;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {

		Banknote50 banknote50 = new Banknote50();
		Banknote100 banknote100 = new Banknote100();
		Banknote200 banknote200 = new Banknote200();
		Banknote500 banknote500 = new Banknote500();

		Cola cola = new Cola(250, 1);
		Fanta fanta = new Fanta(300, 1);
		Snikers snikers = new Snikers(200, "small");
		Sprite sprite = new Sprite(200, 1);

		VM vm = new VM();
		vm.addProduct(cola, 10);
		vm.addProduct(fanta, 30);
		vm.addProduct(snikers, 1);

		vm.getVmBalance().addBanknote(banknote50, 50);
		vm.getVmBalance().addBanknote(banknote100, 20);
		vm.getVmBalance().addBanknote(banknote200, 30);
		vm.getVmBalance().addBanknote(banknote500, 40);

		//Balance changeBalance = vm.getVmBalance().getReturnChange(1050,null);
		//System.out.println(changeBalance);

		System.out.println("VM initial: " +vm);
		System.out.println("VM initial balance total: " + vm.getVmBalance().getTotal());

		Balance userBalance = new Balance(new ArrayList<Universal>());
		userBalance.addBanknote(banknote100, 1);
		userBalance.addBanknote(banknote200, 1);
		Request request = new Request(cola, userBalance);
//		Request request = new Request(sprite, userBalance);

		System.out.println("User request: " + request);

		Response response = vm.order(request);
		System.out.println("VM new balance total: " + vm.getVmBalance().getTotal());
		System.out.println("VM new balance: " + vm.getVmBalance());
		System.out.println("Response: " + response);
	}
}
