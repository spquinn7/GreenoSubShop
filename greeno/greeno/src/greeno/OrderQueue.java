package greeno;

import java.util.ArrayList;

public class OrderQueue {
	Queue<String> q = new Queue<String>();
	
	
	public void addToQueue(Order order) {
		ArrayList<String> items = order.getList();
		String name = order.getName();
		if (q.isEmpty()) {
			for (String a : items)
				if (order.isPickUp()) {
					q.enqueue(a, true, name);
				}
				else {
					q.enqueue(a, false, name);
				}
		}
		else {
			if (order.isPickUp()) {
				for (String a : items) {
					q.enqueue(a, true, name);
				}
			}
			else {
				for (String a : items) {
					q.addInHouse(a, name);
				}
					
			}
		}
		
	}
	
	
	public void sandwichFinished() {
		q.dequeue();
	}
	
	public void print() {
		q.print();
	}
	
	
	
	
	
}
