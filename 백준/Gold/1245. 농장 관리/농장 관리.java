import java.io.*;
import java.util.*;
// 농장 관리 
public class Main {

	static int N,M;
	static int[][] map;
	static boolean[][] top;
	static boolean[][] visit;
	static int res = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		top = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i= 0; i < N; i++) {
			for(int j = 0; j < M;j++) {
				if(map[i][j] != 0 && !top[i][j]) bfs(i,j);
			}
		}
		System.out.println(res);
	}
	// 대각선 \위 /위 \아래 /아래  
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, 1 , -1};
	public static void bfs(int x, int y) {
		visit = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		ArrayList<int[]> bong = new ArrayList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i = 0; i < 8; i++) {
				int idx = temp[0] + dx[i];
				int idy = temp[1] + dy[i];
				
				if(idx < 0 || idx >= N || idy < 0 || idy >= M || visit[idx][idy]) continue;
				// 인접한 곳에 나보다 더 높은곳이 있으면 산봉우리 아니니까 리턴
				if(map[idx][idy] > map[temp[0]][temp[1]]) return;
				else if(map[idx][idy] == map[temp[0]][temp[1]]) {
					q.add(new int[] {idx, idy});
					bong.add(new int[] {idx,idy});
				}
				visit[idx][idy] = true;
			}
		}
		
		for(int i = 0; i < bong.size(); i++) {
			int[] temp = bong.get(i);
			top[temp[0]][temp[1]] = true;
		} 
		res++;
		
	}

}