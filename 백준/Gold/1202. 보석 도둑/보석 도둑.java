import java.util.*;
import java.io.*;
public class Main {
	static int N,K,M,V;
	static ArrayList<int[]> list = new ArrayList<>();
	static int[] bag;
	static long ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bag = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			list.add(new int[] {M,V});
		}
		
		Collections.sort(list, (o1,o2) -> {
			if(o1[0] == o2[0]) return o2[1] - o1[1];
			else return o1[0] - o2[0];
		});
				
		for(int i = 0 ; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bag);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int t = 0;
		for(int i = 0; i < K; i++) {
			while( t < N && bag[i] >= list.get(t)[0]) {
				pq.add(list.get(t++)[1]);
			}
			if(!pq.isEmpty()) {
				ans+=pq.poll();
			}
		}
		
		System.out.println(ans);
	}

}