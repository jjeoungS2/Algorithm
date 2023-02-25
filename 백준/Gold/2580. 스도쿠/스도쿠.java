import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[9][9];
	static List<Point> idx = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0)
					idx.add(new Point(i, j));
			}
		}

		Sudoku(0);
		System.out.println(sb);
	}

	static StringBuilder sb = new StringBuilder();
	static boolean complete = false;

	static void Sudoku(int a) {
		if(complete) return;
		if (a == idx.size()) {
			complete = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		int x = idx.get(a).x;
		int y = idx.get(a).y;

		boolean[] visit = new boolean[10];

		// 가로
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] != 0)
				visit[arr[x][i]] = true;
		}

		// 세로
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] != 0)
				visit[arr[i][y]] = true;
		}

		// 네모
		int dx = (x / 3) * 3;
		int dy = (y / 3) * 3;
		for (int i = dx; i < dx + 3; i++) {
			for (int j = dy; j < dy + 3; j++) {
				if (arr[i][j] != 0)
					visit[arr[i][j]] = true;
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (visit[i])
				continue; // 방문했다? 다음으로
			arr[x][y] = i; // 방문 안했으면 방문하고 다음 스도쿠 숫자 맞추러 가기
			Sudoku(a + 1); // 다음 스도쿠에서 맞는 숫자가 안나오면
			arr[x][y] = 0; // return해서 방문안한 다음숫자 방문
		}
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
