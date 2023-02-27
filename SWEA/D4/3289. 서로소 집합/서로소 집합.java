import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, n, m;
	static int[] parents;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			parents = new int[n + 1];
			makeSet();
			
			sb.append("#");
			sb.append(t).append(" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				if(op == 0) {
					union(x,y);
				}
				else if(op == 1) {
					if( findSet(x) == findSet(y) ) sb.append(1);
					else sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}

	static void makeSet() {
		for (int i = 1; i < n; i++) {
			parents[i] = i;
		}
	}

	// 집합을 표현하는 최상위 부모
	static int findSet(int x) {
		if (parents[x] == x) return x;
		//else return findSet(parents[x]); 시간초과
		else return parents[x] = findSet(parents[x]);	// Path Compressino
	}

	// x를 y집합으로 또는 y를 x 집합으로 이동하는게 아니다.
	// x가 속한 집합 전체와 y가 속한 집합 전체를 하나로!!
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		parents[py] = px; // 앞 파라미터의 집합으로 뒤 파라미터의 집합이 포함
	}

}
