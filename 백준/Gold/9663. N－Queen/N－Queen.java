import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[0][1] = i;
			cnt = 1;
			NQueen(0, i);
		}
		if (N == 1) {
			System.out.println(1);
		} else {
			System.out.println(result);
		}
	}

	static int cnt = 1;
	static int result = 0;

	static void NQueen(int x, int y) {
		if (x == N - 1)
			return;
		for (int i = 0; i < N; i++) {
			arr[x + 1][0] = x + 1;
			arr[x + 1][1] = i;
			if (check(x + 1, i)) {
				cnt++;
				NQueen(x + 1, i);
				if (cnt == N) {
					cnt--;
					result += 1;
					return;
				}
				cnt--;
			}

		}
	}

	private static boolean check(int x, int y) {
		for (int i = 0; i < x; i++) {
			// 세로체크
			if (arr[i][1] == arr[x][1])
				return false;
			// 가로체크
			if (Math.abs(arr[i][0] - arr[x][0]) == Math.abs(arr[i][1] - arr[x][1]))
				return false;
		}

		return true;
	}

}
