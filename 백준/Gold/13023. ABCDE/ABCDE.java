import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 자료구조가 Array of ArrayList
public class Main {
	static int N, M;
	static Friend[] friends;
	static boolean done;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// Friend 자료구조 생성
		friends = new Friend[N];
		for (int i = 0; i < N; i++) {
			friends[i] = new Friend(i);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].list.add(b);
			friends[b].list.add(a);
		}

		// 모든사람 각각에 대해서 연속적으로 연결된 친구관계가 5명인 경우를 찾는다.
		for (int i = 0; i < N; i++) {
			dfs(i, 0, 1 << i); // 빝마스킹,,,
			if (done) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	static void dfs(int num, int cnt, int visit) {
		// 연속적인 관계가 생기면 done = true 하고 return
		if (done)
			return;
		// 기저조건
		// 연속적으로 5명의 친구가 성립
		if (cnt == 4) {
			done = true;
			return;
		}

		friends[num].list.forEach( (i) -> {
			if ((visit & (1 << i)) == 0)
				dfs(i, cnt + 1, visit | 1 << i);
		});
	}

	static class Friend {
		int num;
		List<Integer> list = new ArrayList<>();

		Friend(int num) {
			this.num = num;
		}
	}
}
