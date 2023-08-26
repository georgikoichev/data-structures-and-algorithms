package linearStructures;

import java.util.Random;

public class Queue<T> {
	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public void add(T e) {
		Node<T> el = new Node<>(e);
		if (size == 0) {
			this.first = el;
			this.last = el;
			
		} else {
			last.n = el;
			el.p = last;
			last = el;
		}
		size += 1;
	}
	
	public void add(Object[] e) {
		for (Object o : e) {
			add((T) o);
		}
	}
	
	public T remove() {
		if (size == 0) throw new RuntimeException("Cannot remove from empty queue");
		
		Node<T> el = this.first;
		this.first = first.n;
		size--;
		
		return el.val;
	}
	
	public T[] remove(int n) {
		if (size < n) throw new RuntimeException("Cannot remove more values than the size of the queue");
		
		T[] result = (T[])new Object[n];
		
		for (int i = 0; i < n; i++) {
			result[i] = remove();
		}
		return result;
	}

	public int getSize() {
		return this.size;
	}

	public void shuffle() {
		T[] arr = (T[])new Object[this.size];
		Random r = new Random();
		Node<T> current = this.first;
		
		for (int i = 0; i < this.size; i++) {
			arr[i] = current.val;
			current = current.n;
		}
		
		for (int i = arr.length - 1; i > 0; i--) {
			int j = r.nextInt(i+1);
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		remove(this.size);
		add(arr);
	}
	
	public String toString() {
		String result = "[";
		Node<T> current = this.first;
		for (int i = 0; i < this.size; i++) {
			result += current.val;
			current = current.n;
			if (current != null) result += ", ";
		}
		result += "]";
		return result;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		q.add(new Object[] {1, 2, 3, 4, 5, 6, 7});
		q.shuffle();
		System.out.println(q);
	}
}
