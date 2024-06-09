import java.util.*;
import java.io.*;
// 대칭 차집합
public class Main {
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int res = 0;
		for(int i : A) {
			if(!B.contains(i)) res++;
		}
		for(int i : B) {
			if(!A.contains(i)) res++;
		}
		
		System.out.println(res);
	
	}
}