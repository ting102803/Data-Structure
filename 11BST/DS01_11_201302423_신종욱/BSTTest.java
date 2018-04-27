
public class BSTTest {
 public static void main(String args[]){
	 BST bst = new BST();
	 bst.insert(44);
	 bst.insert(88);
	 bst.insert(55);
	 bst.insert(77);
	 bst.insert(33);
	 bst.insert(99);
	 bst.insert(66);
	 bst.insert(22);
	 bst.insert(25);
	 bst.insert(75);

	 System.out.println("Height : "+bst.height(bst));
	 System.out.print("Inorder : "); bst.inorder(bst);
	 
 }
}
