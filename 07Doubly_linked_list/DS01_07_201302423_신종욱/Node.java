
public class Node {
public Object object;
public Node prev;
public Node next;


public Node(Object object){
	this.object =object;
	this.prev =this;
	this.next= this;
}

public Node(Object object,Node prev,Node next){
	this.object=object;
	this.prev=prev;
	this.next= next;
}
}