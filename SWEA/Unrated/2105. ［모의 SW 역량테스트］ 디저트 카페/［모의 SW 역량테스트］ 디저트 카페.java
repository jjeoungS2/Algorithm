import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			ans = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 맵 전체 다 돌면서 최대값 구해야겠지?
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean[][] v = new boolean[N][N];
					boolean[] num = new boolean[101];
					v[i][j] = true;
					num[map[i][j]] = true;
					startX = i;
					startY = j;
					check(i, j, v, num, 1, 0);
				}
			}
			System.out.println("#" + (t+1) + " " + ans);
		}
	}

	static int startX, startY;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int ans = -1;

	private static void check(int x, int y, boolean[][] v, boolean[] num, int cnt, int d) {

		for (int i = d; i < 4; i++) {
			int idx = x + dx[i];
			int idy = y + dy[i];

			if (idx == startX && idy == startY && cnt > 2) {
				ans = Math.max(ans, cnt);
				return;
			}

			if (idx < 0 || idx >= N || idy < 0 || idy >= N || num[map[idx][idy]])
				continue;

			else {
				v[idx][idy] = true;
				num[map[idx][idy]] = true;
				check(idx, idy, v, num, cnt + 1, i);
				v[idx][idy] = false;
				num[map[idx][idy]] = false;
			}
		}

	}

}
