package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MicroQueue {
	public Node head, tail;
	public int size;
	
	public class Node {
		public int val;
		public Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public MicroQueue() {
		head = new Node(0);
		tail = head;
		size = 0;
	}
	
	public int enqueue(int val) {
		tail.next = new Node(val);
		tail = tail.next;
		size++;
		return size;
	}
	
	public int dequeue() {
		if (size == 0) { return -1; }
		int val = head.next.val;
		head = head.next;
		size--;
		return val;
	}
	
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MicroQueue queue = new MicroQueue();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(reader.readLine());
			for (int i = 0; i < n; i++) {
				String[] op = reader.readLine().split(" ");
				if (op[0].equals("E")) {
					System.out.println(queue.enqueue(Integer.parseInt(op[1])));
				} else {
					System.out.print(queue.dequeue());
					System.out.print(" ");
					System.out.println(queue.size());
				}
			}
		} catch (IOException e) {
			
		}
	}
}