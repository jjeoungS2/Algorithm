import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static int[][] map;
	static int[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			visited = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
					visited[i][j] = -1;
				}
			}

			visited[0][0] = 0;
			bfs(0, 0);
			System.out.println("#" + t + " " + visited[N - 1][N - 1]);
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] n = q.poll();
			int nx = n[0];
			int ny = n[1];
			int cnt = visited[nx][ny];

			for (int i = 0; i < 4; i++) {
				nx = n[0] + dx[i];
				ny = n[1] + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (visited[nx][ny] != -1) {
					if (visited[nx][ny] > cnt + map[nx][ny]) {
						visited[nx][ny] = cnt + map[nx][ny];
						q.add(new int[] { nx, ny });
					}
//					else if(visited[nx][ny] < cnt + map[nx][ny]) {
//						q.add(new int[] { nx, ny });
//					}
					continue;
				}
				visited[nx][ny] = cnt + map[nx][ny];
				q.add(new int[] { nx, ny });

			}
		}
	}

}
