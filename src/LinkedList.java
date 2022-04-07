
public class LinkedList {

	private Node head;

	public LinkedList() {
		head = null;
	}
	
	public Node headRetrive() {
		return head;
	}
	
	public void insert(String value) {
		if(head == null) {
			head = new Node(value);
		}else {
			Node temp = head;
			while(temp.get_next() != null) {
				temp = temp.get_next();
			}
			temp.set_next(new Node(value));
		}
		System.out.println("PROGRAM: Element (" + value + ") has been added to the list");
	}
	
	public void insertShorter(String value) {
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
	
	public boolean exists(String key) {
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				if(temp.get_value().equals(key)) {
					System.out.println("PROGRAM: (" + key + ") does exist in the list [" + true + "]");
					return true;
				}
				temp = temp.get_next();
			}
		}
		System.out.println("PROGRAM: (" + key + ") does not exist in the list [" + false + "]");
		return false;
	}
	
	public boolean existsShorter(String key) {
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				if(temp.get_value().equals(key)) {
					return true;
				}
				temp = temp.get_next();
			}
		}
		return false;
	}
	
	public void print_list() {
		Node temp = head;
		String result = "";
		if(head != null) {
			while(temp != null) {
				result += temp.get_value() + " -> ";
				temp = temp.get_next();
			}
		}
		result += "None";
		System.out.println(result);
	}
	
	public void remove(String key) {
		if(head == null) {
			System.out.println("PROGRAM: Element (" + key + ") could not be removed because the list is empty");
			return;
		}else if (head.get_value().equals(key)) {
			if(head.get_next() == null) {
				head = null;
			}else {
				head = head.get_next();
			}
			System.out.println("PROGRAM: Element (" + key + ") has been removed from the list");
			return;
		}else{
			Node temp = head;
			while(temp != null) {
				if(temp.get_next() == null) {
					System.out.println("PROGRAM: Element (" + key + ") could not be remove, because it does not exist");
					break;
				}
				if(temp.get_next().get_value().equals(key)) {
					if(temp.get_next().get_next() == null) {
						temp.set_next(null);
					}else {
						temp.set_next(temp.get_next().get_next());
					}
					System.out.println("PROGRAM: Element (" + key + ") has been removed from the list");
					return;
				}
				temp = temp.get_next();
			}
		}
	}

}
