import java.util.*;
import java.io.*;

// 나무 자르기 
public class Main {

	static int N,M;
	static int[] tree;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new int[N];
		int max = 0;
		int min = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		while(min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			for(int a : tree) {
				if(a - mid > 0) {
					sum += ( a - mid );
				}
			}
			
			if(sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min-1);
		
	}

}