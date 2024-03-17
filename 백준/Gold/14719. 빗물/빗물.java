import java.util.*;
import java.io.*;
// 빗물 
public class Main {

	static int H,W;
	static int[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		list = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		

		int res = 0;
		
		for(int t = 1; t < W - 1; t++) {
			int h = list[t];
			int Lh = 0;
			int Rh = 0;
			
			for(int i = 0; i <= t; i++) {
				Lh = Math.max(list[i], Lh);
			}
			
			for(int j = t; j < W; j++) {
				Rh = Math.max(list[j], Rh);
			}

			res += Math.min(Lh, Rh) - h;
			
		}
		System.out.println(res);
	}

}