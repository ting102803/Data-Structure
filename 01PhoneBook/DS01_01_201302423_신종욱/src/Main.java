import java.util.*;
import java.io.*;
class data {//이름과 번호를 저장하기위한 객체 배열을 선언하기위한 과정들
	String name;
	String number;
	public data(String name, String  number) {
		this.name = name;
		this.number =  number;}//배열에 저장하고 꺼내기 편하게 하기위해서 사용 하였다.
	public String getname() {
		return name;}//이름을 리턴하는 메소드
	public String getnumber() {
		return  number;}}//번호를 리턴하는 메소드
class Program {
	data[] list = new data[20];//배열의 크기는 임의로 20으로 잡았습니다.
	StringTokenizer tk;//문자열 분해기
	String name,  number, Sname, line;
	int count = 0;// 현재 빈배열중 가장 앞에 배열의 위치를 나타내는 상수이다
	Scanner in = new Scanner(System.in);// 이름과 번호를 입력 받을때 쓰는 스캐너
	public void Save() {//저장한다음 어떤 메소드 실행할지 선택
		try {
				FileReader fr = new FileReader("PhoneBook.txt");
				BufferedReader br = new BufferedReader(fr);//텍스트파일을 읽어온다.
				line = br.readLine();//한줄씩 입력받는다.
				while (line != null) //줄이 없어질때까지 받음
				{StringTokenizer tk = new StringTokenizer(line, " "); //tk라는 분해기가 띄어쓰기마다 단어를 자른다
					while(tk.hasMoreTokens()){
						name = tk.nextToken();//분리기로 처음 자른걸(이름이 처음으로 잘린다) name에 저장한다 그후 커서를 뒤로 옮긴다
						number = tk.nextToken();// 다음거에 잘린걸(전화번호) number에 저장한다 그후 커서를 뒤로 옮긴다.
						list[count++] = new data(name, number);}// 앞에서 저장한 name과 number을 list 배열에 추가한후 count를 1증가 시킨다.
						line = br.readLine();}// txt파일의 커서를 다음으로 옮기고, 다음 줄의 내용을 line에 저장한다.
						br.close();}// 자원소모 최소화
		catch (IOException e) {}}
	public void Search(){
		System.out.println("검색하실 사람의 이름을 입력하세요.");
		System.out.print("이름  : ");//입력된 이름을 Sname에 저장하여 검색할때 사용
		Sname = in.nextLine();
		int j = 0;//같은 이름이 존재하는지 알아 내기위한 카운트
		for (int m = 0; m < count; m++) {
			if (Sname.equals(list[m].getname())) {
				System.out.print(list[m].getname()+"에 대한 번호는 ");
				System.out.println(list[m].getnumber()+"입니다.");
				j=j+1;}}//같은 이름이 존재했을때 1을 더함
		if(j==0)//같은이름이 존재 하지 않을때 
			System.out.println(Sname+"은(는) 존재하지않습니다.");	}
	public void Update(){
		System.out.println("추가하실 목록의 사항을 입력해주세요.");
		System.out.print("이름 : ");
		Sname = in.nextLine();	
		int j = 0;
		for (int m = 0; m < count; m++) {
			if (Sname.equals(list[m].getname())) {
				System.out.print("이미 있는 이름입니다 수정 하실번호 : ");
				String bnumber=list[m].getnumber();//같은 이름이 있는지 확인후 원래번호를 임시로 저장한다.
				number = in.nextLine();//수정할 번호를 입력받는다.
				list[m]= new data(Sname,number);
				System.out.println(list[m].getname()+"의 번호을(를)"+bnumber+">>"+number+"으로 수정했습니다.");
				j=j+1;//찾았다면 j를 더해 없는 이름일경우의 실행을 막는다.
				}}
			if (j==0){//다 돌았는데도 같은게 없다면 없는 이름이다.
				System.out.print("번호 : ");
				number = in.nextLine();
				list[count] = new data(Sname,  number);//입력받은걸 name number로 저장후 빈배열중 가장 앞에 저장한다
				System.out.println(list[count].getname()+" : "+list[count].getnumber()+"을(를) 추가했습니다.");
				count++;} //빈배열 카운트를 1증가시킴
				}
	public void File_to_Print(){
		try {
			FileWriter fw = new FileWriter("PhoneBookOut.txt");
			BufferedWriter bw = new BufferedWriter(fw);
				for (int m = 0; m < count; m++) {
					bw.append(list[m].getname()+" "+list[m].getnumber());//이름과 전화번호를 추가한다.
					bw.newLine();}//다음줄로 넘어간다
				bw.flush();//입력된 내용들을 파일에 출력한다.
				System.out.println("File_to_Print가 완료 되었습니다. 프로그램을 종료합니다.");
				bw.close();}//파일을 닫아 자원들을 반환함
		catch(IOException e) {System.out.println("오류가있습니다.");}}}

public class Main {
public static void main(String args[]) {
	Program pb = new Program();//메소드들을 들고있는 클래스를 불러오고 클래스에 사용되는 문자열 정수를 정의해줌
	pb.Save();//배열에 저장하는 메소드 실행
	int sw=-1;// 어떤 메소드를 실행할지 선택할때 쓰는 정수 초기값은 -1로 설정
	while (sw!=2){
	System.out.print("Search:0, Update:1, Print to File:2 >>>>");//메소드 선택문
	sw = new Scanner(System.in).nextInt();//어떤 메소드를 할지숫자를 입력 받음
	switch(sw){
	case 0: {
	pb.Search();
	break;} //0을 입력 받았을경우 Search 메소드 실행
	case 1: {
	pb.Update();
	break;}//1을 입력 받았을 경우 Update 메소드 실행	
	case 2: {pb.File_to_Print();
	break;}//2를 입력 받았을경우 File_to_Print 메소드 실행
	default : {
		System.out.println("숫자를 다시 입력하세요");}
	}}}}