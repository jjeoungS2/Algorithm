import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}

	static int blue = 0;
	static int white = 0;

	static void check(int a, int b, int n) {
		int size = n;
		int num = arr[a][b];
		int flag = 0;

		for (int i = a; i < a + size; i++) {
			for (int j = b; j < b + size; j++) {
				if (num != arr[i][j]) {
					flag = 1; // 분할해야겠다!
					break;
				}
			}
			if (flag == 1)
				break;
		}

		if (flag == 0) { // 전부 같은 수당
			if (num == 1)
				blue++; // 파란색++
			if (num == 0)
				white++; // 횐색++
		}

		if (flag == 1) {
			size = n / 2;

			check(a, b, size); // 왼쪽 위
			check(a, b + size, size); // 오른쪽 위
			check(a + size, b, size); // 왼쪽 아래
			check(a + size, b + size, size); // 오른쪽 아래
		}
	}

}
