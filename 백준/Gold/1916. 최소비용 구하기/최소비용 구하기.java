import java.util.*;
import java.io.*;

// 최소비용 구하기 
public class Main {

	static int N,M;
	static ArrayList<Node>[] list;
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
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[from].add(new Node(to,cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		go(start);
		System.out.println(dis[end]);
	}
	
	static int[] dis;
	public static void go(int start) {
		Queue<Node> q = new PriorityQueue<>();
		dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;

		boolean visit[] = new boolean[N + 1];
		q.offer(new Node(start,0));
		
		while(!q.isEmpty()) {
			Node no = q.poll();
			int start_node = no.to;
			
			if(!visit[start_node]) {
				visit[start_node] = true;
				
				for(Node node : list[start_node]){
					if(!visit[node.to] && dis[node.to] > dis[start_node] + node.cost) {
						dis[node.to] = dis[start_node] + node.cost;
						q.offer(new Node(node.to, dis[node.to]));
					}
				}
			}
		}
		
 	}
}


class Node implements Comparable<Node>{
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