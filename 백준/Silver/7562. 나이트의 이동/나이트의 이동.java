import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, I;
	static int start_x, start_y;
	static int end_x, end_y;
	static int[][] arr;
	// 왼쪽 위 부터 시계방향
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static Queue<IDX> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 0; tc < T; tc++) {
			I = Integer.parseInt(br.readLine());
			q.clear();
			arr = new int[I][I];
			st = new StringTokenizer(br.readLine()); // 시작점
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine()); // 끝점
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());

			if (start_x == end_x && start_y == end_y) { // 처음부터 시작점, 끝점 같으면 0출력 끝!
				System.out.println(0);
			} else { // 아니면 bfs시작
				arr[start_x][start_y] = 1;
				q.add(new IDX(start_x, start_y, 0));
				check();
				System.out.println(arr[end_x][end_y]);
			}
		}
	}

	static void check() {
		while (!q.isEmpty()) {
			IDX a = q.poll();
			int idx_x = a.x;
			int idx_y = a.y;
			int cnt = a.cnt;
			if (idx_x == end_x && idx_y == end_y) // 인덱스 번호가 끝점 이랑 같아지면 스탑
				break;
			for (int i = 0; i < dx.length; i++) {
				idx_x = a.x + dx[i];
				idx_y = a.y + dy[i];
				if (idx_x < 0 || idx_x >= I || idx_y < 0 || idx_y >= I) // 인덱스 범위 넘어가면 continue
					continue;
				if (arr[idx_x][idx_y] == 0) { // 방문한 적 없는 곳만 탐색
					arr[idx_x][idx_y] = 1;
					arr[idx_x][idx_y] = cnt + 1;
					q.add(new IDX(idx_x, idx_y, cnt + 1));
				}
			}
		}
	}
}

class IDX {
	int x;
	int y;
	int cnt;

	IDX(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
