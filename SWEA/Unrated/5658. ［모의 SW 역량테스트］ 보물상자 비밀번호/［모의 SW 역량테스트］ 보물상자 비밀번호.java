import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	static int T, N, K;
	static char[] list;
	static TreeSet<Integer> ts = new TreeSet<>(Collections.reverseOrder());

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ts.clear();
			String s = br.readLine();
			list = new char[N];

			for (int i = 0; i < N; i++) {
				list[i] = s.charAt(i);
			}

			for (int i = 0; i < N / 4; i++) {
				s = "";
				int idx = i;
				int cnt = 0;

				while (cnt != N) {
					if (idx >= N) {
						idx = 0;
					}
					if (cnt != 0 && cnt % (N / 4) == 0) {
						ts.add(Integer.parseInt(s, 16));
						s = "";
					}
					s += list[idx];
					idx++;
					cnt++;
				}
				ts.add(Integer.parseInt(s, 16));
			}

			Object[] arr = ts.toArray();
			System.out.println("#"+tc+" "+arr[K - 1]);

		}
	}

}
