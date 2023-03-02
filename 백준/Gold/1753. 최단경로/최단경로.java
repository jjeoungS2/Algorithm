import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K, u, v, w;
	static List<List<Edge>> adjlist = new ArrayList<>();
	static boolean[] visit; // 정점 선택 여부
	static int[] cost; // K로부터 각 정점(index)까지의 누적 < = 다익스트라 알고리즘에서 핵심, 계속 최소값으로 갱신된다.

	static PriorityQueue<Edge> pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
	static final int INF = Integer.MAX_VALUE;

	static class Edge {
		int v; // 간선이 연결시켜주는 정점
		int c; // 시작점으로부터의 누적 비용 합

		Edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		K = Integer.parseInt(br.readLine()); // 시작 정점 번호

		visit = new boolean[V + 1];
		cost = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			adjlist.add(new ArrayList<Edge>());
			cost[i] = INF;
		}

		// 간선
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// v1에서 갈 수 있는 Edge
			adjlist.get(v1).add(new Edge(v2, w));
		}

		dijkstra();

//		for (int i = 1; i <= V; i++) {
//			System.out.println(cost[i] == INF ? "INF" : cost[i]);
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=V;i++) {
			if(cost[i]==INF) sb.append("INF").append("\n");
			else sb.append(cost[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra() {
		// 시작정점
		cost[K] = 0;
		pqueue.offer(new Edge(K,0));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			if(visit[e.v]) continue;	// 이미 고려되고 선택되었으면 skip
			
			visit[e.v] = true;
			
			// 꺼낸 e.v가 연결하려는 정점 e.v에 대해서 비용을 줄일 수 있는지 검토 ( e.v를 통해서 )
			for (Edge ne : adjlist.get(e.v)) {	
				if(cost[e.v] + ne.c < cost[ne.v]) {
					cost[ne.v] = cost[e.v] + ne.c;
					
					pqueue.offer(new Edge(ne.v, cost[ne.v]));	// 새로운 객체 생성
					
//					ne.c = cost[ne.v];
//					pqueue.offer(ne);	// 기존 객체 활용
				}
			}
		}
	}
	
	

}
