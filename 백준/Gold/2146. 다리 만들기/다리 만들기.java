import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] map2;
	static boolean[][] visit;
	static int[][] check;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		map2 = new int[N][N];
		visit = new boolean[N][N];
		check = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					bfs(i,j,cnt);
					cnt++;
				}
			}
		}

		visit = new boolean[N][N];
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				if(map2[i][j]!=0 && !visit[i][j]) {
					bridge_check(i,j,map2[i][j],0);
					visit = new boolean[N][N];
				}
			}
		}
		System.out.println(res);
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void bfs(int x, int y, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;
		map2[x][y] = cnt;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int idx = temp[0] + dx[i];
				int idy = temp[1] + dy[i];
				if(idx < 0 || idx >= N || idy < 0 || idy >= N || visit[idx][idy] || map[idx][idy] == 0) continue;
				map2[idx][idy] = cnt;
				visit[idx][idy] = true;
				q.add(new int[] {idx,idy});
			}
		}
	}
	
	public static void bridge_check(int x, int y, int island, int num) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,num});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i = 0; i < 4; i++) {
				int idx = temp[0] + dx[i];
				int idy = temp[1] + dy[i];
				if(idx < 0 || idx >= N || idy < 0 || idy >= N || visit[idx][idy] || map2[idx][idy] == island ) continue;
				if(temp[2]+1 > res) return;
				if(map2[idx][idy] != island && map2[idx][idy] != 0) {
					res = Math.min(temp[2], res);
				}
				visit[idx][idy] = true;
				q.add(new int[] {idx,idy,temp[2]+1});
			}
		}
	}
}