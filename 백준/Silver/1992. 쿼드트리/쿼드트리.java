import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) { // 배열 입력
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		check(0, 0, N);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();

	static void check(int a, int b, int size) {
		int flag = 0;
		int num = arr[a][b];
		int check_x = a;
		int check_y = b;

		for (int i = a; i < a + size; i++) {
			for (int j = b; j < b + size; j++) {
				if (arr[i][j] != num) { // 체크 할 수랑 현재수랑 다르면 분할 시작할겨ㅕ
					check_x = i;
					check_y = j;
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				break;
		}
		if (flag == 0) { // 다 같은 숫자일때
			sb.append(num);
			return;
		}

		else if (flag == 1) {
			size = size / 2;
			sb.append("(");

			check(a, b, size); // 왼쪽 위
			check(a, b + size, size); // 오른쪽 위
			check(a + size, b, size); // 왼쪽 아래
			check(a + size, b + size, size); // 오른쪽 아래

			sb.append(")");
		}

	}

}
