import java.util.*;
import java.io.*;

// 알고스팟 
public class Main {
	static int M,N;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		// 0은 빈방 1은 벽 
		
		bfs(0,0);
		System.out.println(visit[N-1][M-1]);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] visit;
	public static void bfs(int a, int b) {
		visit = new int[N][M];
		for(int[] i : visit) {
			Arrays.fill(i, Integer.MAX_VALUE);
		}
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(a,b,0));
		visit[a][b] = 0;

		while(!q.isEmpty()) {
			Node idx = q.poll();

			for(int i = 0; i < 4; i++) {
				int x = idx.x + dx[i];
				int y = idx.y + dy[i];
				int wall = idx.wall;
				
				if(x < 0 || x >= N || y < 0 || y >= M) continue;
				if(map[x][y] == 1) {
					if(visit[x][y] > wall + 1) {
						visit[x][y] = wall + 1;
						q.add(new Node(x,y,wall+1));
					}
				} else if(map[x][y] == 0) {
					if(visit[x][y] > wall) {
						visit[x][y] = wall;
						q.add(new Node(x,y,wall));
					}
				}
			}
		}
	}
	
	public static class Node{
		int x;
		int y;
		int wall;
		
		public Node(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
	}
}