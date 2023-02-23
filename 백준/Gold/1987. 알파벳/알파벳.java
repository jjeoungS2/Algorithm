import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] List;
	static boolean[] visit = new boolean[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		String s;
		List = new char[R][C];
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			List[i] = s.toCharArray();
		}

		visit[List[0][0] - 65] = true;
		check(0, 0, 1);
		System.out.println(result);
	}

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int result = 1;

	static void check(int a, int b, int sum) {

		for (int i = 0; i < 4; i++) {
			int x = a + dx[i];
			int y = b + dy[i];
			if (x < 0 || x >= R || y < 0 || y >= C)
				continue;
			if (!visit[List[x][y] - 65]) { // 방문한 적 없을 때
				visit[List[x][y] - 65] = true;
				sum++;
				check(x, y, sum);
				result = Math.max(result, sum);
				visit[List[x][y] - 65] = false;
				sum--;
			}
		}
	}

}
