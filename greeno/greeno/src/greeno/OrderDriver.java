package greeno;

import java.util.ArrayList;

public class OrderDriver {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Gobbler"); list.add("The Moxie"); list.add("BB Come Back");
		
		
		ArrayList<String> inHouse = new ArrayList<String>();
		inHouse.add("GutBuster1");
		ArrayList<String> inHouse2 = new ArrayList<String>();
		inHouse2.add("GutBuster2");
		
		String pg = "Paul George";
		Order o1 = new Order(inHouse, false, pg);
		
		Order o2 = new Order(list, true, "Russell Westbrook");
		Order o3 = new Order(inHouse2, false, "Lebron James");
		
		OrderQueue a = new OrderQueue();
		
		
		
		a.addToQueue(o1);
		a.addToQueue(o2);
		a.addToQueue(o3);
		a.addToQueue(o3);
		a.addToQueue(o3);
		a.addToQueue(o3);
		
		
		System.out.println("top" + a.q.peek());
		
		a.print();
		  }
		}

