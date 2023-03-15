import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] cnt = new int[41];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		cnt[0] = 0;
		cnt[1] = 1;

		for (int i = 2; i < 41; i++) {
			cnt[i] = cnt[i-1]+cnt[i-2];	// 1개수
			
		}
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				sb.append(1).append(" ").append(0).append("\n");
				continue;
			}
			sb.append(cnt[n-1]).append(" ").append(cnt[n]).append("\n");
		}
		System.out.println(sb);
	}
}
