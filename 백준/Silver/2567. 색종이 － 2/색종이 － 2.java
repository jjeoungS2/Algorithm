import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] list;
	static int[][] arr = new int[101][101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 스카프 좌표 1로 채우기
		for (int i = 0; i < N; i++) {
			int x = list[i][0];
			int y = list[i][1];
			for (int j = y; j < y + 10; j++) {
				for (int z = x; z < x + 10; z++) {
					arr[j][z] = 1;
				}
			}
		}

		
		int cnt = 0;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (arr[i][j] == 1) {		// 스카프일때
					for (int z = 0; z < 4; z++) {
						if (i + dx[z] < 0 || j + dy[z] < 0 || i + dx[z] > 101 || j + dy[z] > 101)
							continue;

						if (arr[i + dx[z]][j + dy[z]] == 0)	// 상하좌우 중 0 이 있으면 0이 있을때 마다 cnt++ 해주기
							cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

		//
	}

}
