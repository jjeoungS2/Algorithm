import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, d, s;

	static int[][] map;
	static int[][] visit;

	static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		visit = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 비구름
		list.add(new int[] { N - 1, 1 });
		list.add(new int[] { N - 1, 2 });
		list.add(new int[] { N, 1 });
		list.add(new int[] { N, 2 });

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			move();
			rain();
			cloud();
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				res += map[i][j];
			}			
		}

		System.out.println(res);
	}

	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	static void move() {
		for (int i = 0; i < list.size(); i++) {
			int[] idx = list.get(i);
			int x = idx[0];
			int y = idx[1];

			for (int j = 0; j < s; j++) {
				x = x + dx[d];
				y = y + dy[d];
				if (x > N) x = 1;
				if (x == 0) x = N;
				if (y > N) y = 1;
				if (y == 0) y = N;
			}

			int[] xy = { x, y };
			list.set(i, xy);
		}
	}

	// ↖, ↗, ↙, ↘
	static int[] cx = { -1, -1, 1, 1 };
	static int[] cy = { -1, 1, -1, 1 };

	static void rain() {

		for (int i = 0; i < list.size(); i++) {
			// 처음에 1칸씩 비 내리기
			int[] idx = list.get(i);
			int x = idx[0];
			int y = idx[1];
			map[x][y] += 1;
		}
		for (int i = 0; i < list.size(); i++) {
			// 대각선들 확인
			int[] idx = list.get(i);
			int x = idx[0];
			int y = idx[1];
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				int nx = x + cx[j];
				int ny = y + cy[j];
				if (nx <= 0 || nx > N || ny <= 0 || ny > N)
					continue;
				if (map[nx][ny] != 0) {
					cnt++;
				}
			}
			map[x][y] += cnt;
			visit[x][y] = 1;
		}

	}

	static void cloud() {
		list.clear();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (visit[i][j] == 1) {
					visit[i][j] = 0;
					continue;
				}
				if (map[i][j] >= 2) {
					map[i][j] -= 2;
					list.add(new int[] { i, j });
				}
			}
		}
	}

}
