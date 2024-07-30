import java.util.*;
import java.io.*;

public class Main {
	static int N,Q;
	static int p,q,r,k,v;
	static boolean[] visit;
	static int[] visit_m;
	static ArrayList<Point>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		visit = new boolean[N+1];
		visit_m = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			visit_m[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			list[p].add(new Point(q,r));
			list[q].add(new Point(p,r));
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Q; i++) {
			visit = new boolean[N+1];
            Arrays.fill(visit_m, Integer.MAX_VALUE);

			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			visit[v] = true;
			for(int t = 0; t < list[v].size(); t++) {
	            check(list[v].get(t).end, list[v].get(t).r); // 부모의 USADO 값을 넘겨줌
			}
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
                if (visit_m[j] < Integer.MAX_VALUE && visit_m[j] >= k) cnt++;
            }
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void check(int b, int minUsado) {
		  visit[b] = true;
	        visit_m[b] = minUsado; // 현재 노드의 USADO 값 설정

	        for (Point p : list[b]) {
	            if (!visit[p.end]) {
	                check(p.end, Math.min(p.r, minUsado)); // 자식 노드로 가면서 최소 USADO 값 업데이트
	            }
	        }
	}
	
	static class Point {
		int end;
		int r;
		
		Point(int end, int r){
			this.end = end;
			this.r = r;
		}
	}
}