
public class Node {

	private String value;
	private Node nextNode;
	
	public Node(String value) {
		this.value = value;
		this.nextNode = null;
	}
	
	public String get_value() {
		return this.value;
	}
	
	public void set_next(Node next_node) {
		this.nextNode = next_node;
	}
	
	public Node get_next() {
		return this.nextNode;
	}
	
}
