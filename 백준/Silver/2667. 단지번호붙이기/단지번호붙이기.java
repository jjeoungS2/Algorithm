import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static int[][] list;
	static ArrayList<Integer> AP = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N][N];
		int home_cnt = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				list[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (list[i][j] == 1) {
					list[i][j] = 0;
					check(i, j);
					home_cnt++;
					AP.add(cnt);
					cnt = 1;
				}
			}
		}
		Collections.sort(AP);	// 오름차순으로 정리
		for (int i : AP) {
			sb.append(i).append("\n");
		}
		System.out.println(home_cnt);
		System.out.println(sb);

	}

	// 왼쪽, 위쪽, 오른쪽, 아래
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int cnt = 1;

	static void check(int a, int b) {

		int idx_x;
		int idx_y;
		for (int i = 0; i < 4; i++) {
			idx_x = a + dx[i];
			idx_y = b + dy[i];
			while (idx_x < N && idx_x >= 0 && idx_y < N && idx_y >= 0) {
				if (list[idx_x][idx_y] == 1) {
					list[idx_x][idx_y] = 0;
					cnt++;
					check(idx_x, idx_y);
				}
				else break;
			}
		}
		return;
	}
	
}
