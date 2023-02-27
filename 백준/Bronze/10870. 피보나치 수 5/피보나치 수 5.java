import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		System.out.println(fibo(N));
	}

	static int fibo(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibo(n - 1) + fibo(n - 2);
	}

}
