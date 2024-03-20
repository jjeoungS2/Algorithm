import java.util.*;
import java.io.*;

// 녹색 옷 입은 애가 젤다지?
// 문제 이름 개웃김 
public class Main {
	
	static int N;
	static int[][] map;
	static int[][] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visit = new int[N][N];
			for(int[] i : visit) {
				Arrays.fill(i, Integer.MAX_VALUE);
			}
			bfs(0,0);
			sb.append("Problem ").append(t+": ").append(visit[N-1][N-1]).append("\n");
			t++;
		}
		System.out.println(sb);
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void bfs(int a,int b) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(a,b,map[a][b]));
		visit[a][b] = map[a][b];
		
		while(!q.isEmpty()) {
			Node idx = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int x = idx.x + dx[i];
				int y = idx.y + dy[i];
				int cost = idx.cost;
				
				if(x < 0 || x >= N || y < 0 || y >= N) continue;
				if(visit[x][y] > cost + map[x][y]) {
					visit[x][y] = cost + map[x][y];
					q.add(new Node(x,y,visit[x][y]));
				}
			}
		}
	}
	
	public static class Node{
		int x;
		int y;
		int cost;
		
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}


}