import java.io.*;
import java.util.Arrays;

public class Main {

	static int t,n;
	static String[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		t = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new String[n];
			for(int i = 0; i < n; i++) {
				list[i] = br.readLine();
			}
			
			Arrays.sort(list);
			
			boolean flag = false;
			for(int i = 0; i < n-1; i++) {
				int len = Math.min(list[i].length(), list[i+1].length());
				flag = false;
				String s1 = list[i].substring(0,len);
				String s2 = list[i+1].substring(0,len);
				if(s1.equals(s2)) {
					flag = true;
					break;
				}
			}
			if(flag) sb.append("NO").append("\n");
			else sb.append("YES").append("\n");
		}
		System.out.println(sb);
	}

}