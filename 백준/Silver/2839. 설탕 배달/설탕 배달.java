import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N % 5 != 0 && N > 0) {
			N = N - 3;
			cnt++;
		}
		if (N < 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt + (N / 5));
		}

	}

}
