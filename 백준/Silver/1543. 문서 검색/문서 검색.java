import java.util.*;
import java.io.*;
// 실5
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String a = br.readLine();
		s = s.replace(a, "*");
		int cnt = 0;
		for(int i = 0; i < s.length();i++) {
			if(s.charAt(i) == '*') cnt++;
		}
		System.out.println(cnt);
	}

}