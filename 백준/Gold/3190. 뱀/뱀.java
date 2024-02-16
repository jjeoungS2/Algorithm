import java.util.*;
import java.io.*;

public class Main {
	
	static int N,K;	// 보그 크기 N, 사과 개수 K
	static int L;	// 뱀 이동 정보 
	static int[][] apple_m;
	// 현재 뱀 위치 저장 리스트
	static List<int[]> list = new ArrayList<>();
	// 처음 머리 오른쪽 
	static int now = 0;
	// 오른쪽, 아래, 왼쪽, 위 순서 
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		apple_m = new int[N][N];
		
		// 뱀 처음 위치 0,0
		list.add(new int[] {0,0});
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			
			apple_m[col-1][row-1] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		
		int time = 0;
		int stop = 0;
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		char c = st.nextToken().charAt(0);
		L--;
		while(true) {
				if(stop == 1) break;
				if(time == x) {
					// list 출력해보기
//					print();
					// 머리가 오른쪽일때 
					if(c == 'D') {
						now += 1;
						if(now == 4) {
							now = 0;
						}
					} 
					// 머리가 왼쪽일때 
					else if(c == 'L') {
						now -= 1;
						if(now == -1) {
							now = 3;
						}
					}
					if(L != 0) {
						st = new StringTokenizer(br.readLine());
						x = Integer.parseInt(st.nextToken());
						c = st.nextToken().charAt(0);
						L--;
					}
				}
				int[] temp = list.get(0);
				for(int j = 0; j < list.size(); j++) {
					if(j == 0) {
						stop = body_check();
						
						// 벽에 박았는지 확인 
						if(temp[0] + dx[now] < 0 || temp[0] + dx[now] >= N || temp[1] + dy[now] < 0 || temp[1] + dy[now] >= N) {
							stop = 1;
							break;
						} else if(stop == 1) {
							break;
						} else {
							list.set(j, new int[] {temp[0]+dx[now], temp[1] + dy[now]});
						}

						// 사과 먹어는지 확인 
						if(apple_m[temp[0]+dx[now]][temp[1]+dy[now]] == 1) {
							apple_m[temp[0]+dx[now]][temp[1]+dy[now]] = 0;
							list.set(j, new int[] {temp[0],temp[1]});
							list.add(0,new int[] {temp[0]+dx[now],temp[1]+dy[now]});
							break;
						}
					} else {
						int[] temp2 = list.get(j);
						list.set(j, new int[] {temp[0],temp[1]});
						temp = temp2;
					}
				}
				// 몸에 박았는지 확인 
//				if(stop == 0) {
//					stop = body_check();
//				}
				time++;
			}
		
		System.out.println(time);
	}
	
	static int body_check() {
		int[] temp = list.get(0);
		for(int i = 1 ; i < list.size(); i++) {
			int[] check = list.get(i);
			if(temp[0] + dx[now] == check[0] && temp[1] + dy[now] == check[1]) {
				return 1;
			}
		}
		return 0;
	}
	static void print() {
		for(int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			System.out.println(temp[0]+" "+temp[1]);
		}
	}
}