import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		List<String> list = new ArrayList<>();
		String s;
		while (st.hasMoreTokens()) {
			s = st.nextToken();
			list.add(s);
		}
		int num = Integer.MAX_VALUE;
		int n = 0;
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = 0;

			st = new StringTokenizer(list.get(i), "+");
			while (st.hasMoreTokens()) {
				n = Integer.parseInt(st.nextToken());
				sum += n;
			}
			if (num == Integer.MAX_VALUE)
				num = sum;
			else {
				num -= sum;
			}
		}
		System.out.println(num);
	}
}
