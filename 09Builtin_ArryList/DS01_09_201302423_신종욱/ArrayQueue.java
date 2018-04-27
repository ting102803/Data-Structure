import java.util.ArrayList;

public class ArrayQueue extends ArrayList<Object> {

	public ArrayQueue() {
		super();//상위 클래스를 상속받아서 사용한다
	}

	public Object first() {
		if (size() == 0) {
			return null;//만약 사이즈가 0이라면 큐가 비였기때문에 null을 return한다.
		} else
			return get(0);//그게아니라면 제일 처음들어왔던 인덱스 0에 저장된 값을 return 한다
	}

	public Object deQueue() {
		if (size() == 0) {
			return null;
		} else {
			Object temp = get(0);
			remove(0);
			return temp;//삭제할때도 first와 같이 제일 처음 들어왔던 인덱스 0에 저장된것을 삭제하면서 그값을 return하면 된다.
		}
	}

	public void addQueue(int data) {
		add(size() + 1, data);
	}//추가는 스택과 같이 가장 뒷 인덱스에 추가하면된다.

	public int size() {
		return super.size();
	}

}
