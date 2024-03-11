import java.io.*;
import java.util.*;

public class Main {
	
	static int T,N,M;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[N+1];
			visit = new boolean[N+1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

			}
			
			System.out.println(N-1);
		}
		
	}

}