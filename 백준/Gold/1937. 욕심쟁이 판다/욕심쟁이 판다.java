import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] list;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res = 0;
 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		list = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				res = Math.max(dfs(i,j),res);
			}
		}
		System.out.println(res);
	}
 	
 	private static int dfs(int x, int y) {
 		if(dp[x][y] != 0) return dp[x][y];
 		dp[x][y] = 1;
 		for(int i = 0; i < 4; i++) {
 			int nx = x + dx[i];
 			int ny = y + dy[i];
 			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
 			if(list[nx][ny] > list[x][y]) {
 				dp[x][y] = Math.max(dp[x][y], dfs(nx,ny)+1);
 			}
 		}
 		return dp[x][y];
 	}

}