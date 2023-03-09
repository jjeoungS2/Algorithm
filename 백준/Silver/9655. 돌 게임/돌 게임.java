import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];

		if (N == 1 || N == 2 || N == 3) {
			if (N == 1 || N == 3) {
				System.out.println("SK");
			} else {
				System.out.println("CY");
			}
		} else {
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 1;

			for (int i = 4; i <= N; i++) {
				arr[i] = Math.min(arr[i - 1], arr[i - 3]) + 1;
			}

			if (arr[N] % 2 == 0) {
				System.out.println("CY");
			} else {
				System.out.println("SK");
			}
		}

	}
}
