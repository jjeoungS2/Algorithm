import java.util.*;
import java.io.*;

// 가장 긴 감소하는 부분 수열 
public class Main {

	static int n;
	static int[] list;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = new int[n];
		dp = new int[n];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n ; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(list[i] < list[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1) ;
				}
			}
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}

}