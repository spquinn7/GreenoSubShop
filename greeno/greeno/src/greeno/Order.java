package greeno;
import java.util.ArrayList;


public class Order {
	private String name;
	private ArrayList<String> items;
	private boolean pickup;
	
	public Order(ArrayList<String> items, boolean pickup, String name) {
		this.items = items;
	
		this.pickup = pickup;
		this.name = name;
		
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addToOrder(String sandwich) {
		items.add(sandwich);
	}
	
	public boolean isPickUp() {
		return this.pickup;
	}
	
	public void printOrder() {
		for (String a : this.items) {
			System.out.println(a);
		}
	}
	public ArrayList<String> getList(){
		return this.items;
	}
}
