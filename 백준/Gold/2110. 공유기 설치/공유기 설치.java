import java.io.*;
import java.util.*;

// 공유기 설치 
public class Main {
	
	static int N,C;
	static int[] home;
	static int res = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		home = new int[N];
		
		for(int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(home);
		int max = home[N-1] - home[0];
		int min = 1;
		
		int cnt = 0;
		while(min <= max) {
			
			int mid = (max + min) / 2;
			int start = home[0];
			cnt = 1;
			for(int i = 0; i < N; i++) {
				if(home[i] - start > mid) {
					cnt++;
					start = home[i];
				}
			}
			if(cnt >= C) {
				res = mid;
				min = mid + 1;
			}
			else {
				max = mid-1;
			}
		}
		
		System.out.println(res+1);
		
	}

}