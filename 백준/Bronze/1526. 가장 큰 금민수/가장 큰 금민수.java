import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();

        while(true){
            boolean check = true;
            for(int i = 0; i < N.length(); i++){
                if(N.charAt(i) != '4' && N.charAt(i) != '7'){
                    check = false;
                    break;
                }
                if(!check) break;
            }
            if(check) break;
            else N = String.valueOf(Integer.parseInt(N)-1);
        }
        System.out.println(N);
    }
}
