import java.io.*;
import java.util.*;
 
 
public class TestHashMap{
	public static void main(String[] args) {
		HashMap<String, Integer> A = new HashMap<String, Integer>();//hashmap 선언
		try{
			BufferedReader in = new BufferedReader(new FileReader("Caesar.txt")); 
			String line = in.readLine();
		while(line!=null){
			StringTokenizer parser = new StringTokenizer(line," ,:;-.?!"); 
				while (parser.hasMoreTokens()) {
				String word = parser.nextToken().toUpperCase();//파일 읽기
				if(A.containsKey(word)){
					A.replace(word, (int)A.get(word)+1);
				}//파일을 읽으면서 문자열을 추가하는데 만약 같은 문자가 이미있으면 value를 +1시키고
				else A.put(word, 1);
				//아닐 경우에는 값을 1로하여 추가한다.
				}
					line = in.readLine();
}
		in.close();
}
		catch(IOException e){}
		System.out.println("I 갯수 : "+A.get("I"));
		System.out.println("YOU 갯수 : "+A.get("YOU"));
		System.out.println("HE 갯수 : "+A.get("HE"));
		System.out.println("BRUTUS 갯수 : "+A.get("BRUTUS"));
		System.out.println("EVIL 갯수 : "+A.get("EVIL"));
		System.out.println("THE 갯수 : "+A.get("THE"));
		System.out.println("AND 갯수 : "+A.get("AND"));//문자열 수자들 출력
	}}