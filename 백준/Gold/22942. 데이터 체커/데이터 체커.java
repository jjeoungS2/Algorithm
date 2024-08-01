import java.util.*;
import java.io.*;
public class Main {
	static int N,x,r;
	static boolean issame = false;
	static ArrayList<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			list.add(new int[] {t,x-r});
			list.add(new int[] {t,x+r});
		}
		
		Collections.sort(list,(o1,o2)->{
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			return o1[1]-o2[1];
		});

		ArrayDeque<int[]> q = new ArrayDeque<>();	
		for(int[] temp : list)
		{
			if(q.isEmpty()) {
				q.add(temp);
			}
			else {
				int n = q.peekLast()[0];
				if(n == temp[0]) {
					q.pollLast();
				} else {
					q.add(temp);
				}
			}
		}
		if(q.isEmpty()) System.out.println("YES");
		else System.out.println("NO");	
	}

}