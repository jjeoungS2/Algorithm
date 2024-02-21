import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int V,E;	// 	정점개수, 간선개수
	static int[][] graph;
	static int[] parent;
	static int res = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new int[E][3];
		parent = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(graph,(o1,o2)->Integer.compare(o1[2], o2[2]));
		
		for(int i = 0; i < E; i++) {
			if(find(graph[i][0]) != find(graph[i][1])) {
				res+= graph[i][2];
				union(graph[i][0], graph[i][1]);
			}
		}
		System.out.println(res);
	}
	
	public static void union(int a, int b) {
		int a_parent = find(a);
		int b_parent = find(b);
		if(a_parent < b_parent) {
			parent[b_parent] = a_parent;
		} else {
			parent[a_parent] = b_parent;
		}
	}

	public static int find(int x) {
		if(x == parent[x]) return x;
		return find(parent[x]);
	}
}