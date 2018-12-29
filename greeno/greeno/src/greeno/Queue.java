package greeno;

import java.util.NoSuchElementException;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {
	
	Node<T> front;
	Node<T> rear;
	int size;
	
	public Queue() {
            // TODO 1
		front = null;
		rear = null;
		size = 0;
    }
	
	
	
	@Override
	public boolean isEmpty() {
            // TODO 3
		if (size == 0)
			return true;                 //works perfectly
        return false;
	}

	@Override
	public int size() {
            // TODO 4                     //works perfectly
            return size;
	}

	@Override
	public void enqueue(T element) {
            // TODO 5
		
		Node<T> newNode = new Node<T>(element,null, false, " " );
		if (this.front == null) {
			front = newNode;
			rear = front;
		}
		else {
			rear.next = newNode;
			rear = rear.next;
		}
		
		size++;
	}
	public void enqueue(T element, boolean pickUp, String name) {
        // TODO 5
	Node<T> newNode = new Node<T>(element,null, pickUp, name);
	if (this.front == null) {
		front = newNode;
		rear = front;
	}
	else {
		rear.next = newNode;
		rear = rear.next;
	}
	
	size++;
}

	
	@Override
	public T dequeue() throws NoSuchElementException {
            // TODO 6
		if (this.front==null) {
			throw new NoSuchElementException();
		}
		T element = front.data;
		if (front.next == null) {
			rear = null;
			front = null;
			size--;
			return element;
		}
		if (front.next.next==null) {
			front = null;
			front = rear;
			size--;
			return element;
			
		}
		
		front = front.next;
		
		size--;
		return element;
	}

	@Override
	public T peek() throws NoSuchElementException {
            // TODO 7
		if (this.front==null) {
			throw new NoSuchElementException();
		}
		
		T element = front.data;
		if (size()==1) {
			element = rear.data;
		}
        return element;
	}
	
	public void addInHouse(String sandwich, String name) {
		Node<T> toAdd = new Node(sandwich, false, name);
		Node<T> temp = this.front;
		while (temp.next!= null) {
			if (temp.pickUp==true && temp.next.pickUp==true) {
				toAdd.next = temp.next;
				temp.next = toAdd;
				rear = toAdd;
				size++;
				break;
			}
			temp = temp.next;
		
		}
	
		if (temp.next==null ) {
			toAdd.next = temp.next;
			temp.next = toAdd;
			rear = toAdd;
		}
		
		
		
	}
	
	public void print() {
		Node<T> temp = this.front;
		while (temp!=null) {
			
			System.out.println("Sandwich:" +temp.data + "       PickUp:" +  temp.pickUp + "   Name:" + temp.name);
			temp = temp.next;
		}
	}

	
	


class Node<T> {
	public T data;
	public boolean pickUp;
	public Node<T> next;
	public String name;
	public Node(T data, boolean pickUp, String name) { 
		this.data=data;
		this.pickUp = pickUp;
		this.name = name;
	}
	public Node(T data, Node<T> next, boolean pickUp, String name) {
		this.data = data; 
		this.next=next;
		this.pickUp = pickUp;
		this.name = name;
	}
}





@Override
public UnboundedQueueInterface<T> reversed() {
	// TODO Auto-generated method stub
	return null;
}
}
