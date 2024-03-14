import java.util.*;
import java.io.*;

// 드래곤 커브 
public class Main {

	static int N;
	static int x,y,d,g;
	static boolean[][] map;
	static int res = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];	
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 시작점 
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			// 시작방향 
			d = Integer.parseInt(st.nextToken());
			// 세대 
			g = Integer.parseInt(st.nextToken());
			dragon(x,y,d,g);
		}
		
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) res++;
			}
		}
		System.out.println(res);
	}
	// 	오른쪽, 위, 왼쪽, 아래 
	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static ArrayList<Integer> list;
	public static void dragon(int x, int y, int d, int g) {
		list = new ArrayList<>();
		list.add(d);	// 시작방향
		map[y][x] = true;
		for(int i = 0; i < g; i++) {
			int size = list.size()-1;
			for(int j = size; j >= 0; j--) {
				int dd = list.get(j) + 1;
				list.add(dd%4);
			}
		}
		int xx = x;
		int yy = y;
		for(int i = 0; i < list.size(); i++) {
			int dd = list.get(i);
			xx = xx + dx[dd];
			yy = yy + dy[dd];
			if(xx < 0 || xx > 100 || yy < 0 || yy > 100) continue;
			else map[yy][xx] = true;
		}
	}

}