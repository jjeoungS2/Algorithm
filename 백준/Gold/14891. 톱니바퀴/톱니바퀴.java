import java.util.*;
import java.io.*;

// 톱니바퀴 
public class Main {
	
	static int K;
	static int[][] arr;
	static boolean[] check;
	static boolean[] check2;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		arr = new int[4][8];
		check = new boolean[4];
		check2 = new boolean[4];
		
		for(int i = 0; i < 4; i++) {
			s = br.readLine();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < K; t++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int where = Integer.parseInt(st.nextToken());
			Arrays.fill(check, false);
			check = new boolean[4];
					
			// 1 시계 / -1 반시계 
			switch(num) {
			case 1:
				turn_1(where);
				break;
			case 2:
				turn_2(where);
				break;
			case 3:
				turn_3(where);
				break;
			case 4:
				turn_4(where);
				break;
			}	
		}
		int res = 0;
		if(arr[0][0] == 1) res += 1;
		if(arr[1][0] == 1) res += 2;
		if(arr[2][0] == 1) res += 4;
		if(arr[3][0] == 1) res += 8;
		System.out.println(res);		
	}
	
	public static void move(int num, int where) {
		int temp = 0;
		if(where == 1) {
			temp = arr[num-1][7];
			for(int i = 7; i > 0; i--) {
				arr[num-1][i] = arr[num-1][i-1];
			}
			arr[num-1][0] = temp;
		}
		else if(where == -1) {
			temp = arr[num-1][0];
			for(int i = 0; i < 7; i++) {
				arr[num-1][i] = arr[num-1][i+1];
			}
			arr[num-1][7] = temp;
		}
	}
	public static void turn_1(int where) {
		if(!check[0]) {
			check[0] = true;
			// 시계 
			if(where == 1) {
				if(arr[0][2] != arr[1][6]) {
					turn_2(-1);
				}
				move(1,1);
			} 
			// 반시계 
			else if(where == -1) {
				if(arr[0][2] != arr[1][6]) {
					turn_2(1);	
				}
				move(1,-1);
			}
		}
	}
	public static void turn_2(int where) {
		if(!check[1]) {
			check[1] = true;
			// 시계 
			if(where == 1) {
				if(arr[1][6] != arr[0][2]) {
					turn_1(-1);
				}
				if(arr[1][2] != arr[2][6]) {
					turn_3(-1);
				}
				move(2,1);
			} 
			// 반시계 
			else if(where == -1) {
				if(arr[1][6] != arr[0][2]) {
					turn_1(1);
				}
				if(arr[1][2] != arr[2][6]) {
					turn_3(1);
				}
				move(2,-1);
			}
		}
	}
	public static void turn_3(int where) {
		if(!check[2]) {
			check[2] = true;
			// 시계 
			if(where == 1) {
				if(arr[2][6] != arr[1][2]) {
					turn_2(-1);
				}
				if(arr[2][2] != arr[3][6]) {
					turn_4(-1);
				}
				move(3,1);
			} 
			// 반시계 
			else if(where == -1) {
				if(arr[2][6] != arr[1][2]) {
					turn_2(1);
				}
				if(arr[2][2] != arr[3][6]) {
					turn_4(1);
				}
				move(3,-1);
			}
		}
	}
	public static void turn_4(int where) {
		if(!check[3]) {
			check[3] = true;
			// 시계 
			if(where == 1) {
				if(arr[3][6] != arr[2][2]) {
					turn_3(-1);
				}
				move(4,1);
			} 
			// 반시계 
			else if(where == -1) {
				if(arr[3][6] != arr[2][2]) {
					turn_3(1);
				}
				move(4,-1);
			}
		}
	}
}