import java.io.*;
import java.util.*;
public class Main {

	static int n;
	static ArrayList<int[]> list[];
	static boolean visit[];
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for(int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[node1].add(new int[] {node2,cost});
			list[node2].add(new int[] {node1,cost});
		}
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(visit, false);
			dfs(i,0);
		}
		System.out.println(max);
	}
	
	public static void dfs(int node, int sum) {
		visit[node] = true;
		max = Math.max(sum, max);
		
		for(int[] temp : list[node]) {
			int next = temp[0];
			int cost = temp[1];
			if(!visit[next]) {
				dfs(next,sum+cost);
			}
		}
	}

}