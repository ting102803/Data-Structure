
class Graph {
int size;
String[] vertices;
boolean[][] a;

public Graph(String[] args){
	size = args.length;
	vertices = new String[size];
	System.arraycopy(args, 0, vertices, 0, size);
	a = new boolean[size][size];
}
public void add(String v, String w){
	int i = index(v), j = index(w);
	a[j][i] = a[i][j] = true;
}
private int index(String v){
	for (int i = 0; i <size;i++)
		if ( vertices[i].equals(v))
			return i;
	return a.length;
}
public void toStirng(){
		StringBuffer buf = new StringBuffer(vertex(0));
	for (int i =1; i<size;i++)
		buf.append(vertex(i));
	System.out.println("\n"+buf);
}
private String vertex(int i){
	StringBuffer buf = new StringBuffer(vertices[i]+" | ");
	for (int j =0;j<size;j++)
		if(a[i][j])
			buf.append(" ture  ");
		else buf.append(" false ");
	return buf + "\n";
}
}
