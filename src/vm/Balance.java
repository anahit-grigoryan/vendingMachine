package vm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.*;

public class Balance {
	private List<Universal> banknoteList;

	public Balance(List<Universal> banknoteList) {
		this.banknoteList = banknoteList;
	}

	public void addBanknote(Banknote banknote, int qty) {
		Universal.add(this.banknoteList, banknote, qty);
	}

	public double getTotal() {
		return banknoteList.stream()
				.map(e -> ((Banknote) e.getObject()).getValue() * e.getQuantity())
				.reduce(0.0, (a, b) -> a + b);
	}

	/**
	 * @param money
	 * @param usedUniversals
	 * @return
	 */
	private Universal getMaxForMoney(double money, List<Universal> usedUniversals) {

		try {
			List<Universal> currentList = Universal.opUniversalList(this.banknoteList, usedUniversals,"-");

			List<Universal> newBanknoteList = currentList.stream()
					.filter(u -> ((Banknote) u.getObject()).getValue() <= money && u.getQuantity() > 0)
					.collect(Collectors.toList());

			Universal maxUniversal = newBanknoteList.stream()
					.max(Comparator.comparing(u -> ((Banknote) u.getObject()).getValue()))
					.get();

			return maxUniversal;
		}
		catch (Exception e) {
			return null;
		}
	}

	/**
	 * @param money
	 * @param balance
	 * @return
	 */
	public Balance getReturnChange(double money, Balance balance) {
		if (money == 0.0) {
			return balance;
		}
		if (balance == null) {
			balance = new Balance(new ArrayList<Universal>());
		}

		Universal maxUniversal = this.getMaxForMoney(money, balance.banknoteList);
		if(maxUniversal == null){
			return null;
		}
		Banknote maxBanknote = (Banknote) maxUniversal.getObject();
		int banknoteCount = (int) (money / maxBanknote.getValue());
		banknoteCount = min(banknoteCount, maxUniversal.getQuantity());

		double restMoney = money - banknoteCount * maxBanknote.getValue();

		Universal newUniversal = new Universal(maxBanknote, banknoteCount);

		balance.banknoteList.add(newUniversal);

		return getReturnChange(restMoney, balance);
	}

	/**
	 * @param balance
	 */
	public void subBalance(Balance balance){
		this.banknoteList = Universal.opUniversalList(this.banknoteList, balance.banknoteList,"-");
	}

	/**
	 * @param balance
	 */
	public void addBalance(Balance balance){
		this.banknoteList = Universal.opUniversalList(this.banknoteList, balance.banknoteList,"+");
	}

	@Override public String toString() {
		return "vm.Balance{" + "banknoteList=" + banknoteList + '}';
	}

}
