import java.io.*;
import java.util.*;

public class TestHuffman {
	public static void main(String[] args) {
		HashMap<Character, String> result = new HashMap<Character, String>();
		// 최종적으로 만들어지는 허프만코드들을 저장하는공간
		HeapPriorityQueue tree = new HeapPriorityQueue();
		// 허프만 코드를 구현하는데 필요한 우선순위 큐 선언
		HashMap<Character, Integer> huf = new HashMap<Character, Integer>();
		// 문자열과 가중치가 들어가 구성하는 해쉬맵 허프만트리를 구현하기위해 쓰이는 공간
		String word = "";

		try {
			BufferedReader in = new BufferedReader(new FileReader("Huffman.txt"));
			String line = in.readLine();
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while (parser.hasMoreTokens()) {
					word = parser.nextToken().toUpperCase();
					for (int i = 0; i < word.length(); i++) {
						char temp = word.charAt(i);
						if (huf.containsKey(temp))
							huf.put(temp, huf.get(temp) + 1);
						else
							huf.put(temp, 1);// 해쉬맵을 이용해서 문자를 읽으면서 가중치를 더한다 최초이면
												// 1로지정 이미 있는 거라면 +1을 해준다.
					}}
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {}
		
		System.out.println("<<<<  Frequency  >>>>\n");
		
		for (char Cha : huf.keySet()) {
			// 현재 해쉬맵에 있는 문자를 한개씩 읽으면서 인쇄할방법을 찾다가 for문기능중 ':'가 있다는걸 알았다 Cha에
			// huf.keyset값을 한개씩 넣으면서 진행하는 for문이다
			System.out.println(Cha + " : " + huf.get(Cha));// 문자와 그 문자의 나온 횟수를
															// 프린트한다
			Huffman temp = new Huffman(Cha, huf.get(Cha));
			tree.add(temp);// 그와 동시에 그값들을 우선순위 큐에 추가한다.
		}
		Huffman code = new Huffman(' ', 0);
		code = code.maketree(tree, tree.size());// 우선순위 큐를 이용하여 허프만트리를 만든다.

		makecode(code, "", result);// 만들어진 허프만 트리를 이용하여 허프만코드를 만든다.

		System.out.println("\n<<<<  Huffman Code  >>>>\n");
		
		for (char Cha : result.keySet()) {
			System.out.println(Cha + " : " + result.get(Cha));
		} // 허프만 코드를 출력한다

		System.out.println("\n<<<<  Text Encoding  >>>>\n");
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("Huffman.txt"));
			String line = in.readLine();
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				String coding = "";// 스트링 초기화
				while (parser.hasMoreTokens()) {
					word = parser.nextToken().toUpperCase();// 파일 읽기
					for (int i = 0; i < word.length(); i++) {
						coding += result.get(word.charAt(i));
					} // 한줄씩 읽고 그리고 한문자열씩 허프만 코드를 만들어서 계속 만든후
				}
				System.out.println(coding);// 한줄이 끝나면 코드를 출력한다.
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
		}

	}

	public static void makecode(Huffman A, String S, HashMap<Character, String> B) {
		if (A == null)
			return;
		makecode(A.rchild, S + "1", B);// 오른쪽 자식으로 갈경우 '1'스트링을 더하고 계속 실행
		makecode(A.lchild, S + "0", B);// 왼쪽 자식으로 갈경우 '0'스트링을 더하고 계속 실행
		if (A.alphabet != ' ') {// 만약 허프만코드의 문자가 공백이아니라면 해당문자열에 도착하였음으로 그값을 해쉬맵인
								// B에 저장한다
			B.put(A.alphabet, S);// 순회하는 방식으로 코드를 구현하였다.
		}
	}
}
