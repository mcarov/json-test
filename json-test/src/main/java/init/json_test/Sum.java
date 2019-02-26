package init.json_test;

public class Sum {
	private String category;
	private int total;
	
	public Sum(String category, int total) {
		this.category = category;
		this.total = total;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void addTotal(int total) {
		this.total += total;
	}
}
