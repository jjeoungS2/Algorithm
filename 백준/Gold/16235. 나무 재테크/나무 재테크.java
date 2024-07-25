import java.util.*;
import java.io.*;
public class Main {
	static class Tree{
		int x;
		int y;
		int z;
		boolean Dead;
		
		Tree(int x, int y, int z, boolean Dead){
			this.x = x;
			this.y = y;
			this.z = z;
			this.Dead = Dead;
		}
	}
	static int N,M,K;
	static int[][] map;
	static int[][] food;
	static ArrayList<Tree> tree = new ArrayList<>();
	static Queue<Integer> deadtree = new ArrayDeque<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		food = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		
		int x,y,z;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			tree.add(new Tree(x, y, z, false));
		}
		
		Collections.sort(tree,(o1,o2)->{
			return o1.z - o2.z;
		});
		
		for(int k = 0; k < K; k++) {
			// 봄
			for(int i = 0; i < tree.size(); i++) {
				
				Tree t = tree.get(i);
				
				if(map[t.x][t.y] >= t.z) {
					map[t.x][t.y] -= t.z;
					t.z += 1;
				} else deadtree.add(i);
				
			}		
			// 여름 
			while(!deadtree.isEmpty()) {
				int i = deadtree.poll();
				Tree t = tree.get(i);
				
				map[t.x][t.y] += t.z/2;
				t.Dead = true;
			}
			// 가을 
			ArrayList<Tree> New = new ArrayList<>();
			for(int i = 0; i < tree.size(); i++) {
				Tree t = tree.get(i);
				if(!t.Dead) {
					if(t.z % 5 == 0) {
						for(int j = 0; j < 8; j++) {
							int nx = t.x + dx[j];
							int ny = t.y + dy[j];
							if(nx > 0 && nx <= N && ny > 0 && ny <= N) {
								New.add(new Tree(nx, ny, 1, false));
							}
						}
					}
				}
			}
			for(int i = 0; i < tree.size(); i++) {
				Tree t = tree.get(i);
				if(!t.Dead) {
					New.add(t);
				}
			}
			tree = New;
			
			// 겨울 
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] += food[i][j];
				}
			}
		}
		System.out.println(tree.size());
	}
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
}