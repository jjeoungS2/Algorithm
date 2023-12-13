import java.io.BufferedReader;
import java.io.InputStreamReader;

// 방 번호 
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int leg = s.length();
		int[] n = new int[10];
		int res = 0;
		
		for(int i = 0; i < leg; i++) {
			n[s.charAt(i)-'0']++;
		}
		
		int x = (n[6] + n[9])/2;
		if( (n[6] + n[9])%2 == 0) {
			res += x;
		} else {
			res = x+1;
		}
		
		for(int i = 0; i < 10;i++) {
			if(i == 6 || i == 9) continue;
			res = Math.max(res, n[i]);
		}
		
		System.out.println(res);
	}

}