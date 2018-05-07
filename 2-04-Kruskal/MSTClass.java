public class MSTClass {
	String[] TV;// 정점들을 저장하기위한 배열
	int[][] E;// 정점들의 연결가중치를 저장하기위한 배열
	int parent[];// union이나 find를 할때 쓰는 배열
	Node[] node;//heap에 들어갈때 가지고있어야할 정보들을 저장한다
	MinHeap H;//minheap을 구현하기위해 선언

	public void MST(String[] A, int[][] B) {
		TV = A;
		E = B;
		H = new MinHeap((TV.length) * (TV.length-1) / 2);
		node = new Node[(TV.length) * (TV.length-1) / 2];//(TV.length) * (TV.length-1) / 2 이식은  가중치 배열은 대칭배열이기때문에 반만 저장하면되서 이렇게 선언하였다. 
		parent = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			parent[i] = -1;
		} // 그래프를 Kruskal하기위해 초기화를 다 해준다. -1을 해주는이유는 처음에는 연결이안된 root상태로 보기때문이다.
	}

	public int collapsingfind(int i) {
		for (; parent[i] >= 0; i = parent[i]);
		return i;
	}// TV배열의 i번째에있는 문자의 ROOT값를 리턴한다 즉 음수가 될때까지 계속위로 찾아 올라간다고 보면된다.

	public void weightedunion(int i, int j) {
		i = collapsingfind(i);
		j = collapsingfind(j);
		int temp = parent[i] + parent[j];// 각각의 원소가 있는 집합의 크기를 알아낸뒤 그값들을 더한다
		if (parent[j] < parent[i]) {// j가 더작다는 j가 크기가 더크다이다
			parent[i] = j;
			parent[j] = temp;// i의 부모를 j로 만들고 j의 최종크기를 저장
		} else {
			parent[j] = i;
			parent[i] = temp;
		} // j의 부모를 i로 만들고 i의 최종크기를 저장
	}

	public void Kruskal() {

		int Cost = 0;// 필요한값들을 초기화
		int k = 0;
		for (int i = 0; i < TV.length; i++) {
			for (int j = i+1; j < TV.length; j++) {
				node[k] = new Node(i, j, E[i][j]);
				H.insert(node[k]);
				k++;//가중치와 정점정보들을 노드로 저장한뒤 minheap으로 구현한다.
			}}
		for (int i = 0; i <=TV.length; i++) {//최소 신장트리는 TV크기 -1개 만큼만 사용하기에  for문의 횟수를 저렇게 정했다.
			Node check = H.remove();
			if (collapsingfind(check.i) != collapsingfind(check.j)) {
				// 최고 root가같은지판단한다 즉 원소가 같은그룹인지확인한다.
				weightedunion(check.i, check.j);// 두개의 그룹이 같지않다면 서로 연결한다
				System.out.print("선택된 간선 : " + TV[check.i] + "--> " + TV[check.j] + " / ");
				System.out.println("weight = " + check.cost + " 추가");
				Cost += check.cost;// 만들때 사용된 비용을 저장될 최종비용에 저장한다.
			}}
		System.out.println("비용 합계 : " + Cost);
	}}


class Node {
	int i;
	int j;//가중치 배열의 행렬위치를 기억해서 정점의 정보를 저장하기위한 정수
	int cost;//가중치정보를 저장하기위한 정수

	public Node(int i, int j, int cost) {
		this.i = i;
		this.j = j;
		this.cost = cost;
	}
}//heap에 들어갈때 가지고있어야할 정보들을 저장한다


class MinHeap {
	Node[] Heap;// 여러가지 값을 저장해야하기때문에 노드로 구현하였다
	int size;//현재 heap의 크기
	int maxsize;//최대 크기
	int i;
	int j;//가중치 배열의 행렬위치를 기억해서 정점의 정보를 저장하기위한 정수
	int FRONT = 1;//root를 가르키는용

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new Node[this.maxsize + 1];
		Heap[0] = new Node(0, 0, Integer.MIN_VALUE);}// insert할때랑 remove할때 에러 방지를 위한 첫배열을 채워넣어야한다.

	public int parent(int index) {
		return index / 2;}//부모 힙의 인덱스를 반환

	public int leftChild(int index) {
		return (2 * index);}//왼쪽 자식의 인덱스를 반환

	public int rightChild(int index) {
		return (2 * index) + 1;}//오른쪽 자식의 인덱스를 반환

	public boolean isLeaf(int index) {
		if (index >= (size / 2) && index <= size) {
			return true;
		}
		return false;}//리프노드인지 아닌지를 판단하는 메소드로 size/2<index<size이면 리프노프이다.

	public void swap(int Aindex, int Bindex) {
		Node temp;
		temp = Heap[Aindex];
		Heap[Aindex] = Heap[Bindex];
		Heap[Bindex] = temp;}// 히프화할때 스왑할을 해야하기때문에 스왑 메소드를 만들어놔야한다.

	public void minHeapify(int index) {
		if (!isLeaf(index)) {//리프인지 확인한다 리프이면 자식이 없기때문에 할필요가 없다.
			if (Heap[index].cost > Heap[leftChild(index)].cost || Heap[index].cost > Heap[rightChild(index)].cost) {//부모노드의 값이 자식들보다 클경구 minheap에 위배되서 해줘야한다.
				if (Heap[leftChild(index)].cost < Heap[rightChild(index)].cost) {
					swap(index, leftChild(index));
					minHeapify(leftChild(index));// 왼쪽 자식이 더 작을경우에는 왼쪽 자식을 부모와 swap해주고 다시 heapify해준다.
				} else {
					swap(index, rightChild(index));
					minHeapify(rightChild(index));// 오른쪽 자식이 더 작을경우에는 왼쪽 자식을 부모와 swap해주고 다시 heapify해준다.
				}}}}

	public void insert(Node A) {
		Heap[++size] = A;
		int current = size;
		while (Heap[current].cost < Heap[parent(current)].cost) {
			swap(current, parent(current));
			current = parent(current);//리프에 인서트한후 부모와 값을 비교후 더 작으면 계속 스왑해서 위로 올리는 작업이다.
		}}

	public Node remove() {
		Node temp = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);//마지막에 있는 값을 root에 넣은후 heapify 시킨다
		return temp;
	}}//root 즉 최소값을 제거하고 그에대한 node를 반환하는 메소드이다.
