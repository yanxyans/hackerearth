package hackerearth;

public class Deque {
	
	public class Node {
		public int val;
		public Node prev, next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public Node head, tail;
	public int size;

	public static void main(String[] args) {
		Deque deque = new Deque();
		System.out.println("initial size: " + deque.size());
		deque.enqueueHead(1);
		deque.enqueueHead(2);
		System.out.println("tail deque on size " + deque.size() + ": " + deque.dequeueTail());
		System.out.println("tail deque on size " + deque.size() + ": " + deque.dequeueTail());
		System.out.println("tail deque on size " + deque.size() + ": " + deque.dequeueTail());
		deque.enqueueTail(3);
		deque.enqueueTail(4);
		System.out.println("head deque on size " + deque.size() + ": " + deque.dequeueHead());
		System.out.println("head deque on size " + deque.size() + ": " + deque.dequeueHead());
		System.out.println("head deque on size " + deque.size() + ": " + deque.dequeueHead());
		System.out.println("final size: " + deque.size());
	}
	
	public Deque() {
		head = new Node(0);
		tail = new Node(0);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public void enqueueHead(int val) {
		Node node = new Node(val);
		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		node.prev.next = node;
		size++;
	}
	
	public Integer dequeueHead() {
		if (size == 0) {
			return null;
		}
		size--;
		Node ret = head.next;
		ret.next.prev = ret.prev;
		ret.prev.next = ret.next;
		return ret.val;
	}
	
	public void enqueueTail(int val) {
		Node node = new Node(val);
		node.prev = tail.prev;
		node.next = tail;
		node.prev.next = node;
		node.next.prev = node;
		size++;
	}
	
	public Integer dequeueTail() {
		if (size == 0) {
			return null;
		}
		size--;
		Node ret = tail.prev;
		ret.prev.next = ret.next;
		ret.next.prev = ret.prev;
		return ret.val;
	}
	
	public int size() {
		return size;
	}

}
