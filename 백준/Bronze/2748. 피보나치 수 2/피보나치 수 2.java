import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static long[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new long[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = -1;
		}
		list[0] = 0;
		list[1] = 1;
		System.out.println(fibo(N));
	}

	static long fibo(int N) {
		if (list[N] == -1) {
			list[N] = fibo(N - 1) + fibo(N - 2);
		}
		return list[N];
	}
}