
public class TestPrimClass {

	public static void main(String[] args) {
		PrimClass A = new PrimClass();
		String[] T = {"A","B","C","D","E","F","G"};
		int M=Integer.MAX_VALUE;//가중치에서 최대값은 연결안된 상태를 나타낸다.
		int[][] E = {
					{M,4,M,M,M,1,2},
					{4,M,2,M,M,M,5},
					{M,2,M,4,M,M,1},
					{M,M,4,M,1,M,2},
					{M,M,M,1,M,3,4},
					{1,M,M,M,3,M,3},
					{2,5,1,2,4,3,M}
					};//정점과 간선의 가중치들을 선언하였다.
		A.make(T,E);
		A.prim("A");
		System.out.println("비용합계 : "+A.cost);
		
		
	}

}