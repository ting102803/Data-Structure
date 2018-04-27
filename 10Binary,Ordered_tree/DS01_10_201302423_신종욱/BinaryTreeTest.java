
public class BinaryTreeTest {

	public static void main(String[] args) {
		
		BinaryTree H = new BinaryTree("H");
		BinaryTree E = new BinaryTree("E");
		BinaryTree I = new BinaryTree("I");
		BinaryTree J = new BinaryTree("J");
		BinaryTree K = new BinaryTree("K");
		
		BinaryTree D = new BinaryTree("D",null,H);
		BinaryTree B = new BinaryTree("B",D,E);
		
		BinaryTree F = new BinaryTree("F",I,null);
		BinaryTree G = new BinaryTree("G",J,K);
		BinaryTree C = new BinaryTree("C",F,G);
		
		BinaryTree A = new BinaryTree("A",B,C);
		//이진 트리의 주어진 그림대로 구조화 했다.
		System.out.print("Tree 출력 : "+A.toString()+"\n");//트리 모양에대한 출력이다.
		System.out.print("Postorder : ");
		A.postorder(A);//A의 후위식순환을 출력한다
		

	}

}
