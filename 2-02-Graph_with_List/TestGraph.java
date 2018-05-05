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
			String r = parser.nextToken();// 두번째로 구분되는 수 즉 접선의 갯수를 저장
			int[] mt = new int[Integer.parseInt(s)];//정점의 갯수를 사이즈로해서 인트 배열을 만든다.
			Graph test = new Graph(mt);//그래프를 만든다.
			line = in.readLine();//다음줄로 넘어간다.
			System.out.print("{");
		while(line!=null){
			++lineNumber;
			StringTokenizer parser2 = new StringTokenizer(line, " ");
				while(parser2.hasMoreTokens()){
					if(lineNumber==2){
						int z;
						for(z=0;z<Integer.parseInt(s);z++){
							String k = parser2.nextToken();
							test.vertices[z]=k;//vertices배열에 a~f까지 알파벳을 저장해서 나중에 출력할때 쓰도록하자.
							if(z==0)
							{System.out.print(k+"");}
							else System.out.print(","+k+"");}//스트링들 출력할때 만약 첫번째라면 콧마를 없이 출력한다.
	}//파일의 두번째줄은 접점들의 이름을 다 출력하면서 저장하는 과정이다.
					if(lineNumber>=3){
						String v= parser2.nextToken();
						String w = parser2.nextToken();
						test.add(v,w);
	}
					line = in.readLine();
}}System.out.print("}");
		System.out.println("\n"+test.toString());// 저장된 배열들의 값들을 출력한다.
		in.close();
}
		catch(IOException e){}
		}
	
	}
