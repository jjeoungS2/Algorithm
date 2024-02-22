import java.io.*;
import java.util.StringTokenizer;
// 그림  
public class Main {
	static int n,m;
	static int[][] map;
	static int[][] visit;
	static int res = 0;
	static int paint_cnt = 0;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(visit[i][j] == 0 && map[i][j] == 1) {
					paint_cnt++;
					dfs(i,j);
					if(cnt > res) res = cnt;
				}
				cnt = 0;
			}
		}
		System.out.println(paint_cnt);
		System.out.println(res);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void dfs(int a, int b) {
		cnt++;		
		visit[a][b] = 1; 
		
		for(int i = 0; i < 4; i++) {
			if(a+dx[i] < 0 || a+dx[i] >= n || b + dy[i] < 0 || b + dy[i] >= m || visit[a+dx[i]][b+dy[i]] == 1 || map[a+dx[i]][b+dy[i]] == 0) continue;
			dfs(a + dx[i], b + dy[i]);
		}
	}
}