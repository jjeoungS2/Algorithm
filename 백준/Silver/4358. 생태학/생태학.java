import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Double> list = new TreeMap<>();
		
		String s;
		double cnt = 0.0;
		while((s = br.readLine()) != null) {
			if(s.equals("")) break;
			if(list.containsKey(s)) {
				list.put(s, list.get(s)+1);
			} else list.put(s, 1.0);
			cnt++;
		}

		for(Map.Entry<String, Double> e : list.entrySet()) {
			System.out.printf("%s %.4f",e.getKey(),e.getValue()/cnt*100);
			System.out.println();
		}
	}

}