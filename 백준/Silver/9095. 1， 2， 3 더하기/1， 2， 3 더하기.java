import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 4; i <= n; i++) {
				arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
			}
			sb.append(arr[n]).append("\n");
		}
		System.out.println(sb);
	}

}
