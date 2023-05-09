import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Map<Integer, ArrayList<Integer>> students = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int len = N * N;

		visit = new int[N][N];

		for (int i = 0; i < len; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ArrayList<Integer> frends = new ArrayList<>();

			frends.add(a);
			frends.add(b);
			frends.add(c);
			frends.add(d);
			students.put(s, frends);

			int bf = -1; // 친한친구 수
			int blk = -1; // 빈칸 수
			int inx_x = 0;
			int inx_y = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					// 이미 방문했으면 넘어감

					int check_bf = 0;
					int check_blk = 0;
					if (visit[j][k] != 0)
						continue;

					for (int z = 0; z < 4; z++) {
						int x = dx[z] + j;
						int y = dy[z] + k;

						if (x < 0 || x >= N || y < 0 || y >= N)
							continue;

						// 주위가 친한친구인지 확인
						if (visit[x][y] != 0
								&& (visit[x][y] == a || visit[x][y] == b || visit[x][y] == c || visit[x][y] == d)) {
							check_bf++;
						}
						// 아니면 빈칸인지 확인
						else if (visit[x][y] == 0) {
							check_blk++;
						}
					}

					// 친한 친구가 많다?
					if (check_bf > bf) {
						inx_x = j;
						inx_y = k;
						bf = check_bf;
						blk = check_blk;
					}

					// 친한친구는 같은데 빈칸이 많다?
					else if (check_bf == bf && check_blk > blk) {
						inx_x = j;
						inx_y = k;
						bf = check_bf;
						blk = check_blk;
					}
				}
			}
			visit[inx_x][inx_y] = s;
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int t = 0; t < 4; t++) {
					int x = i + dx[t];
					int y = j + dy[t];
					if (x < 0 || x >= N || y < 0 || y >= N)
						continue;
					if (students.get(visit[i][j]).contains(visit[x][y])) {
						cnt++;
					}
				}

				if (cnt == 1) {
					res += 1;
				} else if (cnt == 2) {
					res += 10;
				} else if (cnt == 3) {
					res += 100;
				} else if (cnt == 4) {
					res += 1000;
				}
			}
		}

		System.out.println(res);
	}

}
