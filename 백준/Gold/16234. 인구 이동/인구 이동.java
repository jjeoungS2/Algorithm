import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static int map[][];
	static int visit[][];
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visit = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			boolean flag = true;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] != 0)
						continue;
					else {
						flag = BFS(i, j, cnt);
						if (flag) {		// flag가 true일 때만 cnt++
							cnt++;
						}
					}
				}
			}
			if(cnt !=1) {
				check(cnt);
				res++;
			}
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], 0);
			}
			
			if(cnt == 1) break;
		}
		System.out.println(res);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean BFS(int a, int b, int cnt) {
		boolean flag = false;
		Deque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { a, b, cnt });

		while (!q.isEmpty()) {
			int[] idx = q.poll();
			int x = idx[0];
			int y = idx[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] != 0)
					continue;
				if (Math.abs(map[x][y] - map[nx][ny]) < L || Math.abs(map[x][y] - map[nx][ny]) > R)
					continue;
				else {
					flag = true;
					visit[x][y] = cnt;
					visit[nx][ny] = cnt;
					q.add(new int[] { nx, ny, cnt });

				}
			}
		}
		return flag;
	}

	static void check(int cnt) { // map 인구이동 시키기!
		for (int t = 1; t <= cnt; t++) {
			Deque<int[]> q = new ArrayDeque<>();
			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == t) {
						q.add(new int[] { i, j });
						sum += map[i][j];
					}
				}
			}
			if (q.isEmpty()) {
				return;
			} else {
				int c = q.size();
				sum = sum / c;
				while (!q.isEmpty()) {
					int[] idx = q.poll();
					int x = idx[0];
					int y = idx[1];
					map[x][y] = sum;
				}
			}
		}
	}

}
