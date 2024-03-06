import java.util.*;
import java.io.*;

// 가장 긴 증가하는 부분 수열 
public class Main {

	static int N;
	static int[] list,dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 1;
		
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for(int j = 0; j < i; j++) {
				if(list[j] < list[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}