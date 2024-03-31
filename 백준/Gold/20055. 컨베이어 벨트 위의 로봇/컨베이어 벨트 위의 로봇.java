import java.util.*;
import java.io.*;
// 컨베이어 벨트 위의 로봇 
public class Main {

	static int N,K;
	static boolean[] r;
	static int[] belt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = new boolean[N];
		belt = new int[N*2];
		for(int i = 0; i < 2*N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(sol());
		
	}

	public static int sol() {
		int cnt = 0;
		
		while(check()) {
			
			// 벨트 이동 
			int temp = belt[N*2-1];
			for(int i = N*2-1; i > 0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = temp;
			
			for(int i = N-1; i > 0; i--) {
				r[i] = r[i-1];
			}
			r[0] = false;
			r[N-1] = false;
			
			// 가장 먼저 올라간 로봇부터 옆으로 영-차- 
			// 이동하려는 칸에 로봇이 없어야 함. 내구도 1 이상이여야 함 
			for(int i = N-1; i > 0; i--){
				if(r[i-1] && !r[i] && belt[i] >= 1) {
					belt[i]--;
					r[i] = true;
					r[i-1] = false;
				}
			}
			
			// 올리는 위치 0 아니면 올리기 
			if(belt[0]!= 0) {
				belt[0]--;
				r[0] = true;
			}
			cnt++;
		}
		
		return cnt;
	}

	public static boolean check() {
		int cnt = 0;
		for(int i = 0; i < N*2; i++) {
			if(belt[i] == 0) {
				cnt++;
			}
			if(cnt >= K) return false;
		}
		return true;
		
	}
}