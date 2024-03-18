import java.util.*;
import java.io.*;
// 숨바꼭질 3
public class Main {
	
	static int N,K;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		check(N);
		System.out.println(list[K]);
	}
	
	static int[] list = new int[100001];
	static boolean[] visit = new boolean[100001];
	public static void check(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		int cnt = 0;
		q.offer(new int[] {start,0});
		Arrays.fill(list, Integer.MAX_VALUE);
		list[start] = 0;
		
		while(!q.isEmpty()) {
			int len = q.size();
			
			for(int i = 0; i < len; i++) {
				int[] idx = q.poll();
				int num = idx[0];
				int cost = idx[1];
				if(num == K) return;
				visit[num] = true;
				
				if(num*2 <= 100000 && !visit[num*2]) {
					if(list[num*2] < cost) continue;
					else {
						list[num*2] = cost;
						q.add(new int[] {num*2,cost});
					}
				}
				if(num+1 <= 100000 && !visit[num+1]) {
					if(list[num+1] < cost + 1) continue;
					else {
						list[num+1] = cost+1;
						q.add(new int[] {num+1,cost+1});
					}
				}
				if(num-1 >= 0 && !visit[num-1]) {
					if(list[num-1] < cost+1) continue;
					else {
						list[num-1] = cost+1;
						q.add(new int[] {num-1,cost+1});
					}
				}	
			}
		}
	}
}