import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	// static ArrayList<Character> list = new ArrayList<>();
	static int[] list = new int[4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// + - x /
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			list[i] = Integer.parseInt(st.nextToken());;
		}

		check(num[0], 1); // 첫번째 숫자는 num으로 보내니까 idx는 1부터 시작
		System.out.println(MAX);
		System.out.println(MIN);
	}

	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;

	static void check(int result, int idx) {
		if(idx == N) {
			MAX = Math.max(MAX, result);
			MIN = Math.min(MIN, result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (list[i] > 0) {
				list[i]--;
				if (i == 0)
					check(result + num[idx], idx + 1);
				else if (i == 1) {
					check(result - num[idx], idx + 1);
				} else if (i == 2) {
					check(result * num[idx], idx + 1);
				} else if (i == 3) {
					check(result / num[idx], idx + 1);
				}
				list[i]++;
			}
		}
	}

}
