import java.io.BufferedReader;
import java.io.*;
import java.util.*;

// 섬의 개수 - 그래프
// 1이 땅
public class Main {
	static int w,h;
	static int[][] map;
	static boolean[][] visited;
	static int res;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,1,-1,-1,1,-1,1};
	public static void bfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {a,b});
		visited[a][b] = true;
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			for(int i = 0; i < 8; i++) {
				int x = idx[0] + dx[i];
				int y = idx[1] + dy[i];
				if(x < 0 || y < 0 || x >= h || y >= w || visited[x][y] || map[x][y]!=1) continue;
				else {
					q.add(new int[] {x,y});
					visited[x][y] = true;
				}
			}
		}
		res++;
		return;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {	
			res = 0;
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h;i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			System.out.println(res);
		}
	}


}
