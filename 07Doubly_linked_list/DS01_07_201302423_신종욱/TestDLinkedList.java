import java.util.Random;

public class TestDLinkedList {
		public static DLinkedList list = new DLinkedList();
		
		public static void main(String arg[]){
			insertDoublyLL();
			deleteDoublyLL();
		}
		public static void insertDoublyLL(){
			for(int i=0;i<10;i++){
				int y =new Random().nextInt(100);
				list.insert(y);
				System.out.printf("Insert   %3d | ",y);
				list.print();
			}
		}
		public static void deleteDoublyLL(){
			Node p = list.head;
			for(int i=0;i<3;i++){
				Object deleteNumber = p.next.object;
				list.delete((int)deleteNumber);
				System.out.printf("Delete   %3d | ",(int)deleteNumber);
				list.print();
			}
		}
	}


