import java.util.*;
import java.io.*;

// 특정한 최단 경로 
public class Main {
	static int N,E;
	static ArrayList<Node>[] list;
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		public Node(int to, int cost) {
			this.cost = cost;
			this.to = to;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	static int[] dist;
	static boolean[] visit;
	static final int INF = 200000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		visit = new boolean[N+1];
		
		Arrays.fill(dist, INF);
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 1 -> v1 -> v2 -> N
		
		int res = 0;
		res += dij(1,v1);
		res += dij(v1,v2);
		res += dij(v2,N);
		// 1 -> v2 -> v1 -> N
		int res2 = 0;
		res2 += dij(1,v2);
		res2 += dij(v2,v1);
		res2 += dij(v1,N);
		
		if(res >= INF && res2 >= INF) System.out.println(-1);
		else System.out.println(Math.min(res, res2));

		
	}
	
	public static int dij(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(visit, false);
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(start,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node idx = q.poll();
			int num = idx.to;
			
			if(!visit[num]) {
				visit[num] = true;
				
				for(Node id : list[num]) {
					if(!visit[id.to] && dist[id.to] > dist[num] + id.cost) {
						dist[id.to] = dist[num] + id.cost;
						q.add(new Node(id.to,dist[id.to]));
					}
				}
			}
		}	
		return dist[end];
	}

}