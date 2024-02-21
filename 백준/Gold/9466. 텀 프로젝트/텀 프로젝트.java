import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int T, n;
	static int[] list;
	static boolean[] visited;
	static boolean[] finish;
	static int cnt = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for(int tc = 0; tc < T; tc++){
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			list = new int[n+1];
			visited = new boolean[n+1];
			finish = new boolean[n+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= n ;i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i <= n; i++) {
				dfs(i);
			}
			
			System.out.println(n-cnt);
		}
	}

	static void dfs(int x) {
		if(visited[x]) return;
		
		visited[x] = true;
		int next = list[x];
		
		if(visited[next] != true) dfs(next);
		else {
			if(!finish[next]) {
				cnt++;
				for(int i = next; i != x; i = list[i]) {
					cnt++;
				}
			}
		}
		
		finish[x] = true;
	}
}