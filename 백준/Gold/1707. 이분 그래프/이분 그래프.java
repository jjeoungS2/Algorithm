import java.io.*;
import java.util.*;
public class Main {
	
	static int K;
	static int V,E;
	static ArrayList<Integer>[] list;
	static int[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V+1];
			visit = new int[V+1];

			for(int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				list[u].add(v);
				list[v].add(u);
			}
			boolean check = true;
			for(int i = 1; i <= V; i++) {
				if(visit[i] == 0) {
					check = bfs(i);
				}
				if(!check) {
					System.out.println("NO");
					break;
				}
			}
			if(check) 
				System.out.println("YES");
		}
	}
	public static boolean bfs(int x) {
		Queue<int[]> q = new ArrayDeque<>();
		visit[x] = 1;
		q.add(new int[] {x,1});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			for(int i = 0; i < list[temp[0]].size(); i++) {
				int num = list[temp[0]].get(i);
				if(visit[num] == 0) {
					if(temp[1] == 1) {
						visit[num] = -1;
						q.add(new int[] {num, -1});
					}
					else {
						visit[num] = 1;
						q.add(new int[] {num, 1});
					}
					
				}
				else if(visit[num]!=0) {
					if(temp[1] == 1) {
						if(visit[num] == 1) {
							return false;
						}
					} 
					else if(temp[1] == -1) {
						if(visit[num] == -1) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}

//1
//4 4
//1 2
//2 3
//3 4
//4 2