import java.util.*;
public class OrderedTree {
private Object root;
private List<Object> subtrees;
private int size;

public OrderedTree(){
}//empty 트리를 나타낼때 사용

public OrderedTree(Object root){
	this.root =root;
	subtrees = new LinkedList<Object>();
	size = 1;
}// root뿐인 트리를 생성할때 사용한다.

public OrderedTree(Object root,List<Object> trees){
	this(root);
	for(Iterator<Object> it=trees.iterator();it.hasNext();){
		Object object=it.next();
		if(object instanceof OrderedTree){
			OrderedTree tree=(OrderedTree)object;
			if(tree!=null){subtrees.add(tree);
			size+=tree.size();}
		}}}//순서와 무순서트리 차이점은 set을 이용하는지 list를 이용하는지 이다 그외예는 코드가 같다.

public void postorder() {
	 for (Iterator<Object> it=subtrees.iterator(); it.hasNext(); )
	 ((OrderedTree)it.next()).postorder();//itrator로 가장 마지막에 있는게 가장 빨리 실행된다.
	 System.out.print(root+" ");
	}//후위식 순환인데 위에 트리를 만들때와 같이 iterator를 써서 다음께 없는지 확인하면서 출력하면된다 재귀함수를 사용하여 가장늦게 실행되는게 가장 빨리 출력된다.

public int size(){
	return size;
}
}
