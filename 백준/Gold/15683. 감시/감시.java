import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	//				   상 우 하 좌 
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static ArrayList<Point> list = new ArrayList<>();
	static int[][] cctv;
	public static class Point{
		int x;
		int y;
		int Num;
		int d;
		Point(int x, int y, int Num, int d){
			this.x = x;
			this.y = y;
			this.Num = Num;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new int[N][M];
		
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j]!=6) {
					list.add(new Point(i, j, map[i][j], -1));
				}
			}
		}
		
		check(0);
		System.out.println(Min);
		
	}
	
	public static void check(int x) {
		
		if(x >= list.size()) {
			// 사각지대 체크 
			cctv = new int[N][M];
			Blind_Spot();
			return;
		}
		Point a = list.get(x);
		if(a.Num == 1) {
			for(int i = 0; i < 4; i++) {
				list.set(x, new Point(a.x, a.y, a.Num, i));
				check(x+1);
			}
		}
		else if(a.Num == 2) {
			for(int i = 0; i < 2; i++) {
				list.set(x, new Point(a.x, a.y, a.Num, i));
				check(x+1);
			}
		}
		else if(a.Num == 3) {
			for(int i = 0; i <4; i++) {
				list.set(x, new Point(a.x, a.y, a.Num, i));
				check(x+1);
			}

		}
		else if(a.Num == 4) {
			for(int i = 0; i < 4; i++) {
				list.set(x, new Point(a.x, a.y, a.Num, i));
				check(x+1);
			}
			
		}
		else if(a.Num == 5) {
			list.set(x, new Point(a.x, a.y, a.Num, 0));
			check(x+1);
		}
	}
	
	public static void Blind_Spot() {
		for(int i = 0; i < list.size(); i++) {
			Point a = list.get(i);
			cctv[a.x][a.y] = 1;
			if(a.Num == 1) turn_on1(a.x, a.y, a.d);
			else if(a.Num == 2) turn_on2(a.x, a.y, a.d);
			else if(a.Num == 3) turn_on3(a.x, a.y, a.d);
			else if(a.Num == 4) turn_on4(a.x, a.y, a.d);
			else if(a.Num == 5) turn_on5(a.x, a.y);
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(cctv[i][j]==0 && map[i][j] != 6) cnt++;
				if(cnt > Min) break;
			}
		}
		if(cnt < Min) {
			Min = cnt;

		}
	}
	static int Min = Integer.MAX_VALUE;
	public static void turn_on1(int x, int y, int d) {
		while(true) {
			if(x + dx[d] < 0 || x + dx[d] >= N || y + dy[d] < 0 || y + dy[d] >= M || map[x + dx[d]][y + dy[d]] == 6) break;
			cctv[x + dx[d]][y + dy[d]] = 1;
			x = x+dx[d];
			y = y+dy[d];
		}
	}
	public static void turn_on2(int a, int b, int d) {
		int x = a;
		int y = b;
		if( d == 0 ) { // 위 아래 
			while(true) {
				if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]] == 6) break;
				cctv[x + dx[0]][y + dy[0]] = 1;
				x = x+dx[0];
				y = y+dy[0];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
				cctv[x + dx[2]][y + dy[2]] = 1;
				x = x+dx[2];
				y = y+dy[2];
			}
		}
		else if( d == 1 ) {	// 좌 우 
			while(true) {
				if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
				cctv[x + dx[1]][y + dy[1]] = 1;
				x = x+dx[1];
				y = y+dy[1];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
				cctv[x + dx[3]][y + dy[3]] = 1;
				x = x+dx[3];
				y = y+dy[3];
			}
		}
	}
	public static void turn_on3(int a, int b, int d) {
		// 위 오른쪽
		int x = a;
		int y = b;
		if (d == 0) {
			while(true) {
				if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]] == 6) break;
				cctv[x + dx[0]][y + dy[0]] = 1;
				x = x+dx[0];
				y = y+dy[0];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
				cctv[x + dx[1]][y + dy[1]] = 1;
				x = x+dx[1];
				y = y+dy[1];
			}
		}
		// 위 왼쪽 
		else if( d == 1) {
			while(true) {
				if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]] == 6) break;
				cctv[x + dx[0]][y + dy[0]] = 1;
				x = x+dx[0];
				y = y+dy[0];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
				cctv[x + dx[3]][y + dy[3]] = 1;
				x = x+dx[3];
				y = y+dy[3];
			}
		}
		// 아래 오른쪽 
		else if( d == 2 ) {
			while(true) {
				if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
				cctv[x + dx[2]][y + dy[2]] = 1;
				x = x+dx[2];
				y = y+dy[2];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
				cctv[x + dx[1]][y + dy[1]] = 1;
				x = x+dx[1];
				y = y+dy[1];
			}
		}
		// 아래 왼쪽 
		else if( d == 3 ) {
			while(true) {
				if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
				cctv[x + dx[2]][y + dy[2]] = 1;
				x = x+dx[2];
				y = y+dy[2];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
				cctv[x + dx[3]][y + dy[3]] = 1;
				x = x+dx[3];
				y = y+dy[3];
			}
		}
		
	}
	public static void turn_on4(int a, int b, int d) {
		// 좌우 위
		int x = a;
		int y = b;
		if( d == 0) {
			while(true) {
				if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
				cctv[x + dx[1]][y + dy[1]] = 1;
				x = x+dx[1];
				y = y+dy[1];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
				cctv[x + dx[3]][y + dy[3]] = 1;
				x = x+dx[3];
				y = y+dy[3];
			}			
			x = a;
			y = b;
			while(true) {
				if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]] == 6) break;
				cctv[x + dx[0]][y + dy[0]] = 1;
				x = x+dx[0];
				y = y+dy[0];
			}
		}	
		// 좌우 아래 
		else if( d == 1 ) {
			while(true) {
				if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
				cctv[x + dx[1]][y + dy[1]] = 1;
				x = x+dx[1];
				y = y+dy[1];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
				cctv[x + dx[3]][y + dy[3]] = 1;
				x = x+dx[3];
				y = y+dy[3];
			}	
			x = a;
			y = b;
			while(true) {
				if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
				cctv[x + dx[2]][y + dy[2]] = 1;
				x = x+dx[2];
				y = y+dy[2];
			}
		}
		// 아래위 왼
		else if( d == 2 ) {	
			while(true) {
				if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]] == 6) break;
				cctv[x + dx[0]][y + dy[0]] = 1;
				x = x+dx[0];
				y = y+dy[0];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
				cctv[x + dx[2]][y + dy[2]] = 1;
				x = x+dx[2];
				y = y+dy[2];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
				cctv[x + dx[3]][y + dy[3]] = 1;
				x = x+dx[3];
				y = y+dy[3];
			}
		}
		// 아래위 오 
		else if ( d == 3 ) {
			while(true) {
				if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]]  == 6) break;
				cctv[x + dx[0]][y + dy[0]] = 1;
				x = x+dx[0];
				y = y+dy[0];
			}
			x = a;
			y = b;
			while(true) {
				if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
				cctv[x + dx[2]][y + dy[2]] = 1;
				x = x+dx[2];
				y = y+dy[2];
			}		
			x = a;
			y = b;
			while(true) {
				if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
				cctv[x + dx[1]][y + dy[1]] = 1;
				x = x+dx[1];
				y = y+dy[1];
			}
		}
	}
	public static void turn_on5(int a, int b) {
		int x = a;
		int y = b;
		while(true) {
			if(x + dx[0] < 0 || x + dx[0] >= N || y + dy[0] < 0 || y + dy[0] >= M || map[x + dx[0]][y + dy[0]] == 6) break;
			cctv[x + dx[0]][y + dy[0]] = 1;
			x = x+dx[0];
			y = y+dy[0];
		}
		x = a;
		y = b;
		while(true) {
			if(x + dx[2] < 0 || x + dx[2] >= N || y + dy[2] < 0 || y + dy[2] >= M || map[x + dx[2]][y + dy[2]] == 6) break;
			cctv[x + dx[2]][y + dy[2]] = 1;
			x = x+dx[2];
			y = y+dy[2];
		}	
		x = a;
		y = b;
		while(true) {
			if(x + dx[1] < 0 || x + dx[1] >= N || y + dy[1] < 0 || y + dy[1] >= M || map[x + dx[1]][y + dy[1]] == 6) break;
			cctv[x + dx[1]][y + dy[1]] = 1;
			x = x+dx[1];
			y = y+dy[1];
		}
		x = a;
		y = b;
		while(true) {
			if(x + dx[3] < 0 || x + dx[3] >= N || y + dy[3] < 0 || y + dy[3] >= M || map[x + dx[3]][y + dy[3]] == 6) break;
			cctv[x + dx[3]][y + dy[3]] = 1;
			x = x+dx[3];
			y = y+dy[3];
		}	
	}
}