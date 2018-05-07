import java.util.*;

public class PrimClass {
	ArrayList<Node> T;//연결됨 정점과 비용을 저장하는 리스트
	HashSet<String> TV;//현재 연결되고있는 정점들을 저장하는 집합,방문 유무도 판단가능
	String[] V;//정점 정보를 저장하는 배열
	int[][] E;// 정점들의 연결가중치를 저장하기위한 배열
	int cost;//총 비용 계산을 위한 정수값

	public void make(String[] A, int[][] B) {
		V = A;
		E = B;
		T = new ArrayList<Node>();
		TV = new HashSet<String>();
	}

	public void prim(String A) {
		int a = -1, b = -1;// T와 TV에 저장할껄 기억하기위해 쓰는 정수
		TV.add(A);//일단 시작하는 것은 무조건 연결될 예정이기 때문에 미리 연결한다
		int m = Integer.MAX_VALUE;

		while (T.size()+1 != V.length) {
			int mincost=m;
			for (int k = 0; k < V.length; k++) {
				for (int j = 0; j < V.length; j++) 
				if (TV.contains(V[k])&&!TV.contains(V[j])&&E[k][j] < mincost) {
					mincost = E[k][j];
					a = k;
					b = j;//집합에 포함된 문자열에서 포함안된 문자열로 뻗어가는 간선중 가장 가중치 작은걸 찾는다
					}}//최종으로 찾은값은 a,b로 인덱스들이 저장되어있다.
				System.out.println("선택한 간선 : (" + V[a] + ", " + V[b] + ", " + mincost+")");
				cost += mincost;
				Node temp = new Node(a, b, mincost);
				T.add(temp);//배열들과 비용을 저장해서 T에 더해준다
				TV.add(V[b]);//최종선택되어 연결된부분을 집합 V에 더해준다.
			}}
}

class Node {
	int in;
	int out;
	int cost;
	// 가중치 배열의 행렬위치를 기억해서 정점의 정보를 저장하기위한 정수

	Node(int in, int out, int cost) {//생성자 선언
		this.in = in;
		this.out = out;
		this.cost = cost;
	}
}
