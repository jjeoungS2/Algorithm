import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> list = new HashSet<>();
		TreeSet<String> set = new TreeSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (list.contains(s)) {
				set.add(s);
				cnt++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (String s : set) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}

}
