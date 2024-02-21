import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		
		map = new int[s1.length+1][s2.length+1];
		
		for(int i = 1; i <= s1.length; i++) {
			for(int j = 1; j <= s2.length; j++) {
				if(s1[i-1] == s2[j-1]) {
					map[i][j] = map[i-1][j-1] + 1;
				} else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		
		System.out.println(map[s1.length][s2.length]);
	}

}