package vm;

public class Banknote implements iCountable{
	private String id;

	//example: size, its  picture
	private String recAttribute;

	// 50, 100, 200, 500, 1000
	private double value;

	public Banknote(String id, String recAttribute, double value) {
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

	public double getValue() {
		return this.value;
	}

	@Override public String toString() {
		return "vm.Banknote{" + "id='" + id + '\'' + ", recAttribute='" + recAttribute + '\'' + ", value=" + value + '}';
	}
}
