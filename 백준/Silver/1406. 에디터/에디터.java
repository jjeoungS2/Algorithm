import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 에디터 
public class Main {

	static Deque<Character> qL = new ArrayDeque<>();
	static Deque<Character> qR = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = s.length();
		for(int i = 0; i < n; i++) {
			qL.add(s.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String S = br.readLine();
			
			switch(S.charAt(0)) {
				case 'L':
					if(!qL.isEmpty()) {
						qR.addFirst(qL.pollLast());
					}
					break;
				case 'D':
					if(!qR.isEmpty()) {
						qL.addLast(qR.pollFirst());
					}
					break;
				case 'B':
					if(!qL.isEmpty()) {
						qL.pollLast();
					}
					break;
				case 'P':
					qL.addLast(S.charAt(2));
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!qL.isEmpty()) {
			sb.append(qL.pollFirst());
		}
		while(!qR.isEmpty()){
			sb.append(qR.pollFirst());
		}
		
		System.out.println(sb);
	}

}