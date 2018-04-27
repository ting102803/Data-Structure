import java.util.*;
 class LinkedList {
	Node start; 
	class Node {
		private int x;
		private Node next; 
		public Node(int x) {
			this.x = x;
		}
		private Node(int x, Node next) {
			this.x = x;
			this.next = next;
		}}//Node 정의와 생성자 정의를 한다.	
	public void insert(int x) {
		if (start==null||start.x>x){
			start = new Node(x,start);}//start가 null이거나 start의 데이터 값과 x값을 비교하여 작으면 바로 만듬
		else {
			Node p = start;
			while(p.next!=null){
				if(x<p.next.x) break;
				p=p.next;}//start의 next 데이터 값과 x값을 비교하여 클때까지 찾음
			p.next = new Node(x,p.next);//찾은후 그다음에 새로운 노드를 만들어준다.
		}}
	public void print() {
		Node temp = start;
		while(temp != null){
			System.out.print(temp.x+"-->");
			temp=temp.next;//노드한개씩 나아가면서 노드의 x값을 출력한다.
		}	
		System.out.println("null\n");//맨끝은 null로 되기때문에 null로 출력한다.
	}
	public void merge(LinkedList link2) {
		Node p = start;
		while(p.next!=null) p=p.next;//p를 노드 가장뒤로 보낸다
		p.next=link2.start;//p의 마지막 노드를 link2의 start에 연결한다.
	}
	public void reverse() {
		Node reNode = start;//원래 start의 값을 저장하기위해 임의의 reNode를 만든다.
		Node p = reNode;
		start = new Node(p.x,null);//첫번째로 빼올 노드는 결국 reverse하면 맨뒤로 갈꺼기 때문에 next를 null로 한다.
		for(int i=0;i<9;i++){//이미 첫번째 노드는 뺏기때문에 9번만 하면된다.
			reNode = reNode.next; //reNode의 첫번째 노드를 삭제하는 명령이다.
			start = new Node(reNode.x,start);//계속 첫번째에노드를 받고 원래있던 첫번째노드를 주소값으로 가진다.
			}}}

public class TestLinkedList {
	public static void main(String[] args) {
			LinkedList link1 = new LinkedList();//
			int randomInt1[] = new int [10];
			Random rd1 = new Random();//리스트를 만들고 난수를저장할 배열과 난수를 생성할 랜덤메소드를 지정함.
		
			for(int i =0; i<10;i++){
				randomInt1[i] = rd1.nextInt(100);
				link1.insert(randomInt1[i]);}//난수들을 배열에 차곡차곡 10개까지 넣은뒤 insert메소드로 삽입해서 정렬됨
	
			System.out.println("***** Insert LinkedList *****");
			link1.print();//link1을 프린트한다
			System.out.println("***** Reverse LinkedList *****");
			link1.reverse();//link1을 뒤집는다.
			link1.print();//Reverse된 link1을 프린트한다
			
			LinkedList link2 = new LinkedList();
			int randomInt2[] = new int [10];
			Random rd2 = new Random();//리스트를 만들고 난수를저장할 배열과 난수를 생성할 랜덤메소드를 지정함.
			
			for(int i =0; i<10;i++){
				randomInt2[i] = rd2.nextInt(100);
				link2.insert(randomInt2[i]);}//난수들을 배열에 차곡차곡 10개까지 넣은뒤 insert메소드로 삽입해서 정렬됨
		
			System.out.println("***** Insert LinkedList *****");
			link2.print();//link2을 프린트한다
			System.out.println("***** Merge LinkedList *****");
			link1.merge(link2);//link1을 link2에 merge한다
			link1.print();//link1을 프린트한다
		}}
