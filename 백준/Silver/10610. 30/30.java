import java.io.BufferedReader;
import java.io.InputStreamReader;

// 30
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = s.length();
		int[] num = new int[10];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			num[s.charAt(i)-'0']++;
			sum += s.charAt(i)-'0';
		}
	
		StringBuilder sb = new StringBuilder();
		if(num[0]==0 || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			for(int i = 9; i >= 0; i--) {
				for(int j = 0; j < num[i] ; j++) {
					sb.append(i);
//					System.out.print(i);
				}
			}
			System.out.println(sb);
		}
		
	}
}