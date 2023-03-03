import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 미세먼지 확산되는 양 Ar,c / 5
	// r,c에 남은 미세먼지의 양 Ar,c - (Ar,c/5)×(확산된 방향의 개수)

	static int R, C, T;
	static int[][] map;
	static List<int[]> air = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					air.add(new int[] { i, j });
				}
			}
		}

		for (int i = 0; i < T; i++) {
			diffusion(air.get(0)[0], air.get(0)[1], air.get(1)[0], air.get(1)[1]);
		}
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					cnt+=map[i][j];
				}
			}
		}
		System.out.println(cnt);
	}

	static int[][] dust;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void diffusion(int x, int y, int x2, int y2) {
		dust = new int[R][C];
		dust[x][y] = -1;
		dust[x2][y2] = -1;
		int cnt = 0;
		int D = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cnt = 0;
				D = 0;
				if (map[i][j] != 0 && map[i][j] != -1) {
					cnt = map[i][j];
					D = cnt / 5;
					for (int idx = 0; idx < 4; idx++) {
						int nx = i + dx[idx];
						int ny = j + dy[idx];
						if (nx < 0 || nx >= R || ny < 0 || ny >= C || dust[nx][ny] == -1)
							continue;
						dust[nx][ny] += D;
						cnt -= D;
					}
					dust[i][j] += cnt;
				}
			}
		}

		// 배열 copy
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = dust[i][j];
			}
		}

		ArrTurn();

	}

	static void ArrTurn() {
		// 배열 회전,,

		// 위 ( 반시계방향 )
		int x = air.get(0)[0];
		int y = air.get(0)[1];

		for (int i = x; i > 0; i--) {
			if (map[i][y] == -1)
				continue;
			map[i][y] = map[i - 1][y];
		}
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < air.get(0)[0]; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i >= 1; i--) {
			if (map[x][i - 1] == -1)
				map[x][i] = 0;
			else
				map[x][i] = map[x][i - 1];
		}

		// 아래 ( 시계방향 )
		int x2 = air.get(1)[0];
		int y2 = air.get(1)[1];

		for (int i = x2; i < R - 1; i++) {
			if (map[i][0] == -1)
				continue;
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > x2; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int i = C - 1; i > 0; i--) {
			if (map[x2][i - 1] == -1)
				map[x2][i] = 0;
			map[x2][i] = map[x2][i - 1];
		}
	}

}
