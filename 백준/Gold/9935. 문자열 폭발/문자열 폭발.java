import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();
		int t = s.length();
		int bomb_len = bomb.length();
		
		
		for(int i = 0; i < t; i++) {
			int count = 0;
			stack.push(s.charAt(i));
			
			if(stack.size() >= bomb_len) {
				for(int j = 0; j < bomb_len; j++) {
					if(stack.get(stack.size()-bomb_len+j) == bomb.charAt(j)) {
						count++;
					}
				}
				if(count == bomb_len) {
					for(int j = 0; j <bomb_len;j++) {
						stack.pop();
					}
				}
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			System.out.println(sb);
		}
	}

}