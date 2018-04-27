import java.util.Random;

public class TestMain {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack();
		ArrayQueue queue = new ArrayQueue();//상위클래스를 불러오면서 stack과 queue를 저장한다
		for (int i = 1; i <= 10; i++) {
			stack.add(new Random().nextInt(100));
			queue.add(new Random().nextInt(100));//난수를 스택과 큐에 저장한다.
		}
		System.out.print("************  Test ArrayStack  ************\n");
		for (int i = 0; i <= 10; i++) {
			if (stack.peek() != null)
				System.out.printf("%2d : %2d / ", i, stack.peek());
			else
				System.out.print(i + " : Stack is Empty /");
			if (stack.peek() != null)
				System.out.printf("%2d\n", stack.pop());
			else
				System.out.print("Stack is Empty");//peek하고 pop하는 과정인데 만약 null이라면 비였다는 메세지를 출력한다.

		}
		System.out.printf("\n\n************  Test ArrayQueue  ************\n");
		for (int i = 0; i <= 10; i++) {
			if (queue.first() != null)
				System.out.printf("%2d : %2d / ", i, queue.first());
			else
				System.out.print(i + " : Queue is Empty / ");
			if (queue.first() != null)
				System.out.printf("%2d\n", queue.deQueue());
			else
				System.out.print("Queue is Empty ");//first하고 dequeue하는 과정인데 만약 null이라면 비였다는 메세지를 출력한다.
		}
		System.out.print("\n완료하였습니다.");
	}

}
