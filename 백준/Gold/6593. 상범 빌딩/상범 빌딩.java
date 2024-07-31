import java.util.*;
import java.io.*;
public class Main {
	static int L,R,C;
	static char[][][] map;
	static boolean[][][] visit;
	static int start_x, start_y, start_h;
	static int end_x, end_y, end_h;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] dh = {-1,1};
	static int res = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		StringTokenizer st;
		
		String s;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0) break;
			
			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			res = 0;

			for(int i = 0; i < L; i++) {
				for(int x = 0; x < R; x++) {
					s = br.readLine();
					for(int y = 0; y < C; y++) {
						map[i][x][y] = s.charAt(y);
						if(map[i][x][y] == 'S') {
							start_h = i;
							start_x = x;
							start_y = y;
						} else if(map[i][x][y] == 'E') {
							end_h = i;
							end_x = x;
							end_y = y;
						}
					}
				}
				s = br.readLine();
			}
			
			bfs();
			if(res!=0) {
//				sb.append("Escaped in "+res+" minute(s).\n");
				System.out.println("Escaped in "+res+" minute(s).");
			} else {
//				sb.append("Trapped!");
				System.out.println("Trapped!");
			}
		}
//		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start_h,start_x,start_y,0});
		visit[start_h][start_x][start_y] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int x = temp[1]+dx[i];
				int y = temp[2]+dy[i];
				
				if(x >= 0 && x < R && y >= 0 && y < C && !visit[temp[0]][x][y] && map[temp[0]][x][y] != '#') {
					if(map[temp[0]][x][y] == 'E') {
						res = temp[3]+1;
						return;
					}
					q.add(new int[] {temp[0],x,y,temp[3]+1});
					visit[temp[0]][x][y] = true;
				}
			}
			
			for(int i = 0; i < 2; i++) {
				int h = temp[0]+dh[i];			
				if(h >= 0 && h < L &&  !visit[h][temp[1]][temp[2]] && map[h][temp[1]][temp[2]] != '#') {
					if(map[h][temp[1]][temp[2]] == 'E') {
						res = temp[3]+1;
						return;
					}
					q.add(new int[] {h,temp[1],temp[2],temp[3]+1});
					visit[h][temp[1]][temp[2]] = true;
				}
			}
		}
	}

}