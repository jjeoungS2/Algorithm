import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br. readLine();

        List<String> list = new ArrayList<>();
        for(int i = 1; i < s.length(); i++){
            for(int j = i + 1; j < s.length(); j++){
                StringBuilder sb1 = new StringBuilder(s.substring(0,i));
                StringBuilder sb2 = new StringBuilder(s.substring(i,j));
                StringBuilder sb3 = new StringBuilder(s.substring(j));
                StringBuilder sb4 = new StringBuilder();
                sb4.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());
                list.add(sb4.toString());
            }
        }

        Collections.sort(list);

        System.out.print(list.get(0));

    }
}
