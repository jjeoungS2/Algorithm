import java.util.*;
import java.io.*;

public class Main {
	static int N,M,R;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] visit;
	static int cnt = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visit = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1; i < list.size(); i++) {
			Collections.sort(list.get(i));
		}
		
		dfs(R);
		for(int i = 1; i <= N; i++) {
			System.out.println(visit[i]);
		}
		
	}
	
	private static void dfs(int a) {
		if(visit[a]!=0) {
			cnt--;
			return;
		}
		visit[a] = cnt;
		
		for(int i = 0; i < list.get(a).size(); i++) {
			cnt++;
			dfs(list.get(a).get(i));
		}
	}

}