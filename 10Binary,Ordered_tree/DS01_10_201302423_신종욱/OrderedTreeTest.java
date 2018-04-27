import java.util.LinkedList;
import java.util.List;

public class OrderedTreeTest {
	public static void main(String[] args) {
		OrderedTree H = new OrderedTree("H");
		OrderedTree E = new OrderedTree("E");
		OrderedTree I = new OrderedTree("I");
		OrderedTree J = new OrderedTree("J");
		OrderedTree K = new OrderedTree("K");//리프 노드들을 먼저만듬
		
		OrderedTree D,B,F,G,C,A;
		List<Object> subtreesOfD= new LinkedList<Object>();
		subtreesOfD.add(H);
		D = new OrderedTree("D",subtreesOfD);
		
		List<Object> subtreesOfB= new LinkedList<Object>();
		subtreesOfB.add(D);
		subtreesOfB.add(E);
		B = new OrderedTree("B",subtreesOfB);
		
		List<Object> subtreesOfF= new LinkedList<Object>();
		subtreesOfF.add(I);
		F = new OrderedTree("F",subtreesOfF);
		
		List<Object> subtreesOfG= new LinkedList<Object>();
		subtreesOfG.add(J);
		subtreesOfG.add(K);
		G = new OrderedTree("G",subtreesOfG);
		
		List<Object> subtreesOfC= new LinkedList<Object>();
		subtreesOfC.add(F);
		subtreesOfC.add(G);
		C = new OrderedTree("C",subtreesOfC);
		
		List<Object> subtreesOfA= new LinkedList<Object>();
		subtreesOfA.add(B);
		subtreesOfA.add(C);
		A = new OrderedTree("A",subtreesOfA);//자신이 가지는 서브트리를 만드는 과정들이다.
		
		System.out.print("Postorder : ");
		A.postorder();//후위식 출력
	}

}
