import java.util.*;
import java.io.*;

// IQ Test
public class Main {
	static int N;
	static int[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

        if(N == 1) System.out.println("A");
		else if(N == 2 && list[0] == list[1]) System.out.println(list[0]);
		else if(N == 2 && list[0]!=list[1]) System.out.println("A"); 
		else {
			
			int a,b;
			if(list[0] == list[1]) {
				a = 1;
				b = 0;
			} else {
				a = (list[2] - list[1]) / (list[1] - list[0]);
				b = list[1] - list[0]*a;
			}
			
			boolean flag = true;
			for(int i = 0; i < N-1; i++) {
				if(list[i+1] != list[i]*a+b) {
					flag = false;
					break;
				}
			}
			if(flag) System.out.println(list[N-1]*a+b);
			else System.out.println("B");
		}
	
	}
}