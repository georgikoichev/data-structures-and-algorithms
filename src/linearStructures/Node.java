package linearStructures;

public class Node<T> {
	Node<T> n;
	Node<T> p;
	T val;
	public Node(T val) {
		this.val=val;
	}
	
	public Node(Node<T> p, T val, Node<T> n) {
		this.n=n;
		this.val=val;
		this.p=p;
	}
}
