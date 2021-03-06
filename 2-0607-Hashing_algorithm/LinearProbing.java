import java.util.*;

public class LinearProbing {
 private Entry[] entries;
 private int size, used;
 private float loadFactor;
 private final Entry NIL = new Entry(null,null);
 public int n =0;//선형조사를 구현하기위한 필드값들을 지정했다 N은 충돌횟수를 세기위한 상수이다.
 
 public LinearProbing(int capacity,float loadFactor){
	 entries = new Entry[capacity];
	 this.loadFactor = loadFactor;
 }
 
 public LinearProbing(int capacity){
	 this(capacity,0.75F);
 }
 public LinearProbing(){
	 this(101);
 }//선형 조사들의 생성자들 선언
 
 public Object get(Object key){
	 int h = hash(key);
	 for(int i = 0; i<entries.length;i++){
		 int j = nextProbe(h,i);
		 Entry entry=entries[j];
		 if(entry == null) break;//null을 만났다는건 키값이 없다는 말이다.
		 if(entry==NIL)continue;
		 if(entry.key.equals(key))return entry.value;
	 }
	 return null;
 }//키값을 검색해서 value값을 리턴한다.
 public Object put(Object key, Object value){
	 if(used>loadFactor*entries.length) rehash();//적재율을 넘을 경우 rehash한다.
	 int h = hash(key);
	 for(int i = 0 ;i< entries.length;i++){
		 int j = nextProbe(h,i);
		 Entry entry = entries[j];
		 if(entry==null){
			entries[j] = new Entry(key,value);
			++size;
			++used;
			return null;
		 }//만약 i가 0일때 null을 만난다면 충돌이 일어나지않고 끝날것이다
		 if(entry == NIL)continue;
		 if(entry.key.equals(key)){
			 entry.value=(int)entry.value+1;
			 break;//만약 같은 키값을 찾는다면 value값을 1증가시키고 추가하는 작업을 중단한다.
		 } n++;//entry가 null이 아니고 키값도 달라서 다음 j값을 구한다는것은 충돌이 일어 났다는 말이다.
		 
	 }
	 return null;
 }
 
 public Object remove(Object key){
	 int h = hash(key);
	 for (int i =0;i<entries.length;i++){
		 int j = nextProbe(h,i);
		 Entry entry = entries[j];
		 if(entry==null)break;//null을 만났다는것은 그값이 없다는걸 말한다.
		 if(entry==NIL)continue;
		 if(entry.key.equals(key)){
			 Object oldValue=entry.value;
			 entries[j]=NIL;
			 --size;//값을 찾은다음 삭제되었다는 NIL로 표시해주고 사이즈를 줄인다.
			 return oldValue;
		 }
	 }
	 return null;//위에서 return이 안되면 없으므로 null을 리턴
 }
 private class Entry{
	 Object key,value;
	 Entry(Object k , Object v){key = k; value =v ;}
 }//Entry의 구현과 생성자 선언
 public int size(){
	 return size;
 }
 
 private int nextProbe(int h, int i){
	 return(h+i)%entries.length;
 }//h+i의 합을 배열의 크기로 나눈 나머지를 리턴한다
 private int hash(Object key){
	 if(key==null)throw new IllegalArgumentException();
	 return (key.hashCode()&0x7FFFFFFF)%entries.length;
 }//key값의 부호비트를 제외한 해쉬코드의 값을 entry의 크기를 나눈후 나머지를 리턴한다
 
 private void rehash(){
	 Entry[] oldEntries = entries;//원래 테이블을 잠시 저장하고
	 entries = new Entry[(2*oldEntries.length)+1];//새롭게 만들 테이블을 선언한다
	 for (int k =0;k<oldEntries.length;k++){
		 Entry entry = oldEntries[k];
		 if(entry==null||entry==NIL) continue;
		 int h = hash(entry.key);
		 for(int i = 0;i<entries.length;i++){
			 int j = nextProbe(h,i);
			 if(entries[j]==null){
				 entries[j]=entry;
				 break;//j번째 배열이 비였다면 비여있다는 말이기때문에 바로 해당 for문을 나와야한다.
				 }
			 n++;//null이 아니라면 한번더해야함으로 충돌이 1증가한다.
			 }
			
		 }
	 used=size;
 }
}
