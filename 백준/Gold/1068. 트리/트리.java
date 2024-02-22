import java.io.*;
import java.util.*;
public class Main {

	static int N;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	static int root = 0;
	static int d;
	static int res = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num == -1) root = i;
			else {
				list[i].add(num);
				list[num].add(i);		
			}
		}
		
		d = Integer.parseInt(br.readLine());
		
		visit[d] = true;	
		visit[root] = true;
		
		if(d == root) {
			System.out.println(0);
			return;
		} else dfs(root);
		System.out.println(res);
	}
	
	public static void dfs(int r) {
		visit[r] = true;
		int node = 0;
		for(int i : list[r]) {
			if(!visit[i]) {
				node++;
				dfs(i);
			}
		}
		if(node == 0) res++;
	}

}