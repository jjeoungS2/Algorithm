import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		HashMap<String,Integer> map_S = new HashMap<>();
		HashMap<Integer,String> map_I = new HashMap<>();
		
		for(int i = 0; i<m;i++) {
			String s = sc.next();
			map_S.put(s, i);
			map_I.put(i, s);
		}
		
		for(int i = 0; i<n;i++) {
			String s = sc.next();
			if(isInteger(s)) {
				int a = Integer.parseInt(s);
				System.out.println(map_I.get(a-1));
			}
			else {
				System.out.println(map_S.get(s)+1);
			}
		}
	}
	


}