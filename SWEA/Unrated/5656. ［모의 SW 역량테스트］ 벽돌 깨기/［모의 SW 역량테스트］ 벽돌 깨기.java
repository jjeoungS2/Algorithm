import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, W, H;
	static int[][] map;
	static int[][] copy;
	static int[] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			complete = false;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			copy = new int[H][W];
			tgt = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = map[i][j];
				}
			}

			perm(0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static int min = Integer.MAX_VALUE;

	// 중복순열,,
	static boolean complete = false;

	static void perm(int tgtIdx) {
		if(complete) return;
		if (tgtIdx == N) {
			IdxCheck();
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0)
						cnt++;
				}
			}
			min = Math.min(min, cnt);
			if (min == 0) {
				complete = true;
				return;
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = copy[i][j];
				}
			}
			return;
		}

		for (int i = 0; i < W; i++) {
			tgt[tgtIdx] = i;
			perm(tgtIdx + 1);
		}
	}

	static void IdxCheck() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][tgt[i]] != 0) {
					x = j;
					y = tgt[i];
					bfs(x, y); // bfs 시작
					break;
				}
			}
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { a, b, map[a][b] });

		while (!q.isEmpty()) {
			int[] idx = q.poll();
			int x = idx[0];
			int y = idx[1];
			int cnt = idx[2];
			if (cnt == 0)
				continue;
			map[x][y] = 0;

			// 상하좌우 블록 확인
			for (int i = 0; i < 4; i++) {
				x = idx[0] + dx[i];
				y = idx[1] + dy[i];
				if (x < 0 || x >= H || y < 0 || y >= W)
					continue;
				else {
					for (int z = 0; z < cnt - 1; z++) { // 블록에 적힌 수만큼 블록 q에 넣기,,
						if (x < 0 || x >= H || y < 0 || y >= W) {
							break;
						}
						if (map[x][y] == 0) {
							x += dx[i];
							y += dy[i];
							continue;
						}
						q.add(new int[] { x, y, map[x][y] });
						x += dx[i];
						y += dy[i];

					}
				}
			}
		}
		blockset();
	}

	static void blockset() { // 블록 내려주기
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][i] != 0)
					stack.add(map[j][i]);
			}

			for (int j = H - 1; j >= 0; j--) {
				if (stack.isEmpty())
					map[j][i] = 0;
				else
					map[j][i] = stack.pop();
			}
		}

	}

}
