public class Deap {
	int[] deap;
	int n = 0; //deap에 있는 원소의 개수; 루트는 비어 있다.
 
	public Deap(int maxSize) {
		deap = new int[maxSize]; 
	}
       
	private boolean inMaxHeap(int i) { //인덱스 i가 max-heap에 위치해 있으면 true를 리턴하고, 그렇지 않으면 false를 리턴한다
		while (i >= 3) {
            i = (i-1)/2;
        }
        if (i == 1) return false;
        return true;
	}
 
        
	private int maxPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		if((pos +Math.pow(2, exponent))>n) return (int)((pos +Math.pow(2, exponent))-1)/2;
		//없을경우 부모의 인덱스를 리턴한다
		return (int) (pos +Math.pow(2, exponent));//인덱스 pos가 min-heap에 위치해 있을때 max partner의 인덱스를 리턴한다
	}
 
	private int minPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		return (int) (pos - Math.pow(2, exponent));
	}//인덱스 pos가 max-heap에 위치해 있을때 min partner의 인덱스를 리턴한다
        
        
	private void minInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent);
		deap[at] = key;
	}//min-heap에 있는 인덱스 at 위치에 key를 삽입
 
	private void maxInsert(int at, int key) {
		  for (int parent; (parent = (at -1)/ 2) != 0 && key > deap[parent]; deap[at] = deap[parent], at = parent) ;
	        deap[at] = key;
	    }//max-heap에 있는 인덱스 at 위치에 key를 삽입
 
	public int deleteMax() {//max값을 삭제하는 메소드이다 즉 right트리의 루트를 삭제해야한다
		int i, j;
        int max;
        if (n >= 2) {
            max = deap[2];//만약 크기가 2이상일땐 2번인덱스가 max값이다
        } else {
            n--;
            return deap[1];
        }//2개 미만 즉 한개만 있을때는 1번배열이 최소값이자 최대값임으로 리턴하고 끝낸다
        int replace = deap[n--];// 삭제 된곳에는 노드 맨끝에 있는 값이 들어가야한다
      
        for (i = 2; 2*i <= n; deap[i] = deap[j], i = j) {//맥스 힙중 루트를 제외한 가장 최대값을 찾는 for문이다
            j = i * 2+1;//j는  루트의 왼쪽자식을 가리킨다
            if (j+1 <= n) {//만약 오른쪽 자식이 있고
                if (deap[j] < deap[j+1]) {//오른쪽 자식이 크다면
                    j++;//오른쪽 자식이 더큼으로 j를 1증가 시킨다
                }
            }
        }
 
        j = minPartner(i);//찾은 최대값에 대응하는 min힙의 인덱스를 구한다
        int minchild = j;//max힙에 대응하는 minheap과 그자식들도 그관계가 충족해야하기에 확인하는 과정이다
        if (2*j+1 <= n) {//바로 자식중의 큰값도 찾은 최대값보다 작아야한다는 조건이다
            minchild = 2*j+1;//대응하는 값의 왼쪽 자식의 인덱스를 구한다
            if (((2*j + 2) <= n) && (deap[2*j+1] < deap[2*j+2])) {
                minchild++;//minpartner의 자식중 큰값의 인덱스를 구하는 과정이다
            }
        }
        if (replace < deap[minchild]) {//minpartner의 자식중 큰값과 맨끝노드를 비교하여 맨끝노드가 더작다면 맨끝노드를 
            deap[i] = deap[minchild];//더큰값이 max힙쪽으로 가야함으로 빈곳을 채워주고
            minInsert(minchild, replace);//작은값은 min힙으로들어가서 추가된다
        } else {
            maxInsert(i, replace);//그게아니라면 더큰값인 맨끝노드를 max힙에 넣으면된다
        }
        return max;
    }
        
    
	public int deleteMin() {
		int i, j, min = deap[1];
		int replace = deap[n--];// 삭제 된곳에는 노드 맨끝에 있는 값이 들어가야한다
        for (i = 1; 2*i <= n; deap[i] = deap[j], i = j) {
            j = i * 2+1;//min힙의 왼쪽 자식을 구한다
            if (j+1 <= n && deap[j] > deap[j+1]) {
                j++;//오른자식도 있고 왼쪽자식중에 오른자식이 더작다면 j값을 증가시킨다
            }
        }//min힙중 루트를 제외한 가장 작은값을 찾는 과정이다.
        
        j = maxPartner(i);//작은것의 max파트너의 인덱스를 구한다
        if (replace > deap[j]) {//만약 맨끝노드의값이 max파트너보다 클경우 deap의 조건에 만족을 안하기때문에
            deap[i] = deap[j];//파트너를 min힙에 넣고
            maxInsert(j, replace);//맨끝노드를 max힙에 넣는다
        } else {
            minInsert(i, replace);//그게아니라면 맨끝노드를 min힙에 넣는다
        }
        return min;
    }
        
        //x를 삽입한다
	public void insert(int x) {
 
		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;
 
		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}
		}
	}
 
	//deap을 프린트한다
	public void print() {
	        int levelNum = 2;
	        int thisLevel = 0;
	        int gap = 8;
	        for (int i = 1; i <= n; i++) {
	            for (int j = 0; j < gap-1; j++) {
	                System.out.print(" ");
	            }
	            if (thisLevel != 0) {
	                for (int j = 0; j < gap-1; j++) {
	                    System.out.print(" ");
	                }
	            }
	            if (Integer.toString(deap[i]).length() == 1) {
	                System.out.print(" ");
	            }
	            System.out.print(deap[i]);
	            thisLevel++;
	            if (thisLevel == levelNum) {
	                System.out.println();
	                thisLevel = 0;
	                levelNum *= 2;
	                gap/=2;
	            }
	        }
	        System.out.println();
	        if (thisLevel != 0) {
	            System.out.println();
	        }
	}
	
	public static void main(String[] argv) {
		Deap a = new Deap(1024);
 
		int[] data = { 4, 65, 8, 9, 48, 55, 10, 19, 20, 30, 15, 25, 50 };
		for (int i = 0; i < data.length; i++) {
			a.insert(data[i]);
		}
 
		System.out.println("initial Deap");
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
 
	}
}