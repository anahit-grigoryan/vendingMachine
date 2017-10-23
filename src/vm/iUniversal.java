package vm;

public interface iUniversal {
	public int getQuantity();
	public void setQuantity(int quantity);
	public String getObjectId();
	public iCountable getObject();
	public void addCount(int count);
	public void removeCount(int count);
}
