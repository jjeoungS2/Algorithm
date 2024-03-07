import java.io.*;
import java.util.*;
// 좋다 
public class Main {
	static int N;
	static int[] list;
	static int good = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		for(int i = 0; i < N; i++) {
			int num = list[i];
			
			int max = N-1;
			int min = 0;
			while(true) {
				if(i == min) min++;
				if(i == max) max--;
				
				if(min >= max) break;
				
				int sum = list[max] + list[min];
				if(sum == num) {
					good++;
					break;
				}
				else if(sum > num) {
					max--;
				} else if(sum < num) {
					min++;
				}
			}
		}
		
		System.out.println(good);
	}

}