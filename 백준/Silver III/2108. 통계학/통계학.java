import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int res_1 = 0;
	static int res_2 = 0;
	static int res_3 = 0;
	static int res_4 = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[] list = new int[N];
		Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
		int center = N/2;
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			res_1 += x;
			
			list[i] = x;
			if(map.containsKey(x)) {
				int v = map.get(x);
				map.put(x, v+1);
			} else {
				map.put(x, 1);
			}
		}
		
		Arrays.sort(list);
		int[][] sibal = new int[map.size()][2];

		int max = Integer.MIN_VALUE;
		int max_key = Integer.MIN_VALUE;
		int cnt = 0;
		for(Integer i : map.keySet()) {
			sibal[cnt][0] = i;
			sibal[cnt][1] = map.get(i);
			cnt++;
		}
		
		Arrays.sort(sibal, (a, b) -> Integer.compare(b[1], a[1]));
		int a = sibal.length;
		
		if(a == 1) {
			max_key = sibal[0][0];
		}
		else {
			if(sibal[0][1] == sibal[1][1]) {
				max_key = sibal[1][0];
			} else {
				max_key = sibal[0][0];
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append((int)Math.round((double)res_1/N)).append("\n")
		.append(list[center]).append("\n")
		.append(max_key).append("\n")
		.append(list[N-1] - list[0]);
		
		System.out.println(sb);
		
	}

}