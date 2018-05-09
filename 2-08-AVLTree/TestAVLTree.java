
public class TestAVLTree {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree(44);
		tree.add(88);
		tree.add(55);
		tree.add(77);
		tree.add(33);
		tree.add(99);
		tree.add(66);
		tree.add(22);
		tree.add(25);
		tree.add(75);
		System.out.println("삽입을 완료한 트리 :"+tree);
		tree.remove(25);
		tree.remove(55);
		tree.remove(75);
		tree.remove(44);
		tree.remove(88);
		System.out.println("삭제를 완료한 트리 :"+tree);
	}

}
