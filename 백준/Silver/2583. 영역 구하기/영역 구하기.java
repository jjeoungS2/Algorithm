import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

// 영역 구하기 
public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int M,N,K;
	static int res = 0;
	static ArrayList<Integer> area = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j < x2; j++) {
				for(int k = y1; k < y2; k++) {
					visited[k][j] = true;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					res++;
				}
			}
		}

		Collections.sort(area);
		
		System.out.println(res);
		for(int i = 0 ; i<area.size();i++) {
			System.out.print(area.get(i)+" ");
		}
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void dfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[a][b] = true;
		q.add(new int[] {a,b});
		int arr = 1;
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			for(int i = 0; i<4; i++) {
				int nx = idx[0] + dx[i];
				int ny = idx[1] + dy[i];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] ) continue;
				else {
					visited[nx][ny] = true;
					arr++;
					q.add(new int[] {nx,ny});
				}
			}
		}
		area.add(arr);
	}
}