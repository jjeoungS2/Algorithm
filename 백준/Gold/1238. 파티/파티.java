import java.util.*;
import java.io.*;

// 파티 
public class Main {
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
	static int N,M,X;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,cost));
		}
		
		int res = 0;
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += dij(i,X);
			sum += dij(X,i);
			res = Math.max(res, sum);
			sum = 0;
		}
		
		System.out.println(res);
		
	}
	
	static boolean[] visit;
	static int[] dist;
	public static int dij(int start,int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		visit = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		q.add(new Node(start,0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node idx = q.poll();
			visit[idx.to] = true;
			
			for(Node n : list[idx.to]) {
				if(!visit[n.to] && dist[n.to] > dist[idx.to] + n.cost) {
					dist[n.to] = dist[idx.to] + n.cost;
					q.add(new Node(n.to, dist[n.to]));
				}
			}
		}
		return dist[end];
	}


}