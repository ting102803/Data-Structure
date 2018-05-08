import java.io.*;
import java.util.*;

public class TestHashingClass {

	public static void main(String[] args) {
		int lineNumber=0;
		LinearProbing A = new LinearProbing();
		 QuadraticProbing B = new  QuadraticProbing();
		 DoubleHashingClass C =new  DoubleHashingClass();
		 SeparateChainingClass D = new SeparateChainingClass();//4가지의 해싱방법 생성
		try{
			BufferedReader in = new BufferedReader(new FileReader("input.txt")); 
			String line = in.readLine();
		while(line!=null){
			++lineNumber;
			StringTokenizer parser = new StringTokenizer(line," ,:;-.?!"); 
				while (parser.hasMoreTokens()) {
				String word = parser.nextToken().toUpperCase();
			

				A.put(word, 1);
				B.put(word, 1);
				C.put(word, 1);
				D.put(word, 1);//각각 추가할때마다 value는 1로 지정
				}

					
					line = in.readLine();
}
		in.close();
}
		catch(IOException e){}
		
		System.out.println("선형조사 총 충돌횟수 : "+A.n);
		System.out.println("제곱조사 총 충돌횟수 : "+B.n);
		System.out.println("이중해싱 총 충돌횟수 : "+C.n);
		System.out.println("폐쇄주소법 총 충돌횟수 : "+D.n);
		
		System.out.println("I 갯수 : "+A.get("I"));
		System.out.println("YOU 갯수 : "+B.get("YOU"));
		System.out.println("HE 갯수 : "+C.get("HE"));
		System.out.println("BRUTUS 갯수 : "+D.get("BRUTUS"));
		System.out.println("EVIL 갯수 : "+A.get("EVIL"));
		System.out.println("THE 갯수 : "+B.get("THE"));
		System.out.println("AND 갯수 : "+C.get("AND"));
		
		
	}}
