import java.util.*;
import java.io.*;

// 로또 
public class Main {
	static int k;
	static int[] arr;
	static int[] select;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			
			arr = new int[k];
			select = new int[6];
			visit = new boolean[6];
			
			int len = st.countTokens();
			
			for(int i = 0; i < len; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			perm(0,0);
			System.out.println();
		}
		
		
	}
	
	public static void perm(int num,int idx) {
		if(num == 6) {
			print();
			return;
		}
		
		for(int i = idx; i < k; i++) {
			select[num] = arr[i];
			perm(num+1,i+1);		
		}
	}
	
	public static void print() {
		for(int i = 0; i < 6; i++) {
			System.out.print(select[i]+" ");
		}
		System.out.println();
	}
}