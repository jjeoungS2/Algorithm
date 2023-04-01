import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0) {
					visit[i][j] = true;
				}
			}
		}

		bfs();
		System.out.println(map[N - 1][M - 1]);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		visit[0][0] = true;
		q.add(new int[] { 0, 0, 1 });

		while (!q.isEmpty()) {
			int[] idx = q.pollFirst();
			int x = idx[0];
			int y = idx[1];
			int cnt = idx[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 0 || visit[nx][ny] == true) {
					continue;
				} else {
					visit[nx][ny] = true;
					map[nx][ny] = cnt + 1;
					q.add(new int[] { nx, ny, cnt + 1 });
				}
			}
		}
	}

}
