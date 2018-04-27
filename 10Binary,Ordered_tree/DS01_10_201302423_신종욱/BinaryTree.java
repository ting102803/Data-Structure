
public class BinaryTree {
private Object root;
private BinaryTree left,right;

public BinaryTree(Object root){
	this.root =root;
	left = null;
	right = null; //루트만 있는 이진트리를 만들경우에는 left랑 right는 null로 지정한후 만들면된다.
}

public BinaryTree(Object root,BinaryTree left, BinaryTree right){
	this.root = root;
	this.left = left;
	this.right = right;
}//left랑 right도 다있을경우에 트리를 만들경우이다.

public BinaryTree(BinaryTree that){
	 this.root = that.root;
	 if (that.left!=null) this.left = new BinaryTree(that.left);
	 if (that.right!=null) this.right = new BinaryTree(that.right);
}//that 객체가 현재의 객체로 참조하도록 바꾸는 메소드이다.

public Object getRoot(){
	return this.root;
}//root값 반환하는 메소드이다.

public void postorder(BinaryTree tree){
	if(tree!=null){
		postorder(tree.left);
		postorder(tree.right);
	System.out.print(tree.root+" ");	
	}
}//후위식으로 순환하는 메소드인데 재귀적 함수를 이용해서 작성하면된다. 받은 트리가 왼쪽트리부터 null이 될때까지 출력한다고 생각하면된다. 재귀함수를 사용하여 가장늦게 실행되는게 가장 빨리 출력된다.

public String toString(){
	StringBuffer buf = new StringBuffer("[");
	if(left != null)
		buf.append(left + ",");//왼쪽이 있다면 왼쪽부터 버퍼에 쌓는다.
	buf.append(root);//그다음 루트에 쌓는다
	if(right !=null)
		buf.append(","+right);//그다음 오른쪽에 버퍼를 쌓는다
	
	return buf+"]";//그후에 ]를 추가시켜 return 한다
}
}
