
public class BST {
 private Comparable key;
 private BST left,right;
 private BST root;
 private int leftSubtreeHeight;
 private int rightSubtreeHeight;
 
 public BST(){
	 this.root=this;
 }
 public BST(Comparable key){
	 this.key=key;
	 this.leftSubtreeHeight=0;
	 this.rightSubtreeHeight=0;	 
 }
 public void insert(Object key){
	 if(this.key==null){
		this.key=(Comparable) key;
	 }//만약 현재 루트의 키값이 null상태라면 첫 bst에 키값을 넣어준다
	 else if(((Comparable)this.key).compareTo(key)>0){
		 if(this.left==null) this.left=new BST();
		 this.left.insert(key);
		//현재키값>추가해야할 키값이라면 키값을 LEFT서브 트리로 추가해야한다. 그전에 공백트리를 만들어서 미리 트리구조를 만들어야한다.
		 //그 left트리에서도 insert 메소드를 실행시켜서 크기를 비교해주어서 공백이될때까지 찾아서 추가한다.
	}
	 else if(((Comparable)this.key).compareTo(key)<0){
		if(this.right==null)this.right=new BST();
		this.right.insert(key);
		//현재키값<추가해야할 키값이라면 키값을 right서브 트리로 추가해야한다. 그전에 공백트리를 만들어서 미리 트리구조를 만들어야한다.
		 //그 right트리에서도 insert 메소드를 실행시켜서 크기를 비교해주어서 공백이될때까지 찾아서 추가한다.
	 }
 }
 
 public Object height(BST bst) {
	 if (left==null && right==null) return 0;// subtree가 없을경우
	 else if (left==null) return (1 + (int)right.height(right));//subtree가 right만 있을경우 높이를 1더하고 right에서 height를 구한다.
	 else if (right==null) return (1 + (int)left.height(left));//subtree가 left만 있을경우 높이를 1더하고 right에서 height를 구한다.
	 else if ((int)left.height(left)>(int)right.height(right))
	 {return 1 + (int)left.height(left);}
	 else return 1 + (int)right.height(right);
	 }//만약 subtree가 양쪽다 있을경우에는 오른쪽왼쪽중에 더 height한 값이 큰경우를 구해서 return한다.
 
 public void inorder(BST bst){
	 if (left!=null) left.inorder(this.left);// 만약 left값이 있더라면 left inorder을 실행하여 left부터 출력하도록한다.
	 System.out.print(key + " ");//left 출력이 다끝났으면 루트의 key값을 출력
	 if (right!=null) right.inorder(this.right);//만약 right값이 있더라면 이제 나머지 right들의 key값을 출력하면된다.
 }
 
}
