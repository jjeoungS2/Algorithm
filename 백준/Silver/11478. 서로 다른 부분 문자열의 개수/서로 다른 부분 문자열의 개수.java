import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Set<String> list = new HashSet<>();
		int n = s.length();
		int j = 0;
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(j = i+1; j <= n; j++) {
				list.add(s.substring(i,j));
			}
		}
		System.out.println(list.size());
	}

}