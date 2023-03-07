import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		HashSet<Integer> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			if (s.equals("all")) {
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
				continue;
			} else if (s.equals("empty")) {
				set.clear();
				continue;
			}
			int x = Integer.parseInt(st.nextToken());
			switch (s) {
			case "add":
				set.add(x);
				break;
			case "remove":
				set.remove(x);
				break;
			case "check":
				if (set.contains(x)) {
					sb.append(1).append("\n");
				} else
					sb.append(0).append("\n");
				break;
			case "toggle":
				if (set.contains(x)) {
					set.remove(x);
				} else
					set.add(x);
				break;
			}
		}
		System.out.println(sb);
	}

}
