import java.io.*;
import java.util.*;
// 치즈 3트 
public class Main {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int time = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false;
		while(true) {
			time++;
			visit = new boolean[N][M];
			bfs(0,0);
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						cnt++;
						if(check(i,j)) {
							map[i][j] = 0;
						}				
					}
				}
			}
			if(cnt == 0) break;
		}	
		System.out.println(time-1);
	}
	
	public static boolean check(int x,int y) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			if(map[x+dx[i]][y+dy[i]] == 2) cnt++;
		}
		if(cnt >= 2) return true;
		else return false;
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void bfs(int a, int b) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(a,b));
		map[a][b] = 2;
		visit[a][b] = true;
		while(!q.isEmpty()) {
			Point idx = q.poll();
			for(int i = 0; i < 4; i++) {
				int x = idx.x + dx[i];
				int y = idx.y + dy[i];
				if(x < 0 || x >= N || y < 0 || y >= M) continue;
				if(visit[x][y] || map[x][y] == 1) continue;
				map[x][y] = 2;
				visit[x][y] = true;
				q.add(new Point(x,y));
			}
		}
	}	
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}