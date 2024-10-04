import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] list;
	static int N,M;
	static boolean[] visit;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(list[i]);
		}
		visit = new boolean[N+1];
		bfs(1);
		System.out.println(res-1);
	}
	static int res = 0;
	public static void bfs(int start) {
		Queue<Integer>q = new ArrayDeque<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int n = q.poll();
			if(!visit[n]) {
				visit[n] = true;
				res++;
			}

			for(int i = 0; i < list[n].size(); i++) {
				if(!visit[list[n].get(i)]) {
					q.add(list[n].get(i));
				}
			}
		}
	}
}