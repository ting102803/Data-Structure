public class ArrayStack{
	private Object[] a;
	int size;
	
	public ArrayStack(int capacity){
		a = new Object[capacity];}
	
	public boolean isEmpty(){
		return (size == 0);}//스택이 비였는지 확인하는 메소드
	
	public Object peek(){
		if(size == 0)
			throw new IllegalStateException("Stack is empty");
		return a[size-1];}//스택의 가장 위에값을 리턴하는 메소드
	
	public Object pop(){
		if(size == 0)
			throw new IllegalStateException("Stack is empty");
		Object object = a[--size];
		a[size] = null;
		return object;}//스택의 가장위에값을 제거하면서 리턴하는 메소드
	
	public void push(Object object){
		if(size == a.length)
			resize();
		a[size++] = object;}//스택 가장위에 값을 쌓아올리는 메소드
	
	public int size(){
		return size;}//스택의 가장위를 알려주는 메소드
	
	private void resize(){
		Object[] aa = a;
		a = new Object[2*aa.length];
		System.arraycopy(aa, 0, a, 0, size);}
	}//만약 스택이 꽉찼을경우 크기를 2배로 늘리는 메소드