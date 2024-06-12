import java.util.*;
import java.io.*;
// 배열 돌리기 
public class Main {
	static int T,n,d;
	static int[][] map;
	static int[][] copy_map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st; 

		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			copy_map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy_map[i][j] = map[i][j];
				}
			}
			
			int cnt = 0;
			if(d < 0) {
				cnt = d+360;
			} else {
				cnt = d;
			}
			cnt = cnt / 45;
			for(int i = 0; i < cnt; i++) {
				sol();
			}
			
			print();
		}
	}
	
	static public void sol() {
		for(int i = 0; i < n; i++) {
			copy_map[i][n/2] = map[i][i];
			copy_map[i][n-i-1] = map[i][n/2];
			copy_map[n/2][n-i-1] = map[i][n-i-1];
			copy_map[n-i-1][n-i-1] = map[n/2][n-i-1];
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ;j++) {
				map[i][j] = copy_map[i][j];
			}
		}
	}
	
	static public void print() {
		for(int[] i : map) {
			for(int j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}