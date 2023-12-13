import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 30
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = s.length();
		Integer[] num = new Integer[n];
		boolean success = false;
		int res = 0;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			num[i] = s.charAt(i)-'0';
			sum += num[i];
			if(num[i] == 0) {
				success = true;
			}
		}
		
		if(!success || sum % 3 != 0) {
			System.out.println(-1);
		} else {
			Arrays.sort(num);
		
			for(int i = n-1; i >= 0; i--) {
				System.out.print(num[i]);
			}
		}
		
	}
}