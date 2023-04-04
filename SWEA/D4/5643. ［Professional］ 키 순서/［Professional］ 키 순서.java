import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[][] Map;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			Map = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Map[a][b] = 1;
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					if (k == i)
						continue;
					for (int j = 1; j <= N; j++) {
						if (i == j || k == j)
							continue;
						if (Map[i][k] == 1 && Map[k][j] == 1) {
							Map[i][j] = 1;
						}
					}
				}
			}

			int res = 0;

			for (int i = 1; i <= N; i++) {
				int flag = 0;
				for (int j = 1; j <= N; j++) {
					if (i != j && Map[i][j] == 0 && Map[j][i] == 0) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					res++;
				}
			}

			System.out.println("#" + tc + " " + res);

		}
	}

}
