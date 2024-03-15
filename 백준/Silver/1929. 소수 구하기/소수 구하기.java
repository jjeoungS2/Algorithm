import java.util.*;
import java.io.*;
// 소수 구하기 
public class Main {
	
	static int M,N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for(int i = N; i <= M; i++) {
			if(i == 0 || i == 1) continue;
			else if(i == 2) {
				sb.append(2).append("\n");
			}
			else {
				boolean flag = true;
				for(int j = 2; j <= Math.sqrt(i); j++) {
					if(i % j == 0) {
						flag = false;
					}
				}
				if(flag) sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}