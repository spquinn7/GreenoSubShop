package structures;

import java.util.NoSuchElementException;

import greeno.UnboundedQueueInterface;

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
	
	public Queue(Queue<T> other) {
            // TODO 
		front = null;
		rear = null;
		size = 0;
		Node<T> temp = null;
		if (other.front!=null) {
			temp = other.front;
			this.front = new Node<T>(temp.data,null);
			this.rear = front;
			size++;
			temp = temp.next;
		} 
		while(temp!=null) {
			
			
			Node<T> newNode = new Node<T>(temp.data,null);
			rear.next = newNode;
			rear = newNode;
			if(front==rear) {
				front.next = rear;
			}
			size++;
			temp = temp.next;
		
		}
		
		
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
		Node<T> newNode = new Node<T>(element,null);
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

	
	@Override
	public UnboundedQueueInterface<T> reversed() {
            // TODO 8
		Queue<T> copy = new Queue<T>(this);
		Queue<T> returnQ = new Queue<T>();
		if (this.front==null || this.front.next==null) {
			return copy;
		}
		T[] ts = (T[]) new Object[copy.size()];
		int count = 0;
		Node<T> temp = copy.front;
		while(temp!=null) {
			T element = temp.data;
			ts[count] = element;
			count++;
			temp= temp.next;
		}
		
		for (int i = count-1; i >=0; i--) {
			T element = ts[i];
			returnQ.enqueue(element);
		}
		
		
		
		return returnQ;
		
	}
}

class Node<T> {
	public T data;
	public Node<T> next;
	public Node(T data) { this.data=data;}
	public Node(T data, Node<T> next) {
		this.data = data; this.next=next;
	}
}

