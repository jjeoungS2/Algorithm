import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	static ArrayList<Character> list = new ArrayList<>();

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
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				switch (i) {
				case 0:
					list.add('+');
					break;
				case 1:
					list.add('-');
					break;
				case 2:
					list.add('*');
					break;
				case 3:
					list.add('/');
					break;
				}
			}
		}
		visit = new boolean[N - 1];
		tgt = new char[N - 1];
		check(0, 0);
		System.out.println(MAX);
		System.out.println(MIN);
	}

	static boolean visit[];
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static char[] tgt;

	static void check(int tgtIdx, int srcIdx) {
		if (tgtIdx == N - 1) {
			int sum = num[0];
			for (int i = 1; i < N; i++) {
				switch(tgt[i-1]) {
				case'+':
					sum = sum + num[i]; break;
				case'-':
					sum = sum - num[i]; break;
				case'*':
					sum = sum * num[i]; break;
				case'/':
					sum = sum / num[i]; break;
				}
			}
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			tgt[tgtIdx] = list.get(i);
			check(tgtIdx + 1, srcIdx + 1);
			visit[i] = false;
		}
	}

}
