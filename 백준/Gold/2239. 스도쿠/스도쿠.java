import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> zero = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			String[] arr = s.split("");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
				if (map[i][j] == 0)
					zero.add(new int[] { i, j });
			}
		}
		dfs(0);
	}

	static boolean end = false;
	static StringBuilder sb = new StringBuilder();
	static void dfs(int idx) {
		if(end) return;
		if (idx == zero.size()) {
			end = true;
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}

		int x = zero.get(idx)[0];
		int y = zero.get(idx)[1];

		boolean[] visit = new boolean[10];

		for (int i = 0; i < 9; i++) { // 가로
			if (map[x][i] != 0)
				visit[map[x][i]] = true;
		}
		for (int i = 0; i < 9; i++) { // 세로
			if (map[i][y] != 0)
				visit[map[i][y]] = true;
		}

		int nx = (x / 3) * 3;
		int ny = (y / 3) * 3;

		for (int i = nx; i < nx + 3; i++) {
			for (int j = ny; j < ny + 3; j++) {
				if(map[i][j]!=0) visit[map[i][j]] = true;
			}
		}
		
		for (int i = 1; i <= 9; i++) {
			if (visit[i]) continue;
			map[x][y] = i;
			dfs(idx + 1);
			map[x][y] = 0; 
			
		}

	}

}
