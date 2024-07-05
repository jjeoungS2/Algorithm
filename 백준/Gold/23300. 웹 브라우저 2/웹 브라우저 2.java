import java.io.*;
import java.util.*;

public class Main {
	static int N,Q;
	static Deque<Integer> front = new ArrayDeque<>();
	static Deque<Integer> back = new ArrayDeque<>();
	static int now;
	static int flag = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("B")){
				if(back.isEmpty()) continue;
				else {
					front.addFirst(now);
					now = back.pollLast();		
				}
			}
			else if(s.equals("F")){
				if(front.isEmpty()) continue;
				else {
					back.addLast(now);
					now = front.pollFirst();
				}
			}
			else if(s.equals("A")){
				int page = Integer.parseInt(st.nextToken());
				front.clear();
				if(flag == 0) {
					now = page;
					flag = 1;
					continue;
				}
				back.addLast(now);
				now = page;
			} 
			else if(s.endsWith("C")) {
				if(back.isEmpty()) continue;
				Deque<Integer> temp = new ArrayDeque<Integer>();
				int t = back.size();
				
				int a = back.pollFirst();
				temp.addLast(a);
				for(int j = 1; j < t; j++) {
					a = back.pollFirst();
					if(a != temp.peekLast()) {
						temp.addLast(a);
					}
				}
				back.clear();
				t = temp.size();
				for(int j = 0; j < t; j++) {
					back.addLast(temp.pollFirst());
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(now+"\n");
		
		if(back.isEmpty()) {
			sb.append("-1\n");
		} else {
			int size = back.size();
			for(int i = 0; i < size; i++) {
				sb.append(back.pollLast()+" ");
			} sb.append("\n");
		}
		
		if(front.isEmpty()) {
			sb.append("-1\n");
		} else {
			int size = front.size();
			for(int i = 0; i < size; i++) {
				sb.append(front.pollFirst()+" ");
			} sb.append("\n");
		}
		System.out.println(sb);
	}

}