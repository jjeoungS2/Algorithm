import java.util.*;
import java.io.*;

public class Main {
	static int N,M,R;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int T = Math.min(N, M)/2;
		
		for(int t = 0; t < R; t++) {
			for(int i = 0; i < T; i++) {
				int temp = map[i][i];
				
				// <-
				for(int j = i; j < M-i-1; j++) {
					map[i][j] = map[i][j+1];
				}
				
				// ^
				for(int j = i; j < N-i-1; j++) {
					map[j][M-i-1] = map[j+1][M-i-1];
				}
				
				// ->
				for(int j = M-i-1; j > i; j--) {
					map[N-i-1][j] = map[N-i-1][j-1];
				}
				
				// 아
				for(int j = N-i-1; j > i; j--) {
					map[j][i] = map[j-1][i];
				}
				map[i+1][i] = temp;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}