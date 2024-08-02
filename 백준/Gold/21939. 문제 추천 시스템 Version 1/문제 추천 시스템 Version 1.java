import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static TreeSet<int[]> list = new TreeSet<>((o1,o2)->{
		if(o1[1] == o2[1]) return o1[0]-o2[0];
		return o1[1]-o2[1];
	});
	static Map<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			list.add(new int[] {P,L});
			map.put(P, L);
		}
		
		M = Integer.parseInt(br.readLine());
		int x,P,L;
		for(int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			switch(s) {
			case "add":
				P = Integer.parseInt(st.nextToken());
				L = Integer.parseInt(st.nextToken());
				list.add(new int[] {P,L});
				map.put(P, L);
				break;
			case "recommend":
				x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					int[] temp = list.last();
					System.out.println(temp[0]);
				} else {
					int[] temp = list.first();
					System.out.println(temp[0]);
				}
				break;
			case "solved":
				P = Integer.parseInt(st.nextToken());
				L = map.get(P);
				list.remove(new int[] {P,L});
				break;
			}
		}
	}
}