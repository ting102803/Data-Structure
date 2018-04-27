import java.util.*;
import java.io.*;

class PhoneBook{
	class Person{//내부클래스 선언
		String name;
		String number;
		Person next;
		Person(String name,String number,Person next){
			this.name=name;
			this.number=number;
			this.next=next;}}//linkedlist로 쓸 노드를 만든다 생성자로는 이름 번호 위치를 받는다.
	Person start;
	public void insert(String Sname,String Snumber) {
		System.out.println("삽입 : "+Sname+" - "+Snumber);//저장한 즉시 바로 출력한다.
		if(start == null||start.name.compareTo(Sname)>0){
			start = new Person(Sname, Snumber, start);}//만약 첫 스타트 값이 없거나 스타트의 이름보다 더 앞에 있는 이름이라면 start에 Sname,Snumber을 넣는다.그리고 그대로 스타트가 가르키는곳을 냅둠
		else {
			Person p = start;//위에 해당사항이 없다면 임의의 노드 p를 만들어서 검색하면서 찾아가야한다.
			while(p.next!=null){//p의 다음값이 있을때 까지 한다는 조건문이다.
				if(Sname.compareTo(p.next.name) <0)break;//만약 들어온문자가 p의 다음번보다 앞이라면 추가해야할곳을 찾았음으로 break하여 나간다
				p=p.next;}//아니라면  p를 한칸씩움직여 p의 적절한 위치를 찾는다
			p.next = new Person(Sname, Snumber,p.next);//찾은 위치에 노드를 넣어준다.
		}}
		public void print(){		
			Person temp = start;//처음부터 인쇄해야함으로 start를 받아와 저장한다.
			int count=1;//앞에 숫자를 인쇄하기위한 수
			while(temp != null){
				System.out.println(count+" : "+temp.name+" "+temp.number);
				temp=temp.next;//이름과 숫자를 출력후 다음 노드로 넘어간다
				count++;
			}}}
public class TestLinkedlist {	
	public static void main(String args[]) {
		String Sname;//이름을 임시로 저장할 공간이다.
		String Snumber;//전화번호를 임시로 저장할 공간이다.
		PhoneBook pb = new PhoneBook();
		System.out.println("파일 읽는중..");
		try {
			FileReader fr = new FileReader("PhoneBook.txt");
			BufferedReader br = new BufferedReader(fr);//텍스트파일을 읽어온다.
			String line = br.readLine();//한줄씩 입력받는다
			while(line!=null){
				{StringTokenizer tk = new StringTokenizer(line, " ");
				while(tk.hasMoreTokens()){
					Sname = tk.nextToken();
					Snumber = tk.nextToken();// 이름과 번호를 스페이스바를 기준으로 나눠서 저장한다.
					pb.insert(Sname,Snumber);//insert메소드를 사용하여 이름과 전화번호를 linkedlist에 이름순으로 저장한다.
					}
				line = br.readLine();}//다음줄 입력받음
		}}catch (IOException e) {
			System.out.println("파일이없어요");
		}
		System.out.println("파일 읽기 완료\n");
		System.out.println("이름으로 정렬된 전화번호부를 출력합니다");
		pb.print();//정렬된것들을 출력하는 메소드
			}}
