import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static char[][] map = new char[12][6];
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {

				map[i][j] = s.charAt(j);

			}
		}

		int c = 1;
		while (c != 0) {
			c = 0;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					boolean flag = false;
					if (map[i][j] == '.')
						continue;
					else {
						flag = bfs_cnt(i, j, map[i][j]);
					}
					if (flag) {
						c = 1;
						puyo(i, j, map[i][j]);
					}
				}
			}
			if (c != 0) {
				block_down();
				res++;
			}
		}

		System.out.println(res);

		/*
		 * map 프린트해보는 코드 for (char[] string : map) { for (char string2 : string) {
		 * System.out.print(string2 + " "); } System.out.println(); }
		 */
	}

	// 뿌요 블록 터트리기
	private static void puyo(int a, int b, char c) {
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { a, b });
		map[a][b] = '.';
		while (!q.isEmpty()) {
			int[] idx = q.poll();
			int x = idx[0];
			int y = idx[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || map[nx][ny] != c) {
					continue;
				} else {
					map[nx][ny] = '.';
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	private static void block_down() {
		Deque<Character> q = new ArrayDeque<>();
		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 12; i++) {
				if (map[i][j] != '.') {
					q.add(map[i][j]);
					map[i][j] = '.';
				}

			}

			int i = 11;
			while (!q.isEmpty()) {
				map[i][j] = q.pollLast();
				i--;
			}
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 뿌요 블록 갯수 확인
	private static boolean bfs_cnt(int a, int b, char c) {
		boolean[][] visit = new boolean[12][6];
		visit[a][b] = true;
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { a, b });
		int cnt = 1;
		while (!q.isEmpty()) {

			if (cnt >= 4)
				return true;

			int[] idx = q.poll();
			int x = idx[0];
			int y = idx[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || map[nx][ny] != c || visit[nx][ny]) {
					continue;
				} else {
					cnt++;
					visit[nx][ny] = true;
					q.add(new int[] { nx, ny });
				}
			}
		}
		return false;
	}

}
