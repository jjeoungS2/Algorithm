import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		String s;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(0, 0, N);
		for (int i : result) {
			System.out.println(i);
		}
	}

	static int[] result = { 0, 0, 0 };

	static void check(int a, int b, int n) {
		int size = n;
		int num = arr[a][b];
		int flag = 0;

		for (int i = a; i < a + size; i++) {
			for (int j = b; j < b + size; j++) {
				if (num != arr[i][j]) {
					flag = 1; // 다른수 나오면 분할 해야지
					break;
				}
			}
			if (flag == 1)
				break;
		}

		if (flag == 0) { // 다 같은 수일 때
			if (num == -1)
				result[0]++;
			else if (num == 0)
				result[1]++;
			else if (num == 1)
				result[2]++;
		}

		if (flag == 1) {
			size = size / 3;

			// 위
			check(a, b, size); // 왼쪽 위
			check(a, b + size, size); // 중간 위
			check(a, b + size*2, size); // 오른쪽 위

			//중간
			check(a + size, b, size); // 왼쪽
			check(a + size, b + size, size); // 중간
			check(a + size, b + size*2, size); // 오른쪽
			
			//아래
			check(a + size*2, b, size); // 왼쪽
			check(a + size*2, b + size, size); // 중간
			check(a + size*2, b + size*2, size); // 오른쪽
		}
	}

}
