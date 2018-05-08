import java.util.*;

public class DoubleHashingClass {
 private Entry[] entries;
 private int size, used;
 private float loadFactor;
 private final Entry NIL = new Entry(null,null);
 public int n=0;//이중해싱를 구현하기위한 필드값들을 지정했다 N은 충돌횟수를 세기위한 상수이다.
 
 public DoubleHashingClass(int capacity,float loadFactor){
	 entries = new Entry[capacity];
	 this.loadFactor = loadFactor;
 }
 
 public DoubleHashingClass(int capacity){
	 this(capacity,0.75F);
 }
 public DoubleHashingClass(){
	 this(101);
 }//이중해싱 생성자 선언
 
 public Object get(Object key){
	 int h = hash(key);
	 int d = hash2(key);//이중해싱에서는 hash된 값이 두개 필요하다.
	 for(int i = 0; i<entries.length;i++){
		 int j = nextProbe(h,d,i);
		 Entry entry=entries[j];
		 if(entry == null) break;
		 if(entry==NIL)continue;
		 if(entry.key.equals(key))return entry.value;
	 }//키값을 검색해서 value값을 리턴한다. null을 만났다는건 키값이 없다는 말이다.
	 return null;
 }
 public Object put(Object key, Object value){
	 if(used>loadFactor*entries.length) rehash();
	 int h = hash(key);
	 int d = hash2(key);
	 for(int i = 0 ;i< entries.length;i++){
		 int j = nextProbe(h,d,i);
		 Entry entry = entries[j];
		 if(entry==null){
			entries[j] = new Entry(key,value);
			++size;
			++used;
			return null;
		 }
		
		 if(entry == NIL)continue;
		 if(entry.key.equals(key)){
			 entry.value=(int)entry.value+1;
			 break;//만약 키값이 같은게 있다면 value값을 1증가시키고 for문을 중단한다.
		 }
		 n++;//entry가 null이 아니고 키값도 달라서 다음 j값을 구한다는것은 충돌이 일어 났다는 말이다.
	 }
	 return null;
 }
 
 public Object remove(Object key){
	 int h = hash(key);
	 int d = hash2(key);
	 for (int i =0;i<entries.length;i++){
		 int j = nextProbe(h,d,i);
		 Entry entry = entries[j];
		 if(entry==null)break;//null을 만났다는것은 그값이 없다는걸 말한다.
		 if(entry==NIL)continue;
		 if(entry.key.equals(key)){
			 Object oldValue=entry.value;
			 entries[j]=NIL;
			 --size;
			 return oldValue;//값을 찾은다음 삭제되었다는 NIL로 표시해주고 사이즈를 줄인다.
		 }
	 }
	 return null;
 }
 private class Entry{
	 Object key,value;
	 Entry(Object k , Object v){key = k; value =v ;}
 }//Entry의 구현과 생성자 선언
 public int size(){
	 return size;
 }
 
 private int nextProbe(int h, int d, int i){
	
	 return(h+d+i)%entries.length;
 }
 private int hash(Object key){
	 if(key==null)throw new IllegalArgumentException();
	 return (key.hashCode()&0x7FFFFFFF)%entries.length;
 }
 private int hash2(Object key){
	 if(key==null)throw new IllegalArgumentException();
	 return 1+(key.hashCode()&0x7FFFFFFF)%(entries.length-1);
 }//hash2는 1과 달리 +1을 더해서 계산해서 나오는 해쉬코드의 다양성을 증가 시킨다.
 
 private void rehash(){
	 Entry[] oldEntries = entries;//원래 테이블을 잠시 저장하고
	 entries = new Entry[2*oldEntries.length+1];//새롭게 만들 테이블을 선언한다
	 for (int k =0;k<oldEntries.length;k++){
		 Entry entry = oldEntries[k];
		 if(entry==null||entry==NIL) continue;
		 int h = hash(entry.key);
		 int d = hash2(entry.key);
		 for(int i = 0;i<entries.length;i++){
			 int j = nextProbe(h,d,i);
			 if(entries[j]==null){
				 entries[j]=entry;
				 break;
				 }
			 n++;//null이 아니라면 한번더해야함으로 충돌이 1증가한다.
			 }
			
		 }
	 used=size;
 }
}
