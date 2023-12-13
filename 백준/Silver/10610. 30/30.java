import java.io.BufferedReader;
import java.io.InputStreamReader;

// 30
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = s.length();
		int[] num = new int[10];
		boolean success = false;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			
			int cnt = s.charAt(i)-'0';
			num[cnt]++;
			sum += cnt;
			
			if(cnt == 0) {
				success = true;
			}
		}
		
		if(!success || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			for(int i = 9; i >= 0; i--) {
				int t = num[i];
				for(int j = 0; j < t ; j++) {
					System.out.print(i);
				}
			}
		}
		
	}
}