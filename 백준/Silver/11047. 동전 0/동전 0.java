import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N];

		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}

		int coin = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (K >= list[i]) {
				coin += K / list[i];
				K = K % list[i];
			}
			if (K == 0)
				break;
		}
		System.out.println(coin);

	}

}
