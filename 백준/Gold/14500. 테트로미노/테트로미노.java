import java.io.*;
import java.util.StringTokenizer;
public class Main {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int max = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i,j,1,map[i][j]);
				visit[i][j] = false;
				u(i,j,map[i][j]);
			}
		}
		
		System.out.println(max);
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	// dfs를 4번으로 끊어서 보면 ㅗ 모양빼고 다 볼 수 있음!!
	public static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int idx = x + dx[i];
			int idy = y + dy[i];
			
			if(idx < 0 || idx >= N || idy < 0 || idy >= M || visit[idx][idy]) continue;
			
			visit[idx][idy] = true;
			dfs(idx,idy,cnt+1,sum + map[idx][idy]);
			visit[idx][idy] = false;
		}
	}
	
	public static void u(int x, int y, int sum) {
		if( y-1 >= 0 && x -1 >= 0 && y + 1 < M) 
			max = Math.max(max, sum + map[x][y-1] + map[x][y+1] + map[x-1][y]);
		if( x-1 >= 0 && x+1 < N && y+1 < M)
			max = Math.max(max, sum + map[x-1][y] + map[x+1][y] + map[x][y+1]);
		if( y-1 >= 0 && y+1 < M && x+1 < N)
			max = Math.max(max, sum + map[x][y-1] + map[x][y+1] + map[x+1][y]);
		if( x-1 >= 0 && x+1 < N && y-1 >=0)
			max = Math.max(max, sum + map[x-1][y] + map[x+1][y] + map[x][y-1]);
	}
}