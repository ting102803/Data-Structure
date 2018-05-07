import java.util.*;

class Graph {
int size;
String[] vertices;
boolean[][] a;
boolean[] visits;
int i = 0;//dst트리의 

public Graph(String[] args){
	size = args.length;
	vertices = new String[size];
	System.arraycopy(args, 0, vertices, 0, size);
	a = new boolean[size][size];//Graph 선언후 구성에 필요한 배열들을 만드는 과정들이다.
}
public void add(String v, String w){
	int i = index(v), j = index(w);
	a[j][i] = a[i][j] = true;//만약 add한다면 2차원 배열에서 서로 true로하여 연결되었다고 나타낸다.
}
public int index(String v){
	for (int i = 0; i <size;i++)
		if ( vertices[i].equals(v))
			return i;//문자열의 인덱스값을 추출하기위한 인덱스 메소드이다.
	return a.length;
}

public void bfsTree(String start){
    Queue <String> q = new <String> LinkedList(); // string을 저장하는 큐를 선언한다.
    System.out.println("Root : "+start);
    q.add(start);//첫번째 시작하는곳을 루트로 출력한후 큐에 더한다
    visits = new boolean[size];
	visits[index(start)] = true;// 그래프에서 각각의 방문 여부를 알기위해서 visits를 선언해서 저장하도록하자
    
    while(!q.isEmpty()){
        String temp = q.poll();
        System.out.print(temp+" 탐색 : ");
    for(int j = 1; j < size; j++){
		if(a[index(temp)][j]&& visits[j] == false){
            q.add(vertices[j]);
            System.out.print(vertices[j]+" ");
            visits[j] = true;//큐에서 한개를 꺼낸후 꺼낸 문자와  연결되어있고 방문하지 않은 문자 찾은후 q에 더하는 for문이다                
            }}//더 더한후에는 q가 empty가 될때까지 while문을 반복한다.
    System.out.println("");
       } }

public void dfsTree(String start){
		if(i==0){visits = new boolean[size];i++;}//dstTree가 처음인지 확인한후 처음에만 visits를 선언한다 왜나하면 재귀적으로 구성되기때문에 계속 새로선언하면 초기화가 된다.
        visits[index(start)] = true;//들어온 문자를 mark한다.
        System.out.print("ROOT("+start+")-->");
        for(int j=1;j<size;j++){
        	if(a[index(start)][j]&& visits[j] == false){
        		System.out.println(vertices[j]);
        		dfsTree(vertices[j]);//들어온 문자의 인접행렬중 미방문 문자가 있다면 출력후 바로 dfs를 실행하여 깊이탐색을 구현하였다.
            }}}


}
