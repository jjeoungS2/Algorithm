import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, K;

	public static void main(String[] args) throws Exception {
		Queue<Integer> qu = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		arr[N] = 0;
		qu.add(N);

		while (!qu.isEmpty()) {
			int x = qu.poll();

			if (x == K)
				break;

			if (x - 1 >= 0 && arr[x - 1] == 0) {
				arr[x - 1] = arr[x] + 1;
				qu.add(x - 1);
			}
			if (x + 1 <= 100000 && arr[x + 1] == 0) {
				arr[x + 1] = arr[x] + 1;
				qu.add(x + 1);
			}
			if (x * 2 <= 100000 && arr[x * 2] == 0) {
				arr[x * 2] = arr[x] + 1;
				qu.add(x * 2);
			}
		}

		System.out.println(arr[K]);
	}
}
