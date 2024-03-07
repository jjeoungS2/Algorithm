import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 두 용액 
public class Main {
	
	static long[] list;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		long gap = Integer.MAX_VALUE;
		long[] res = new long[2];
		int i = 0;
		int j = N-1;
		
		while(true) {
			if(i == j) break;
			
			long mid = list[i] + list[j];
			if(Math.abs(mid) < Math.abs(gap)) {
				res[0] = list[i];
				res[1] = list[j];
				gap = mid;
			}
			
			if(mid > 0) j--;
			else i++;
		
		}
		System.out.println(res[0]+" "+res[1]);
	}

}