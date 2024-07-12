import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static boolean[] visit;
	static ArrayList<Node>[] list;
	static long dist[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		list = new ArrayList[N];
		dist = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			if(Integer.parseInt(st.nextToken()) == 1) visit[i] = true;
			dist[i] = Long.MAX_VALUE;
		}
			
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int a,b,t;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b,t));
			list[b].add(new Node(a,t));
		}
		
		dist[0] = 0;
		dijkstra();	
		if(dist[N-1] == Long.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(dist[N-1]);
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node (0,0));
		
		while(!pq.isEmpty()) {
			Node temp = pq.poll();
			if(!visit[temp.n]) {
				visit[temp.n] = true;
				for(int i = 0; i < list[temp.n].size(); i++) {
					Node a = list[temp.n].get(i);
					if(a.n == N-1 || !visit[a.n]) {
						if(dist[a.n] > dist[temp.n] + a.v) {
							dist[a.n] = dist[temp.n] + a.v;
							pq.add(new Node(a.n, dist[a.n]));
						}
					}
				}
			}
		}
	}
	public static class Node implements Comparable<Node> {
	    int n;
	    long v;

	    Node(int n, long v) {
	        this.n = n;
	        this.v = v;
	    }

	    @Override
	    public int compareTo(Node o) {
	        return Long.compare(this.v, o.v);
	    }
	}

}