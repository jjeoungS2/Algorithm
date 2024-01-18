import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] clear; 
					// 아래, 왼쪽, 위, 오른쪽 
	static int[] back_dx = {1,0,-1,0};
	static int[] back_dy = {0,-1,0,1};
					// 위, 오른쪽, 아래, 왼쪽 
	static int[] go_dx = {-1,0,1,0};
	static int[] go_dy = {0,1,0,-1};
	static int now_x, now_y, d;
	static int res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		now_x = Integer.parseInt(st.nextToken());
		now_y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		clear = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean non_clear = false;
		
		while(true) {
			// 현재 칸이 청소했는지 안했는지 확인  
			if(map[now_x][now_y] == 0 ) {
				map[now_x][now_y] = 2;
				res++;
			} 
			
			non_clear = false;
			
			
			for(int i = 0; i < 4; i++) {
				if(now_x + go_dx[i] < 0 || now_x + go_dx[i] >= N || now_y + go_dy[i] < 0 || now_y + go_dy[i] >= M) continue;
				else if( map[now_x + go_dx[i]][now_y + go_dy[i]] == 0) {
					non_clear = true;
					break;
				}
			}
			
			// 주변 4칸중에 청소안한 칸 있을 때 
			if(non_clear) {
				if(d == 0) d = 3;
				else d -= 1;
				if(now_x + go_dx[d] < 0 || now_x + go_dx[d] >= N || now_y + go_dy[d] < 0 || now_y + go_dy[d] >= M) continue;
				if(map[now_x + go_dx[d]][now_y + go_dy[d]] == 0) {
					now_x = now_x + go_dx[d];
					now_y = now_y + go_dy[d];
				}
				
			} 
			// 청소안한 칸 없을 때 
			else {
				if(now_x + back_dx[d] < 0 || now_x + back_dx[d] >= N || now_y + back_dy[d] < 0 || now_y + back_dy[d] >= M) continue;
				else if( map[now_x + back_dx[d]][now_y + back_dy[d]] != 1) {
					now_x = now_x + back_dx[d];
					now_y = now_y + back_dy[d];
				} else {
					break;
				}
			}	
		}
		
		System.out.println(res);
	}

}