import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] num = new int[10];
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				num[Integer.parseInt(st.nextToken())] = -1; // 고장난 숫자면 -1
			}
		}
		min = Math.abs(N - 100); // 시작점이 100이니까 초기값은 N-100
		boolean flag = true;
		for (int i = 0; i <= 999999; i++) { // 그냥 다 돌아볼까..? 안터질까..?
			String s = String.valueOf(i);
			flag = true;
			for (int j = 0; j < s.length(); j++) {
				for (int z = 0; z < num.length; z++) {
					if (num[s.charAt(j) - '0'] == -1) { // 고장난 숫자가 포함되었을 때 넘어가기
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				int cnt = Math.abs(N - i) + s.length();
				min = Math.min(cnt, min);
			}
		}
		System.out.println(min);
	}
}
