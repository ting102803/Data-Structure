import java.io.*;
import java.util.*;

public class TestGraph {
	public static void main(String[] args) {
		int lineNumber=0;
		try{
			BufferedReader in = new BufferedReader(new FileReader("Graph.txt")); // 파일을 읽어온다.
			String line = in.readLine();
			StringTokenizer parser = new StringTokenizer(line, " ");//스페이스에 의해 구분되는 파서 생성
			++lineNumber;
			String s= parser.nextToken();//첫번째로 구분되는수 즉 정점의 갯수를 저장한다.
			String r = parser.nextToken();// 두번째로 구부노디는 수 즉 접선의 갯수를 저장
			String[] mt = new String[Integer.parseInt(s)];//정점의 갯수를 사이즈로해서 스트링 배열을 만든다.
			Graph test = new Graph(mt);//그 사이즈로 배열을 만든다.
			line = in.readLine();//다음줄로 넘어간다.
		while(line!=null){
			++lineNumber;
			StringTokenizer parser2 = new StringTokenizer(line, " ");
				while(parser2.hasMoreTokens()){
					if(lineNumber==2){
						int z;
						for(z=0;z<Integer.parseInt(s);z++){
							String k = parser2.nextToken();
							test.vertices[z]=k;	
							System.out.print("      "+k+"");}
	}//파일의 두번째줄은 접점들의 이름을 다 출력하면서 저장하는 과정이다.
					if(lineNumber>=3){
						String v= parser2.nextToken();
						String w = parser2.nextToken();
						test.add(v,w);
	}//그 다음 줄 부터는 접점들의 연결상태를 판단하여서 연결 되어있는곳에 ture를 저장하면된다.
					line = in.readLine();
}}
		test.toStirng();// 저장된 배열들의 값들을 출력한다.
		in.close();
}
		catch(IOException e){}
	}}
