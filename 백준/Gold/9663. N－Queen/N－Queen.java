import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		if (N == 1) {
			System.out.println(1);
		} else {
			for (int i = 0; i < N; i++) {
				arr[0] = i;
				NQueen(0);
			}
			System.out.println(result);
		}
	}

	// index 번호를 행으로 사용
	static void NQueen(int x) {
		if (x == N - 1) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[x + 1] = i; // 열
			if (check(x + 1)) {
				NQueen(x + 1);
			}
		}
	}

	private static boolean check(int x) {
		for (int i = 0; i < x; i++) {
			// 세로체크
			if (arr[i] == arr[x])
				return false;
			// 대각선
			if (Math.abs(i - x) == Math.abs(arr[i] - arr[x]))
				return false;
		}

		return true;
	}

}
