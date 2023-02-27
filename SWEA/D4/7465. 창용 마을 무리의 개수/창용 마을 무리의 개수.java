import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list = new int[N + 1];
			int[] result = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				list[i] = i;
			}

			int n, m;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				union(n, m);
			}

			for (int i = 1; i < N + 1; i++) {
				result[findSet(i)] = 1;
			}
			int cnt = 0;
			for (int i = 1; i < N + 1; i++) {
				if (result[i] != 0)
					cnt++;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		list[py] = px;
	}

	static int findSet(int x) {
		if (list[x] == x)
			return x;
		else
			return list[x] = findSet(list[x]);
	}
}
