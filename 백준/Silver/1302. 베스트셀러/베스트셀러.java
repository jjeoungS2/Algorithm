import java.util.*;
import java.io.*;
// 베스트셀러 1302
public class Main {
	static TreeMap<String, Integer> list = new TreeMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		for(int t = 0; t < n; t++) {
			String s = br.readLine();
			list.put(s, list.getOrDefault(s, 0)+1);
			max = Math.max(max, list.get(s));
		}
		
		List<String> temp = new ArrayList<>();
		
		for(Map.Entry<String, Integer> entry : list.entrySet()) {
			if(entry.getValue() == max) temp.add(entry.getKey());
		}
		Collections.sort(temp);
		System.out.println(temp.get(0));
	}

}