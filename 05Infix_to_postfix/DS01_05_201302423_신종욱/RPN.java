public class RPN {
	public static void main(String args[]) {
		new Transform().infixToPostfix(args);
		new RPN(new Transform().infixToPostfix(args));
	}
	public RPN(String[] args) {
		ArrayStack stack = new ArrayStack(args.length);
		System.out.print("변경된 후위식 : ");
		for(int i=0; i<args.length; i++){
			System.out.print(args[i]+" ");
		}System.out.println("");
		for (int i = 0; i < args.length; i++) {
			String input = args[i];//배열값 한개씩 넣음

			System.out.print(input + " ");

			if (isAnOperator(input)) {
				double y = Double.parseDouble((String) stack.pop());
				double x = Double.parseDouble((String) stack.pop());
				double z = evaluate(x, y, input);
				stack.push("" + z);//계산된값을 스택에 쌓는다.
			} else
				stack.push(input);// 연산자일 경우 스택에서 두개를 pop해서 계산하고  피연산자일경우 push해서 스택에 쌓는다.
		}
	}

	private boolean isAnOperator(String s) {
		return (s.length() == 1 && "ASMD".indexOf(s) >= 0);
	}//연산자인지 확인하는 메소드

	private double evaluate(double x, double y, String op) {
		double z = 0;

		if (op.equals("A"))
			z = x + y;
		else if (op.equals("S"))
			z = x - y;
		else if (op.equals("M"))
			z = x * y;
		else
			z = x / y;

		System.out.println(x + " " + op + " " + y + " = " + z);
		return z;
	}}//들어온 연산자에 따라 계산하는 메소드이다.