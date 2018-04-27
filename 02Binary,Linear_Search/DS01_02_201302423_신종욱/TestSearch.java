import java.util.*;
 class Search {//main에서 쓰게될 Search 클래스이다.
	public int sequentialSearch(int arr[], int x){//선형탐색 메소드 생성
		int i = 0;
		for (i =0;i<arr.length;i++)//
			if(arr[i]==x) {System.out.println("찾으시는 값은 "+i+"배열에 있고"+i+"번 연산하였습니다."); 
			return i;}//첫배열부터 한개씩 순차적으로 검색해서 같은지 비교하는 메소드이다.
		{System.out.println("존재하지않는 값입니다."+i+"번 연산하였습니다.");return -1;	
		}}
	
	public int binarySearch(int arr[], int x){//이진탐색 메소드 생성//
		
		int p = 0, q= arr.length-1;
		int i=0;
		int j=0;//연산횟수를 구하기위한 변수
		while (p<=q){
			i = (p+q)/2;
			if (arr[i]==x)  {j++;
			System.out.println("찾으시는 값은 "+i+"배열에 있고"+j+"번 연산하였습니다."); return i;}
			if (arr[i]<x) {p=i+1; j++;}
			else {q = i-1; j++;}
		}//중간 배열부터시작하여 대소비교를 이용해서 계속 중간값으로 가서 배열을 찾는 메소드이다.
		{System.out.println("찾으시는 값이 존재하지않습니다. 추가하신다면 "+(i+1)+"배열에 추가되며"+j+"번 연산하였습니다."); return -1;
		}}
}
public class TestSearch {
private static Scanner in;

public static void main(String args[]){
	in = new Scanner(System.in);
	System.out.print("데이터크기 : ");
	int n=0;
	n = in.nextInt();
	int size = n;
	int randomInt[] = new int [size];//입력받은 데이터크기만큼 배열을 생성한다.
	Random rd = new Random();//난수 생성기
	for(int i =0; i<size;i++){
		randomInt[i] = rd.nextInt(size);//생성된 난수를 배열에 저장한다.
	}
	System.out.print("찾으시는 값: ");
	int s=0;
	s = in.nextInt();//찾는 값 입력
	System.out.println("선형탐색 결과입니다.");
	Search pb = new Search();//search 클래스를 불러온다.
	long start, end, elapsedTime;
	start = System.nanoTime();
	pb.sequentialSearch(randomInt, s);// 선형탐색 메소드를 실행한다.
	end = System.nanoTime();
    elapsedTime = end - start;//시작시간과 끝나는 시간의 차가 걸린시간이다.
    System.out.println("선형탐색으로 걸린시간은 "+ elapsedTime/1000000.0+"ms입니다.");
    
    Arrays.sort(randomInt);//난수배열들을 오름차순으로 정리한다.
    System.out.println("선형탐색 결과입니다.");
    start = System.nanoTime();
	pb.binarySearch(randomInt,s);//이진탐색 메소드를 실행한다.
	end = System.nanoTime();
    elapsedTime = end - start;//시작시간과 끝나는 시간의 차가 걸린시간이다.
    System.out.println("선형탐색으로 걸린시간은"+ elapsedTime/1000000.0+"ms입니다.");
}
}
