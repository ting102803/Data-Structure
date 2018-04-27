
public class DLinkedList {
public Node head =new Node(null);
private int size = 0;
public void insert(int x){
	if (head.next==head){
		head.prev=head.next=new Node(x,head,head);
	}//오름차순으로 정리할때 head.next가 head 즉 자기 자신을 가르킬때는 맨앞에 추가해주고 prev와 next도 head로 지정한다.
	else if ((int)head.next.object>x){
		head.next=new Node(x,head,head.next);
	}//head 다음 값보다 작을경우 맨앞에 추가 해야한다 이때 prev는 head를 next는 원래의 head.next로 받아준 다음 이 노드를 head.next로 받는다.
	else{
	Node p=head;
	while(p.next!=head){
	if((int)p.next.object>=x) break;
	p=p.next;}//나아가는 노드 p를 이용하여 작성하였다 x가 들어가야할 적절한 위치를 찾아준다.
	if(p.next!=head){p.next=new Node(x,p,p.next);}//만약 찾은 위치가 맨 뒤가 아니라면 사이에 삽입하면된다.
	else if (p.next==head){p.next=new Node(x,p,head);//맨뒤에 있는 노드일경우에는 next가 head를 받아야한다.
	head.prev=p.next;//head의 prev는 새로생긴 노드를 가르켜야한다.
	}}
	size++;
	}
		
public void delete(int x){
	Node p = head;
	while(p.next!=head){
	if((int)p.next.object==x){
		if(p.next.next!=head){
		p.next=p.next.next;
		p.next.prev=p;
		size--;//삭제를 위해선 한단계 앞에서 판단해야 함으로 next를 두개썻다. 중간에껄 뛰어넘고 그다음껄 가르키면 해결된다.
		break;}
		else {p.next = head;
		head.prev=p;
		size--;//만약 삭제하는게 맨끝 노드라면 p.next를 없애기위해서 head를 지정해주고 head.prev는 p를 지정해주면된다.
		break;}
	}
	else p=p.next;
}
	if (p.next==head){
		System.out.printf("삭제할게없습니다.");
	}
}
public void print(){
	int count=0;
	Node p =head;
	while(count !=size)
	{System.out.printf("%d<->",(int)p.next.object);
	p=p.next;
	count++;
	}
	System.out.printf("null\n");
}
}
