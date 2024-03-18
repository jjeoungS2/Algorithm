import java.io.*;
import java.util.*;

// 최단경로 
public class Main {
	static int V,E,K;
	static ArrayList<Node>[] list;
	static int[] dist;
	static class Node implements Comparable<Node>{
			int to;
			int cost;
			
			public Node(int to, int cost) {
				this.to = to;
				this.cost = cost;
			}
			
			@Override
			public int compareTo(Node o) {
				return this.cost - o.cost;
			}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		list = new ArrayList[V+1];
		
		for(int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to,cost));
		}
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);

	}
	
	static boolean[] visit;
	public static void dijkstra(int start) {
		Queue<Node> q = new PriorityQueue<>();
		visit = new boolean[V+1];
		dist[start] = 0;
		q.add(new Node(start,0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(!visit[node.to]) {
				visit[node.to] = true;
				
				for(Node no : list[node.to]) {
					if(!visit[no.to] && dist[no.to] > dist[node.to] + no.cost) {
						dist[no.to] = dist[node.to] + no.cost;
						q.add(new Node(no.to, dist[no.to]));
					}
				}
			}
		}
	}
}