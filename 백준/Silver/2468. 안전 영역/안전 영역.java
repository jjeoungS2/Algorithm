import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전 영역 
public class Main {
	
	static int N;
	static int map[][];
	static boolean visited[][];
	static int res = 1;
	static int max_h = Integer.MIN_VALUE;
	static int min_h = Integer.MAX_VALUE;
	static int rain = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int i = 0; i < N; i++ ) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max_h = Math.max(map[i][j], max_h);
				min_h = Math.min(map[i][j], min_h);
			}
		}
	
		while(rain < max_h) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N;j++) {
					if(map[i][j] > rain && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			rain++;
			res = Math.max(cnt,res);
		}
		System.out.println(res);
	}
	
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void bfs(int a, int b) {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {a,b});
		visited[a][b] = true;
		
		while(!q.isEmpty()) {
			
			int[] idx = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int x = idx[0] + dx[i];
				int y = idx[1] + dy[i];
				
				if(x < 0 || y < 0 || x >= N || y >= N || map[x][y] <= rain || visited[x][y]) continue;
				else {
					q.add(new int[] {x,y});
					visited[x][y] =true;
				}	
			}
		}
	}
}
