import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,K;
	static int[][] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		K = Integer.parseInt(br.readLine());

		int i,j,x,y = 0;
		
		for(int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			for(int ii = i-1 ; ii < x; ii++) {
				for(int jj = j-1 ; jj < y; jj++) {
					sum += list[ii][jj];
				}
			}
			System.out.println(sum);	
		}
	}

}