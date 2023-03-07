import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int[] sum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		sum[0] = list.get(0);
		int result = sum[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + list.get(i);
			result += sum[i];
		}

		System.out.println(result);
	}
}
