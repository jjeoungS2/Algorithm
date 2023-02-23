import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[][] list;
	static int[][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new int[N][N];
			visit = new int[N][N];
			result = 0;
			Num = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					list[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					check(i, j);
					if(cnt > result) {
						result = cnt; Num = list[i][j];
					} else if(cnt == result) {
						Num = Math.min(Num, list[i][j]);
					}
				}
			}
			System.out.println("#"+tc+" "+Num+" "+result);
		}
	}
	static int cnt = 1;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int result = 0;
	static int Num = Integer.MAX_VALUE;

	static void check(int a, int b) {
		int x = a;
		int y = b;
		visit[a][b] = 1;
		for (int i = 0; i < 4; i++) {
			x = a + dx[i];
			y = b + dy[i];

			if (x < 0 || x >= N || y < 0 || y >= N)
				continue;
			if (visit[x][y] != 1) { // 방문한적 없을 때
				if (list[x][y] - list[a][b] == 1) { // 전 방보다 1크면
					cnt++;
					visit[x][y] = 1;
					check(x, y);
					visit[x][y] = 0;
				}
			}
		}
		visit[a][b] = 0;
	}

}
