import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] W = new Integer[10];
        Integer[] K = new Integer[10];

        for(int i = 0 ; i < 10; i++){
            W[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < 10; i++){
            K[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(W, (o1,o2)-> o2 - o1);
        Arrays.sort(K, (o1,o2)-> o2 - o1);

        int W_sum = 0;
        int K_sum = 0;
        for(int i =0;i<3;i++){
            W_sum += W[i];
            K_sum += K[i];
        }
        System.out.print(W_sum+" "+K_sum);


    }
}
