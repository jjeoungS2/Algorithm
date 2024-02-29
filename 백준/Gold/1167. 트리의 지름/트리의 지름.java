import java.io.*;
import java.util.*;
public class Main {
	
	static int V;
	static ArrayList<int[]>[] list;
	static int res = 0;
	static boolean[] visit;
	static ArrayList<Integer> check = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		list = new ArrayList[V+1];
		visit = new boolean[V+1];
		
		for(int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			list[x] = new ArrayList<>();
			int node = 0;
			while(true) {
				node = Integer.parseInt(st.nextToken());
				if(node == -1) break;
				else {
					int e = Integer.parseInt(st.nextToken());
					list[x].add(new int[] {node,e});
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(list[i].size() == 1) {
				check.add(i);
			}
		}
		
//		System.out.println(check);
		
		dfs(1,0);
		Arrays.fill(visit, false);	
		
		dfs(node,0);
		System.out.println(res);
	}
	
	static int node;
	public static void dfs(int x, int sum) {
		if(sum > res) {
			res = sum;
			node = x;
		}
		visit[x] = true;

		for(int i = 0; i < list[x].size(); i++) {
			int node[] = list[x].get(i);
			if(!visit[node[0]]) {
				dfs(node[0],sum + node[1]);
				visit[node[0]] = true;
			}
		}
	}
}