
public class Graph {
int size;
String[] vertices;
Node[] a;

public Graph(int[] args){
	size = args.length;
	vertices=new String[size];
	a = new Node[size];
	for(int i= 0; i<size; i++)
		a[i]=new Node(i,null);//size 즉  스트링배열의 크기만큼 노드배열을 만들어야한다.
}


public void add(String v, String w){
	a[index(v)].add(index(w));
	a[index(w)].add(index(v));
}
public String toString(){
	if(size == 0) return "{}";
	StringBuffer buf = new StringBuffer("{");
	for(int i=0;i<size;i++)
		{buf.append(vertices[a[i].to]+":");
		Node start = a[i];
	for(;start.next.next!=null;start=start.next){
		buf.append(vertices[start.next.to]+"");
	}	buf.append(vertices[start.next.to]+"");
		if(a[i].to!=size-1) buf.append(",");// 출력을 할땐 알파벳으로 출력해야하기때문에 vertices의 배열를 참조하여서 출력한다.
		}
	return buf + "}";
}


public int index(String v){
	for(int i =0;i<size;i++)
		if(vertices[i].equals(v)) return i;
	return vertices.length;
}


private class Node{
	int to;
	Node next;

	Node(int to,Node next){
		this.to=to;
		this.next=next;
	}

	public void add(int j){
		a[to].next = new Node(j,a[to].next);}
}//노드의 배열의 next를 새롭게 받아들이는 j를 가지는 노드를 가르키도록 리스트를 만들면된다.


}
