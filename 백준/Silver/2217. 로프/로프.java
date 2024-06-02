import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
        Arrays.sort(arr, Collections.reverseOrder());  //내림차순으로 정렬하기
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum = Math.max(sum, arr[i] * (i+1));
		}
		
		System.out.println(sum);
	}

}