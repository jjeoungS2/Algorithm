import java.util.*;
import java.io.*;
// 경사로 2트 
public class Main {
	static int N,L;
	static int[][] map;
	static int res = 0;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		int i;
		int j;
		
		for(i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가로 
		for(i = 0; i < N; i++) {
			int flag = 0;
			int before = map[i][0];
			for(j = 1; j < N; j++) {
				if(map[i][j] == before) {
					continue;
				}
				if(Math.abs(map[i][j] - before) != 1) {
					flag = 1;
					break;
				}
				else if(map[i][j] > before) {		
					int c = j-1;
					int cnt = 0;
					int t = 0;
					while(true) {
						if(t == L) break;
						if(c < 0) break;
						if(map[i][c] == before && !visit[i][c]) cnt++;
						c--;
						t++;
					}
					if(cnt < L) {
						before = map[i][j];
						flag = 1;
						break;
					}
				} else if(map[i][j] < before) {
					int c = j;
					int cnt = 0;
					int t = 0;
					while(true) {
						if(t == L) break;
						if(c >= N) break;
						if(map[i][c] == map[i][j]) cnt++;
						c++;
						t++;
					}
					if(cnt == L) {
						c--;
						before = map[i][c];
						j = c;
						for(int y = 0; y < L; y++) {
							visit[i][c] = true;
							c--;
						} 
						continue;
					}
					if(cnt < L) {
						before = map[i][j];
						flag = 1;
						break;
					}
				}
				before = map[i][j];
			}
			if(flag == 0) {
				res++;
			}
		}
		visit = new boolean[N][N];
		// 세로 
		for(i = 0; i < N; i++) {
			int flag = 0;
			int before = map[0][i];
			for(j = 1; j < N; j++) {
				if(map[j][i] == before) continue;
				if(Math.abs(map[j][i]-before)!=1) {
					flag = 1; break;
				} else if(map[j][i] > before) {
					int c = j-1;
					int cnt = 0;
					int t = 0;
					while(true) {
						if(t == L) break;
						if(c < 0) break;
						if(map[c][i] == before && !visit[c][i]) cnt++;
						c--;
						t++;
					}
					if(cnt < L) {
						flag = 1;
						break;
					}
				} else if(map[j][i] < before) {
					int c = j;
					int cnt = 0;
					int t = 0;
					while(true) {
						if(t == L) break;
						if(c >= N) break;
						if(map[c][i] == map[j][i]) cnt++;
						c++;
						t++;
					}
					
					if(cnt == L) {
						c--;
						before = map[c][i];
						j = c;
						for(int y = 0; y < L; y++) {
							visit[c][i] = true;
							c--;
						} 
						continue;
					}
					
					if(cnt < L) {
						flag = 1;
						break;
					}
				}
				before = map[j][i];
			}
			if(flag == 0) {
				res++;
			}

		}
		System.out.println(res);

	}

}