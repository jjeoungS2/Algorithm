import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int[][] temp = new int[s.length()+1][t.length()+1];
		int res = 0;
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 1; j <= t.length(); j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					temp[i][j] = temp[i-1][j-1]+1;
				}
                res = Math.max(res, temp[i][j]);
			}
		}
		System.out.println(res);
	}

}