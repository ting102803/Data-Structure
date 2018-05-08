

public class SeparateChainingClass {
 private Entry[] entries;
 private int size;
 private float loadFactor;
 public int n =0;//폐쇄주소법를 구현하기위한 필드값들을 지정했다 N은 충돌횟수를 세기위한 상수이다.
 
 public SeparateChainingClass(int capacity,float loadFactor){
	 entries = new Entry[capacity];
	 this.loadFactor = loadFactor;
 }
 
 public SeparateChainingClass(int capacity){
	 this(capacity,0.75F);
 }
 public SeparateChainingClass(){
	 this(101);
 }//폐쇄주소법 새엉자 선언
 
 public Object get(Object key){
	 int h = hash(key);
	 for(Entry e = entries[h];e!=null;e=e.next){
		 if(e.key.equals(key))return e.value;
	 }//같은 값을 찾을때까지 Entry를 앞으로 나아가면서 찾는다
	 return null;
 }
 public Object put(Object key, Object value){
	 int h = hash(key);
	 if(entries[h]!=null&&!entries[h].key.equals(key)) {n++;}//폐쇄주소법에선 첫번째원소가 null이 아니고 키값도 일치하지않는 다면 충돌이 일어났다는 뜻이다.
	 for(Entry e = entries[h];e!=null;e=e.next){
		 if(e.key.equals(key)){
			 e.value=(int)e.value+1;
			return null;
		 }
	 }
	 entries[h]=new Entry(key,value,entries[h]);
	 ++size;//null까지갔는데 같은값이 없다는것을 같은키값이 없으므로 새로운 entry를 추가한다.
	 if(size>loadFactor*entries.length) rehash();
	 return null;
 }
 
 public Object remove(Object key){
	 int h = hash(key);
	 for (Entry e = entries[h],prev=null;e!=null;prev = e,e=e.next){
		 if(e.key.equals(key)){//삭제하기위해선 삭제하기 전의 위치인 prev를 알아야하기 때문에 prev선언을 하여야한다.
			 Object oldValue=e.value;
			 if(prev == null)entries[h]=e.next;
			 else prev.next = e.next;
			 --size;
			 return oldValue;
		 }
	 }
	 return null;
 }
 private class Entry{
	 Object key,value;
	 Entry next;
	 Entry(Object k , Object v,Entry n){key = k; value =v ; next=n;}
 }//Entry의 구현과 생성자 선언
 public int size(){
	 return size;
 }
 
 private int hash(Object key){
	 if(key==null)throw new IllegalArgumentException();
	 return (key.hashCode()&0x7FFFFFFF)%entries.length;
 }
 
 private void rehash(){
	 Entry[] oldEntries = entries;//원래 테이블을 잠시 저장하고
	 entries = new Entry[(2*oldEntries.length)+1];//새롭게 만들 테이블을 선언한다
	 for (int k =0;k<oldEntries.length;k++){
		for(Entry old = oldEntries[k];old!=null;){
			Entry e =old;
			old = old.next;
			int h = hash(e.key);
			if(entries[h]!=null) {n++;}//rehash시에는 새롭게만들어져 들어갈공간이 null이 아니라면 충돌이 일어나기때문에 n을 증가시키면된다.
			e.next=entries[h];
			entries[h]=e;
			
		}
			
		 }
 }
}
