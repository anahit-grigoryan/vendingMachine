package vm;

import java.util.ArrayList;
import java.util.List;

public class Universal implements iUniversal {
	private iCountable object;
	private int quantity;

	public Universal(iCountable object, int quantity) {
		this.object = object;
		this.quantity = quantity;
	}

	public iCountable getObject() {
		return object;
	}

	public String getObjectId() {
		return object.getId();
	}

	public void setObject(iCountable object) {
		this.object = object;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void addCount(int count){
		this.setQuantity(this.getQuantity()+count);
	}

	public void removeCount(int count){
		this.setQuantity(this.getQuantity()-count);
	}

	/**
	 * @param universalList
	 * @param object
	 * @return
	 */
	public static Universal hasObject(List<Universal> universalList,iCountable object){
		for(Universal universal : universalList){
			if(universal.getObjectId()== object.getId()){
				return  universal;
			}
		}
		return null;
	}

	/**
	 * @param universalList
	 * @param object
	 * @param qty
	 */
	public static void add(List<Universal> universalList, iCountable object,int qty){
		Universal universal = Universal.hasObject(universalList,object);
		if(universal != null){
			universal.addCount(qty);
		} else {
			universal=new Universal(object,qty);
			universalList.add(universal);
		}
	}

	/**
	 * @param universalList1
	 * @param universalList2
	 * @param op
	 * @return
	 */
	public static List<Universal> opUniversalList(List<Universal> universalList1, List<Universal> universalList2, String op) {

		if(universalList2.size()==0){
			return universalList1;
		}
		List<Universal> newUniversalList = new ArrayList<>();

		for (Universal thisUniversal : universalList1) {

			Universal u = universalList2.stream()
					.filter(e -> e.getObjectId().equals(thisUniversal.getObjectId()))
					.findFirst()
					.orElse(null);

			if(u == null){
				newUniversalList.add(thisUniversal);
			}else{
				if(op.equals("-")) {
					newUniversalList.add(new Universal(thisUniversal.getObject(), thisUniversal.getQuantity() - u.getQuantity()));
				}else{
					newUniversalList.add(new Universal(thisUniversal.getObject(), thisUniversal.getQuantity() + u.getQuantity()));
				}
			}
		}

		if(op.equals("+")) {
			for (Universal thisUniversal : universalList2) {

				Universal u = universalList1.stream()
						.filter(e -> e.getObjectId().equals(thisUniversal.getObjectId()))
						.findFirst()
						.orElse(null);

				if(u == null){
					newUniversalList.add(thisUniversal);
				}
			}
		}

		return newUniversalList;
	}

	@Override public String toString() {
		return "vm.Universal{" + "object=" + object + ", quantity=" + quantity + '}';
	}
}
