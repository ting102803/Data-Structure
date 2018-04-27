import java.util.ArrayList;

public class ArrayStack extends ArrayList<Object> {

	public ArrayStack() {
		super();//상위 클래스를 상속받아서 사용한다
	}

	public Object peek() {
		if (size() == 0) {//만약 사이즈가 0이라면 아직 스택이 존재하지않음 그럼으로 null을 retrun
			return null;
		} else
			return get(size() - 1);//스택이 존재한다면  인덱스 0부터 차곡 차곡 쌓기때문에 맨뒤에있는 배열을 리턴하면 된다.
	}

	public Object pop() {
		if (size() == 0) {
			return null;//스택이 비였다면 리턴할께 없다.
		} else {
			Object temp = get(size() - 1);
			remove(size() - 1);
			return temp;//pop의 경우에는 젤위 있는 값을 배열에서 제거하면서 return하는 메소드로 구현해야하는데 temp라는 임시 저장소를 만들어서 이용하면된다.
		}

	}

	public void push(int data) {
		add(size() + 1, data);
	}//push는 마지막 배열에 추가한다고 생각하면 된다.

	public int size() {
		return super.size();
	}//size는 상위클래스의 사이즈를 리턴한다.

}
