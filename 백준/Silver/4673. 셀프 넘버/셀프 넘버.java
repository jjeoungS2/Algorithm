import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		int n = 1;
		boolean[] check = new boolean[10001];

		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < 10001; i++) {
			int num = i;
			int sum = i;
			
			while(num!=0) {
				sum = sum + (num%10);
				num = num/10;
			}
			
			if(sum < 10001) {
				check[sum] = true;
			}
			
		}
		
		for(int i = 1; i < 10001; i++) {
			if(!check[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}

}