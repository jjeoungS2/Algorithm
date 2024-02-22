import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();
		
		char f = arr[0];
		
		int zero = 0;
		int one = 0;
		if(arr[0] == '0') zero++;
		else one++;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] != f) {
				if(f == '0') one++;
				else zero++;
				f = arr[i];
			}
		}
		if(zero < one) System.out.println(zero);
		else System.out.println(one);
	}

}