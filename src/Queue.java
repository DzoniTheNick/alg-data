
public class Queue {

	private Node head;
	
	public Queue() {
		head = null;
	}

	public void enqueue(String value) {
		if(head == null) {
			head = new Node(value);
		}else {
			Node temp = head;
			while(temp.get_next() != null) {
				temp = temp.get_next();
			}
			temp.set_next(new Node(value));
		}
		System.out.println("PROGRAM: Element (" + value + ") has been enqueued");
	}
	
	public void enqueueNoMessage(String value) {
		if(head == null) {
			head = new Node(value);
		}else {
			Node temp = head;
			while(temp.get_next() != null) {
				temp = temp.get_next();
			}
			temp.set_next(new Node(value));
		}
	}
	
	public void dequeue() {
		if(head == null) {
			System.out.println("PROGRAM: Could not remove first element from queue. Queue is empty");
		}else {
			String removedElement = head.get_value();
			if(head.get_next() != null) {
				head = head.get_next();
			}else {
				head = null;
			}
			System.out.println("PROGRAM: Element (" + removedElement + ") has been removed from the queue");
		}
	}
	
	public String dequeueNoMessage() {
		if(head == null) {
			return "NULL";
		}else {
			String removedElement = head.get_value();
			if(head.get_next() != null) {
				head = head.get_next();
			}else {
				head = null;
			}
			return removedElement;
		}
	}
	
	public void peek() {
		if(head == null) {
			System.out.println("PROGRAM: Could not perform peek. Queue is empty");
		}else {
			System.out.println("PROGRAM: Result of peek on queue is (" + head.get_value() + ")");
		}
	}
	
	public void size() {
		int size = 0;
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				size++;
				temp = temp.get_next();
			}
		}
		System.out.println("PROGRAM: Size of the queue is " + size);
	}
	
	public void isEmpty() {
		if(head == null) {
			System.out.println("PROGRAM: The queue is empty (" + true + ")");
		}else {
			System.out.println("PROGRAM: The queue is not empty (" + false + ")");
		}
	}
	
	public boolean isEmptyNoMessage() {
		if(head == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void print() {
		String result = "[";
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				if(temp.get_next() == null) {
					result += "'" + temp.get_value() + "'";
					break;
				}
				result += "'" + temp.get_value() + "'" + ", ";
				temp = temp.get_next();
			}
		}
		result += "]";
		System.out.println(result);
	}
}
