import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N ;j++) {
				for(int t = 0; t < 4; t++) {
					if(i+dx[t] < 0 || i + dx[t] >= N || j + dy[t] < 0 || j + dy[t] >= N ) continue;
					char temp = map[i][j];
					map[i][j] = map[i+dx[t]][j+dy[t]];
					map[i+dx[t]][j+dy[t]] = temp;
					check(i,j);
					map[i+dx[t]][j+dy[t]] = map[i][j];
					map[i][j] = temp;
				}
			}
		}
		System.out.println(ans);
	}
	static int ans = 0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static void check(int a, int b) {
		char c = map[a][0];
		int cnt = 1;
		for(int i = 1; i < N; i++) {
			if(map[a][i] == c) cnt++;
			else {
				ans = Math.max(cnt, ans);
				c = map[a][i];
				cnt = 1;
			}
		}
		ans = Math.max(cnt, ans);
		
		c = map[0][b];
		cnt = 1;
		for(int i = 1; i < N; i++) {
			if(map[i][b] == c) cnt++;
			else {
				ans = Math.max(cnt, ans);
				c = map[i][b];
				cnt = 1;
			}
		}
		ans = Math.max(cnt, ans);

	}
}