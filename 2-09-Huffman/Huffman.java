public class Huffman implements Comparable<Object> {
	char alphabet;
	int freq;
	Huffman lchild;
	Huffman rchild;

	public Huffman(char A, int B) {
		this.alphabet = A;
		this.freq = B;
	}

	public int compareTo(Object object) {
		if (!(object instanceof Huffman))
			throw new IllegalArgumentException();
		Huffman that = (Huffman) object;
		return that.freq - this.freq;// 두개의 가중치를 비교하는 compareTo함수이다
	}

	public Huffman maketree(HeapPriorityQueue A, int n) {// 우선순위 큐인 tree를 이용하여서
															// 최종적으로 사용할 허프만 트리를
															// 구현하는 과정이다
		for (int i = 1; i < n; i++) {
			Huffman temp = new Huffman(' ', 0);
			temp.lchild = (Huffman) A.remove();
			temp.rchild = (Huffman) A.remove();// string값이 공백이고 왼쪽오른쪽 자식이 현재
												// 우선순위큐에있는 최소가중치 두개를 뽑아서 만든다.

			temp.freq = temp.rchild.freq + temp.lchild.freq;// 해당 가중치는 자식두개를
															// 더한값으로 한다
			A.add(temp);// 그리고 그 트리도 다시 들어가서 허프만코드를 구성한다
		} // 총 갯수가 n개라면 n-1번하면 모두 완성된다.
		return (Huffman) A.remove();// 그럼 최종적으로있는 루트에있는 트리가 허프만트리가 구현되었으니 리턴한다

	}

}
