package init.json_test;

import java.util.Collection;
import java.util.TreeMap;

public class Stat {
	private int id;
	private String name;
	private Sum[] stats;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Sum[] getSum() {
		return stats;
	}

	
	public static Stat calculate(Customer customer) {
		Stat stat = new Stat();
		stat.id = customer.getId();
		stat.name = customer.getName();
		
		TreeMap<String, Sum> map = new TreeMap<String, Sum>();
		Sum sum;
		String key;
		int amount;
		for(Expenses i : customer.getExpenses()) {
			for(Category j : i.getDetails()) {
				key = j.getCategory();
				amount = j.getAmount();
				if(map.containsKey(key)) {
					map.get(key).addTotal(amount);
				}
				else {
					sum = new Sum(key, amount);
					map.put(key, sum);
				}
			}
		}
		Collection<Sum> values = map.values();
		
		stat.stats = values.toArray(new Sum[values.size()]);
		
		return stat;
	}
}
