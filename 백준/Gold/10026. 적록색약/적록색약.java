import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] list;
	static int[][] visit_1;
	static int[][] visit_2;
	static int normal = 0;
	static int red_green = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new char[N][N];
		visit_1 = new int[N][N];
		visit_2 = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				list[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit_1[i][j] == 0) {
					visit_1[i][j] = 1;
					Normal(i, j);
					normal++;
				}
				if (visit_2[i][j] == 0) {
					visit_2[i][j] = 1;
					Red_Green(i, j);
					red_green++;
				}

			}
		}
		System.out.print(normal);
		System.out.println(" " + red_green);

	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void Normal(int a, int b) {
		char c = list[a][b];
		for (int i = 0; i < 4; i++) {
			int x = a + dx[i];
			int y = b + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < N) {
				if (list[x][y] == c && visit_1[x][y] == 0) {
					visit_1[x][y] = 1;
					Normal(x, y);
				}
			}
		}
	}

	static void Red_Green(int a, int b) {
		char c = list[a][b];
		for (int i = 0; i < 4; i++) {
			int x = a + dx[i];
			int y = b + dy[i];
			if (x >= 0 && x < N && y >= 0 && y < N) {
				if (visit_2[x][y] == 0) {
					if (c == 'B') {
						if (list[x][y] == c) {
							visit_2[x][y] = 1;
							Red_Green(x, y);
						}
					} else {
						if (list[x][y] == 'R' || list[x][y] == 'G') {
							visit_2[x][y] = 1;
							Red_Green(x, y);
						}
					}
				}
			}
		}
	}

}
