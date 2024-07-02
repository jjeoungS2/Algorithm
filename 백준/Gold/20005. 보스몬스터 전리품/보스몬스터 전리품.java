import java.util.*;
import java.io.*;

public class Main {
	static int N,M,P;
	static char[][] map;
	static int bossHP;
	static int[][] play;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		play = new int[P][2];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			char c = a.charAt(0);
			int hp = Integer.parseInt(st.nextToken());
			play[c-'a'][1] = hp;
		}
		bossHP = Integer.parseInt(br.readLine());

		for(int i = 0; i < N ;i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]!='B'&&map[i][j]!='.'&&map[i][j]!='X') {
					char x = map[i][j];
					visit = new boolean[N][M];
					int time = bfs(i,j);
					play[x-'a'][0] = time;
				}
			}
		}
		
		while(true) {
			if(bossHP <= 0) break;
			for(int i = 0; i < P; i++) {
				play[i][0]-=1;	
				if(play[i][0]<0) {
					bossHP-=play[i][1];	
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < P; i++) {
			if(play[i][0]<0)ans++;
		}
		System.out.println(ans);
	}	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visit;
	public static int bfs(int a,int b) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {a,b,0});
		visit[a][b] = true;
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			int time = idx[2];
			for(int i = 0; i < 4; i++) {
				int x = idx[0]+dx[i];
				int y = idx[1]+dy[i];
				if(x < 0 || x >= N || y < 0 || y >= M || visit[x][y] || map[x][y] =='X') continue;
				if(map[x][y] == 'B') return time+1;
				q.add(new int[] {x,y,time+1});	
				visit[x][y] = true;
			}
		}
		return 0;
	}
}