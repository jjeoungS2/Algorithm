import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int A,B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		go(A,B,0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res+1);
		}
	}
	static long res = Integer.MAX_VALUE;
	private static void go(long a, long b, long cnt) {
		if(a == b) {
			if(cnt < res) res = cnt;
			return;
		}
		else if(a > b) return;
			// 1 추가하기
			go(a*10+1,b, cnt+1);
			// 2곱하기
			go(a*2,b,cnt+1);
	}

}