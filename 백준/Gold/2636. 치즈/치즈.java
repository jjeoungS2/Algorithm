import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] copy_map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copy_map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheeze++;
			}
		}
		res = cheeze;

		// 치즈 밖 공간 체크
		bfs(0, 0);

		for (int i = 0; i < N; i++) {
			copy_map[i] = Arrays.copyOf(map[i], map[i].length);
		}
		while (true) {
			if (cheeze == 0)
				break;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						for (int a = 0; a < 4; a++) {
							if (map[i + dx[a]][j + dy[a]] == cnt+2) {
								copy_map[i][j] = cnt+2;
								cheeze--;
								break;
							}
						}
					}
				}
			}

			cnt++;
			if (cheeze != 0) {
				res = cheeze;
			}

			// 맵 복사
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.copyOf(copy_map[i], copy_map[i].length);
			}

			bfs(0, 0);

		}

		System.out.println(cnt + "\n" + res);

	}

	static int cnt = 0;
	static int res = 0;
	static int cheeze = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(int x0, int y0) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x0, y0 });

		while (!q.isEmpty()) {
			int[] idx = q.pollFirst();
			int x = idx[0];
			int y = idx[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || map[nx][ny] == cnt + 2) {
					continue;
				} else {
					map[nx][ny] = cnt + 2;
					q.add(new int[] { nx, ny });
				}
			}
		}

	}

}
