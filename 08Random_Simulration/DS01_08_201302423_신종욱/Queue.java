
public class Queue {
	Node head;
	Node rear;
	int size;

	class Node {
		Node next;
		int amount;
		int price;

		Node(int price, int amount, Node next) {
			this.price = price;
			this.amount = amount;
			this.next = next;
		}
	}// 여기서는 가격과 수량을 나타내야하기때문에 생성자에 int를 두개 생성하고 next 노드를 생성하였다.

	public Node first() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		} else
			return head;
	}// 첫 번째 노드를 반환하는 first 메소드이다.

	public void add(int price, int amount) {
		if (head == null) {
			rear = head = new Node(price, amount, null);
		} else {
			rear = rear.next = new Node(price, amount, null);}
		size++;}// 노드를 추가하는 add 메소드이다.

	public void remove() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		} else {
			head = head.next;
			size--;
			if (head == null)
				rear = null;}}// 삭제하는 메소드이다. 만약 삭제했을때 head가 null이라면 rear도 null로 초기화해준다.

	public void print() {
		if (isEmpty()) {
			System.out.println(" ");
		} else {
			Node p = head;
			System.out.printf("[%d원 : %d개]", p.price, p.amount);
			p = p.next;
			while (p != null) {
				System.out.printf("<--[%d원 : %d개]", p.price, p.amount);
				p = p.next;}
			System.out.println(" ");}}// 전체노드를 출력하는 메소드이다.

	public boolean isEmpty() {
		if (head == null) {
			rear = null;
			return true;
		} else
			return false;
	}// 빈노드인지 검사하는 메소드이다. 여기선 쓰일일 없다.
}
