import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,Integer> list = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.length() >= M) {
				list.put(s, list.getOrDefault(s,0)+1);
			}
		}
		
		List<String> a = new ArrayList<>(list.keySet());
		
		a.sort((o1,o2)->{
			int cnt = Integer.compare(list.get(o2), list.get(o1));
			if(cnt!=0) return cnt;
			int leg = Integer.compare(o2.length(), o1.length());
			if(leg!=0) return leg;
			return o1.compareTo(o2);
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a.size(); i++) {
			sb.append(a.get(i)+"\n");
		}
		System.out.println(sb);
	}

}