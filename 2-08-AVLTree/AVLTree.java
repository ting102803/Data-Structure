public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();

	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}

	private AVLTree() {
		left = right = this;
		height = -1;
	}

	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}

	public boolean add(int key) {
		int oldSize = size();
		grow(key);

		return size() > oldSize;

	}

	public boolean remove(int key) {
		int oldSize = size();
		delete(key);
	
		return size() < oldSize;
	}

	public AVLTree grow(int key) {
		if (this == NIL)
			return new AVLTree(key); // 원소가 하나도 없을 경우 새로운 트리 생성한다

		if (key == this.key)
			return this; // 이미 가지고 있는 값일 경우 자신을 리턴

		if (key < this.key)
			left = left.grow(key);// 삽입키가 현재 키보다 작으면 왼쪽으로
		else
			right = right.grow(key);	// 크면 오른쪽으로 들어간다.
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	public AVLTree delete(int key) {
		if (this == NIL) {
			System.out.printf("트리가 없습니다.");
			return NIL;
		}
		if (key < this.key) {
			if (left == NIL) {
				System.out.printf("트리가 없습니다.");
				return NIL;
			}
			left = left.delete(key);
		} else if (key > this.key) {
			if (right == NIL) {
				System.out.printf("트리가 없습니다.");
				return NIL;
			}
			right = right.delete(key);
		} else {//이밑은 키를 찾았을 경우이다.
			if (left == NIL && right == NIL) {// 삭제 노드가 leaf인경우에는 그냥 삭제하면된다.
				return NIL;
			}

			else if (left != NIL && right == NIL) {
				return left;//삭제해야할 노드가 왼쪽은있고 오른쪽에 없을경우 왼쪽을 리턴하면된다.
			} else  if (left == NIL && right != NIL){
				return right;//반대로 오른쪽에만 있고 왼쪽에없을경우 오른쪽을 리턴한다.
			} else {//오른쪽 왼쪽다 있을경우
			int temp = findmin(this.right);//일단 오른쪽트리의 최소키값을 찾는다
			this.delete(temp); //최소값을 일단 삭제한후
			return new AVLTree(temp,this.left,this.right);//새트리를 만드는데 루트는 오른쪽트리의 최소값 temp을하고 왼쪽 오른쪽트리를 그대로 받으면된다.
			}
		}
		rebalance();
		height = 1 + Math.max(left.height, right.height);//삭제후에도 밸런스와 하이트를 맞춰야한다
		return this;
	}
	public int findmin(AVLTree A){
		while(A.left!=NIL){
			A=A.left;
		}
		return A.key;//A트리에서 최소값을 찾아서 리턴하는 함수
	}
	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	public String toString() {
		if (this == NIL)
			return "";
		return left + " " + key + " " + right;
	}

	private void rebalance() {
		if (right.height > left.height) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		} else if (left.height > right.height) {
			if (left.right.height > left.left.height)
				left.rotateLeft();
			rotateRight();
		}//트리의 오른쪽왼쪽의 높이를 맞추는 과정이다.
	}

	private void rotateLeft() {
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}

	private void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
}
