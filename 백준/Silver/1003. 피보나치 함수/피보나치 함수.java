import java.io.BufferedReader;
import java.io.InputStreamReader;

// 피보나치 함수
public class Main {
	static int[][] cnt = new int[2][41];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		cnt[0][0] = 1;
		cnt[1][0] = 0;
		cnt[0][1] = 0;
		cnt[1][1] = 1;

		for (int i = 2; i < 41; i++) {
			cnt[0][i] = cnt[0][i-1]+cnt[0][i-2];	// 0개수
			cnt[1][i] = cnt[1][i-1]+cnt[1][i-2];	// 1개수
			
		}
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(cnt[0][n]).append(" ").append(cnt[1][n]).append("\n");
		}
		System.out.println(sb);
	}

}
