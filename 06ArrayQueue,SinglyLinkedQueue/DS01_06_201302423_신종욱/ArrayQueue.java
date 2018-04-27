
public class ArrayQueue implements Queue{
	Object queue[];
	int size;
	int queueSize;
	int front=-1, rear=-1;//초기화를 -1로 각각 해주었다
	
	public ArrayQueue(int queueSize){
		this.queue=new Object[queueSize];
		this.queueSize=queueSize;
	}
	public void add(Object object){
		if(queueSize-1==rear){
			System.out.println("Queue is Full! RESIZE");
			resize();//배열사이즈-1이 rear와 같다는것은 rear가 배열끝에 왔다는 것이기때문에 꽉찼다는거다.
		}
		queue[++rear]=object;
		size++;
		System.out.print("ADD        "+object+" | ");
		print();//꽉찬게 아니라면 rear를 증가시키고 값을 저장하고 사이즈를 늘린다음 출력한다.
	}
	
	public Object first(){
		if (isEmpty()){
			System.out.println("Queue is Empty");
			return null;
		}
		else {return queue[front+1];}//첫번째 원소를 리턴하는 메소드이다.
	}
	public Object remove(){
		if (isEmpty()){
			System.out.println("Queue is Empty");//삭제하는데 queue가 비여있으면 삭제할게 없음으로 메시지를 출력한다
		return null;}
		else {
		Object temp=queue[front+1];//삭제하기전에 미리 저장해둔다.
		queue[front+1]=null;
		System.out.print("REMOVE     "+temp+" | ");
		for(int i=0;i<rear;i++){
			queue[i]=queue[i+1];
		}//삭제후 배열을 한칸씩 이동한다
		queue[rear]=null;//마지막 칸은 초기화해준다.
		rear--;
		size--;//rear과 size를 한개씩 줄인다
		print();
		return temp;}
	}
	public int size(){
		return size;
	}
	public void print(){
		if(isEmpty()){System.out.println("");}
		else {int look=front;
		while(rear!=look+1){
		System.out.print(queue[look+1]+"<--");
		look++;
		}//front를 대체할 look이라는걸 선언해서 한개씩 인쇄하면 된다.
		System.out.println(queue[look+1]);}
	}
	
	public void resize(){
			Object temp[]=queue;
			queue = new Object[2*temp.length];
			System.arraycopy(temp,0, queue,0, size);//배열이 꽉찼을경우 두배로 늘리기위해하는 메소드이다.
		
	}
	public boolean isEmpty(){
		if (rear==front){
		return true;}
		else return false;//비였으면 true 아니라면 false를 리턴하는 메소드이다.
	}
	
}
