import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로 찾기 
public class Main {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
	
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// map[1][2] == 1 이고 map[2][3] == 1 이면 결국
		// 1에서 3까지 갈 수 있다는 말이니까 map[1][3] = 1

		
		for (int i = 0; i < N; i++) {	// 중간 
			for (int j = 0; j < N; j++) {	// 시작 
				for (int z = 0; z < N; z++) {	// 끝 
					if(map[j][i] == 1 && map[i][z] == 1) {
						map[j][z] = 1;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<N;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
