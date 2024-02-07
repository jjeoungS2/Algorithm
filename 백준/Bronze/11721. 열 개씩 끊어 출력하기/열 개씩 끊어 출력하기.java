import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size = s.length();
		for(int i = 0 ; i < size; i++) {
			if( (i+1) % 10 == 0) {
				System.out.print(s.charAt(i));
				System.out.println();
			} else {
				System.out.print(s.charAt(i));
			}
		}
	}

}