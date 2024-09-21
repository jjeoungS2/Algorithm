import java.util.*;
import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double N = Integer.parseInt(br.readLine());
		
		double a = N-(N*0.22);
		double temp = N*0.2;
		double b =  N-(temp*0.22);
		
		System.out.println((int)a+" "+(int)b);
	}

}