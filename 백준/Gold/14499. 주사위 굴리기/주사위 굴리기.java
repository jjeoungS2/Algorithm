import java.io.*;
import java.util.*;

public class Main {

	static int N,M,x,y,K;
	static int[][] map;
					//	하늘, 땅, 왼, 오, 위, 아래 
	static int[] dice = {0, 0, 0, 0, 0, 0};
	static int direction;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < K; i++) {
			direction = Integer.parseInt(st.nextToken());
			int temp1,temp2;
			if(map_check()) {
				temp1 = dice[0];
				temp2 = dice[1];
				switch(direction) {
				case 1:	// 오른쪽
					dice[0] = dice[2];
					dice[1] = dice[3];
					dice[2] = temp2;
					dice[3] = temp1;
					break;
				case 2:	// 왼쪽
					dice[0] = dice[3];
					dice[1] = dice[2];
					dice[2] = temp1;
					dice[3] = temp2;
					break;
				case 3:
					dice[0] = dice[5];
					dice[1] = dice[4];
					dice[4] = temp1;
					dice[5] = temp2;
					break;
				case 4:
					dice[0] = dice[4];
					dice[1] = dice[5];
					dice[4] = temp2;
					dice[5] = temp1;
					break;
				}
				
				if(map[x][y] == 0) {
					map[x][y] = dice[1];
				} else {
					dice[1] = map[x][y];
					map[x][y] = 0;
				}
				sb.append(dice[0]).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static boolean map_check() {
		int idx = 0, idy = 0;
		// 오른쪽, 왼쪽, 위, 아래 
		switch(direction) {
		case 1:
			idx = dx[0];
			idy = dy[0];
			break;
		case 2:
			idx = dx[1];
			idy = dy[1];
			break;
		case 3:
			idx = dx[2];
			idy = dy[2];
			break;
		case 4:
			idx = dx[3];
			idy = dy[3];
			break;
		}
		
		if(x+idx < 0 || x+idx >= N || y + idy < 0 || y + idy >= M) return false;
		else {
			x += idx;
			y += idy;
			return true;
		}
	}
}