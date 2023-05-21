import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[][] map;
	static int h_cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			res = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						h_cnt++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean[][] v = new boolean[N][N];
					v[i][j] = true;
					bfs(i, j, v);
				}
			}
			System.out.printf("#%d %d\n", t, res);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int res = Integer.MIN_VALUE;

	private static void bfs(int x, int y, boolean[][] v) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });
		int home = 0;
		int L = 1;
		if (map[x][y] == 1)
			home = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			int cost = L * L + (L - 1) * (L - 1);
			
			// 이익 확인
			if(home*M - cost >= 0) {
				res = Math.max(res, home);
			}
			
			if(home == h_cnt) return;

			for (int i = 0; i < size; i++) {
				int[] id = q.poll();
				for (int j = 0; j < 4; j++) {
					int idx = id[0] + dx[j];
					int idy = id[1] + dy[j];
					if (idx < 0 || idx >= N || idy < 0 || idy >= N || v[idx][idy])
						continue;
					if (map[idx][idy] == 1)
						home++;
					v[idx][idy] = true;
					q.add(new int[] { idx, idy });
				}
			}
			L++;
		}
	}

}
