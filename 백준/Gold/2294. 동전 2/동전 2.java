import java.util.*;
import java.io.*;

// 동전 2
public class Main {
	
	static int n,k;
	static int[] list;
	static int[] coin;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		list = new int[k+1];
		coin = new int[n];
		
		Arrays.fill(list, 100001);
		list[0] = 0;
		
		
		for(int t = 0; t < n; t++) {
			coin[t] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = coin[i]; j <= k ; j++) {
				list[j] = Math.min(list[j], list[j-coin[i]] + 1);
			}
		}
		
		if(list[k] >= 100001) System.out.println(-1);
		else System.out.println(list[k]);
	}

}