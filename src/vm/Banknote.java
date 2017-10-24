package vm;

public class Banknote
		implements iCountable {
	private String id;

	//example: size, its  picture
	private String recAttribute;

	// 50, 100, 200, 500, 1000
	private int value;

	public Banknote(String id, String recAttribute, int value) {
		this.id = id;
		this.recAttribute = recAttribute;
		this.value = value;
	}

	public String getId() {
		return this.id;
	}

	public String getRecAttribute() {
		return this.recAttribute;
	}

	public int getValue() {
		return this.value;
	}

	@Override public String toString() {
		return "vm.Banknote{"
				+ "id='"
				+ id
				+ '\''
				+ ", recAttribute='"
				+ recAttribute
				+ '\''
				+ ", value="
				+ value
				+ '}';
	}

	public static Banknote createBanknote(int banknotevalue) {
		switch (banknotevalue) {
			case 50:
				return new Banknote("1", "Charenc", banknotevalue);
			case 100:
				return new Banknote("2", "Isahakyan", banknotevalue);
			case 200:
				return new Banknote("3", "Tumanyan", banknotevalue);
			case 500:
				return new Banknote("4", "Teryan", banknotevalue);
			default:
				return null;
		}
	}
}
