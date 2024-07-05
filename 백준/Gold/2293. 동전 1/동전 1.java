import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	static int[] list;
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new int[n];
		dp = new int[k+1];
		
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		int num = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				if(j - list[i] > 0) {
					dp[j] = dp[j] + dp[j-list[i]];
				} else if(j-list[i] == 0) {
					dp[j]++;
				}
			}
		}
		
		System.out.println(dp[k]);
	}

}