import java.util.*;
import java.io.*;
public class Main {
	private static class Index{
		int num;
		int x;
		int y;
		Index(int num, int x, int y){
			this.num = num;
			this.x = x;
			this.y = y;
			
		}
	}
	static int N,K,S,X,Y;
	static int[][] list;
	static ArrayList<Index> virus = new ArrayList<>();
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if(list[i][j]!=0) virus.add(new Index(list[i][j],i,j));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		Collections.sort(virus, new Comparator<Index>() {
		    @Override
		    public int compare(Index i1, Index i2) {
		        return Integer.compare(i1.num, i2.num);
		    }
		});
		
		Deque<Index> q = new ArrayDeque<>();
		for(int i = 0; i < virus.size(); i++) {
			q.add(virus.get(i));
		}
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			if(cnt == S) break;
			cnt++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				Index idx = q.pollFirst();
				int num = idx.num;
				int x = idx.x;
				int y = idx.y;

				for(int j = 0; j < 4; j++) {
					if(x+dx[j] < 0 || x + dx[j] >= N || y+dy[j] < 0 || y + dy[j] >= N || list[x+dx[j]][y+dy[j]]!=0) continue;
					list[x+dx[j]][y+dy[j]] = num;
					q.add(new Index(num,x+dx[j],y+dy[j]));
				}
			}
		}
		System.out.println(list[X-1][Y-1]);
	}

}