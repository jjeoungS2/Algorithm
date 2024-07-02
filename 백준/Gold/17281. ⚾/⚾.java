import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int[] lineup;
	static boolean[] visit;
	static int[] select;
	static int[][] list;
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		lineup = new int[9];
		visit = new boolean[8];
		select = new int[8];
		list = new int[N][9];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		perm(0);
		System.out.println(ans);
	}
	
	public static void perm(int num) {
		if(num == 8) {
			check();
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			if(!visit[i]) {
				visit[i] = true;
				select[num] = i;
				perm(num+1);
				visit[i] = false;
			}
		}
	}
	
	public static void check() {
		int j = 0; 
		for(int i = 0; i < 9; i++) {
			if(i == 3) {
				lineup[i] = 0; continue;
			}
			lineup[i] = select[j]+1;
			j++;
		}
		
		int hitter = 0;
		int out = 0;
		int score = 0;
		for(int i = 0; i < N; i++) {
			base = new int[3];
			out = 0;
			while(true) {
				if(out == 3) break;
				if(hitter == 9) hitter = 0;
				switch(list[i][lineup[hitter]]) {
				case 0 :
					out++;
					break;
				case 1 :
					score+=turn_base(1);
					break;
				case 2 :
					score+=turn_base(2);
					break;
				case 3 :
					score+=turn_base(3);
					break;
				case 4 :
					score++;
					for(int k = 0; k < 3; k++) {
						if(base[k] == 1) {
							score++;
							base[k] = 0;
						}
					}
					break;
				}
				hitter++;
			}
		}
		ans = Math.max(ans, score);

	}
	static int[] base = new int[3];
	public static int turn_base(int num) {
		int res = 0;
		for(int i = 0; i < num; i++) {
			if(base[2]==1)res++;
			base[2] = base[1];
			base[1] = base[0];
			base[0] = 0;
		}
		base[num-1] = 1;
		return res;
	}
}