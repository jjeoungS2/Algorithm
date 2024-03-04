import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr = new int[1000001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Arrays.fill(arr, -1);
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		System.out.println(dp(N));
	}
	public static int dp(int N) {
		if(arr[N] == -1) {
			arr[N] = (dp(N-1) + dp(N-2)) % 15746;
		}
		return arr[N];
	}
}