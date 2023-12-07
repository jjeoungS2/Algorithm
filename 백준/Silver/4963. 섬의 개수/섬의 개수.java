import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w,h;
	static int[][] map;
	static boolean[][] visited;
	static int res;
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
						dfs(i,j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}
	
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,1,-1,-1,1,-1,1};
	public static void dfs(int a, int b) {
		visited[a][b] = true;
		
		for(int i = 0; i < 8; i++) {
			int x = a + dx[i];
			int y = b + dy[i];
			if(x < 0 || y < 0 || x >= h || y >= w || map[x][y]!=1 || visited[x][y]) continue;
			else dfs(x,y);
		}
	}

}
