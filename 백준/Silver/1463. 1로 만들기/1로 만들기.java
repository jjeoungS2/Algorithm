import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1로 만들기
public class Main {
	static int[] list = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		list[2] = 1;
		list[3] = 1;

		for (int i = 4; i <= n; i++) {
			list[i] = list[i - 1] + 1;
			if (i % 2 == 0) {
				list[i] = Math.min(list[i / 2] + 1, list[i]);
			} 
			if (i % 3 == 0) {
				list[i] = Math.min(list[i / 3] + 1, list[i]);
			} 
				
		}

		System.out.println(list[n]);

	}

}
