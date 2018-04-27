
public class SlinkedQueue implements Queue{
	private Node head;//큐의 구조상 제일 먼저 들어갔던 것들이 있는곳이이며 삭제가 일어난다.
	private Node rear;//여기서 삽입이 일어난다
	private int size;
	
private static class Node{
	Object object;
	Node next;
	Node(Object object, Node next){
		this.object = object;
		this.next= next;
	}
	}

	public void add(Object object){
		if(head==null){
			rear=head=new Node(object,null);
		}//만약 추가할려고하는데 존재하는 큐값들이 없다면 바로 추가하고 그 노드가 head이자 rear이다
		else {
			rear=rear.next=new Node(object,null);//이미 있다면 새노드를 원래 rear노드의 next값으로 지정하고, 새노드를 새로운 rear로 선언한다.
		}
		size++;//한개 추가했으니 사이즈를 증가시킨다.
		System.out.print("ADD        "+object+" | ");print();
	}
	
	public Object first(){
		if (isEmpty()){
			System.out.println("Queue is Empty");
			return null;
		}
		else return head.object;//첫번째원소를 가져와 return하는 메소드이다 만약 큐가 비였으면 실행되지않는다.
	}
	public Object remove(){
	if (isEmpty()){
		System.out.println("Queue is Empty");
		return null;
	}//만약 큐가 비였으면 삭제할게 없어서 실행되지않는다.
	else {
		Object temp=head.object;//삭제 하기전에 저장해둬야한다.
		head=head.next;//head가 이제 첫번째원소가 아닌 두번째 원소를 가르킨다.
		size--;//하나를 삭제했으니 사이즈를 줄인다.
		System.out.print("REMOVE     "+temp+" | "); print();
		return temp;}//삭제된 object를 리턴한다.
	}
	public int size(){
		return size;
	}
	public void print(){
		if(isEmpty()){
			System.out.println("null");
		}
		else {Node p = head;
		while(rear!=p){
		System.out.print(p.object+"<--");
		p=p.next;
		}
		System.out.println(p.object+"<--null");
	}}//출력을 할때는 head를 대체할 p를 만들어서 head부터 하나씩 출력하면된다.
	
	public boolean isEmpty(){
		if (head==null){rear=null;
		return true;}
		else return false;
	}//만약 head가 null이라면 당연히 rear도 null이고 비였다는 신호인 true를 리턴한다. 아니라면 false를 리턴

	public void resize() {
		
	}

	
}
