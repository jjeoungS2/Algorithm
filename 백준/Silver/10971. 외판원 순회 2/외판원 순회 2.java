import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] W;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		W = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
			visited[0] = true;
			dfs(0, 0, 1, 0);
			System.out.println(Min);

	}
	static int Min = Integer.MAX_VALUE;
	static void dfs(int start, int x, int cnt, int cost) {
		
		if (start == x && cost > 0) {
			Min = Math.min(Min, cost);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (W[x][i] > 0) {
				if (i == start && cnt == N) {// 되돌아 왔을 때,
					cost+=W[x][i];
					dfs(start, i, cnt + 1, cost);
				} else if(!visited[i]) {
					visited[i] = true;
					cost += W[x][i];
					
					dfs(start, i, cnt+1, cost);
					
					cost -= W[x][i];
					visited[i] = false;
				}
			}
		}
	}
}
