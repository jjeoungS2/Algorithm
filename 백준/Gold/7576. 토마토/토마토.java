import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}
		
		bfs();
		
		int flag = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > max)
					max = map[i][j];
				if (map[i][j] == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				break;
		}
		
		if(flag == 1) {
			System.out.println(-1);
		}
		else {
			System.out.println(max - 1);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<int[]> q = new ArrayDeque<>();
	static void bfs() {
		while (!q.isEmpty()) {
			int[] idx = q.poll();
			int nx = idx[0];
			int ny = idx[1];

			for (int i = 0; i < 4; i++) {
				nx = idx[0] + dx[i];
				ny = idx[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				if (map[nx][ny] == 0 || map[nx][ny] > map[nx - dx[i]][ny - dy[i]] + 1) {
					map[nx][ny] = map[nx - dx[i]][ny - dy[i]] + 1;
					q.add(new int[] { nx, ny });
					continue;
				}
			}
		}

	}
}