
public class Transform {
	private ArrayStack stack;
	int k = 0;//temp의 빈배열중 가장 낮은 수를 나타내는 변수이다.
	int count=0;//temp의 배열중 null가 null이 아닌값의 갯수를 구하는 변수이다.
	public String[] infixToPostfix(String[] args) {
		stack = new ArrayStack(args.length);//스택에 크기 지정
		String[] temp=new String[args.length]; //순서가 변경된 후위식을 저장하기위한 배열 생성
		for(int i=0; i<args.length; i++){
			if(args[i].equals("A")||args[i].equals("S")||args[i].equals("D")||args[i].equals("M")||args[i].equals("(")||args[i].equals(")"))
			{if(stack.size==0){
				stack.push(args[i]);
				}//연산자가 들어왔는데 스택이 비여있다면 무조건 push하여서 쌓아야한다.
			else if((precedence((Object)args[i])<=precedence((Object)stack.peek()))){//만약 현재 스택에 가장 높게있는 값이  새로들어온거보다 크거나 같다면 스택을 비우는 작업을해야한다.
				if (args[i].equals("(")){stack.push(args[i]);}//하지만 "("가 들어왔다면 빼주는게아니라 바로 push하여야한다.
				else while(stack.isEmpty()!=true){
					if(args[i].equals(")")==false)
					{temp[k]=(String)stack.pop();//배열에 저장할땐 string으로 변환후 저장
					k++;
					}//"("가 아니라면 계속 빼서 스택을 비워주면서 temp로 저장줘야한다 들어온게 ")"라면는 따로 해야함으로 밑에 작성하였다.
					else if (args[i].equals(")")){
						while(stack.peek().equals("(")==false)
						{temp[k]=(String)stack.pop();
						k++;
						}//들어온게 ")" 경우에는 하나씩 꺼낼때 "("가 한번 나오면 pop을 그만해야한다. 연산자들을 POP할땐 temp에 저장하여 후위식을 만든다.
						stack.pop(); break;}//아직 스택엔 "("하나를 안뺏음으로 빼고 더이상 스택을 비우면 안됨으로 while문을 나오기위해 break 사용
				}//여기서 중요한점은 )가 들어오면 (를 한개 뺄때까지 pop을 하는것이다.
				if(args[i].equals(")")==false&&args[i].equals("(")==false) 
					stack.push(args[i]);//()가  아니라면 스택이 위에처리에 의해 적당량 pop됬기때문에 이제 push해서 다시 stack을 채우면된다.
			}else {stack.push(args[i]);}//새로들어온게 stack의 젤위 값보다 크면 계속 쌓아준다
			}
			else {System.arraycopy(args, i, temp, k, 1);
			k++;}//연산자가 아니라면 temp배열로 바로 넣어준다.
		}
			while(stack.isEmpty()!=true){
				if(stack.peek().equals(")")==false&&stack.peek().equals("(")==false)
				{temp[k]=(String)stack.pop();
				k++;
				}//다하고 나왔는데 stack에 연산자가 남아있다면 남은 연산자들을 다 temp배열에 저장한다.
				else stack.pop();//이 예외가 실행될땐 ()숫자를 잘못했다. 에러를방지하기위해 pop을함
				}
			if(temp[args.length-1]==null){
				while(temp[count]!=null){
					count++;}
				String[] temp2=new String[count];
				System.arraycopy(temp, 0, temp2, 0, count);
				return temp2;}//만약 temp배열에 맨마지막값이 null이라면 이배열은 괄호를 써서 빈공간이 생긴 배열이다 빈공간을 없애기위해
			//temp2를 새로만들어서 temp의 값을 복사하여 넣어주고 return한다.
			return temp;}//그게 아니라면 그냥 temp를 return하면 된다.
	
	public int precedence(Object object) {
			if(object.equals("(")){
				return 1;}
			else if(object.equals(")")){
				return 1;}
			else if(object.equals("A")){
				return 2;}
			else if(object.equals("S")){
				return 2;}
			else if(object.equals("M")){
				return 3;}
			else if(object.equals("D")){
				return 3;}
			else return 0;//연산자 순위를 정하기위해 각각의 연산자에 숫자를 지정하였다.
	}	}