import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int n = (int)Math.round(N*0.15);
        int sum = 0;

        for(int i = n ; i < N-n; i++){
            sum += arr[i];
        }
        double a = (double)sum / ((double)N-(double)n*2);
        System.out.println(Math.round(a));



    }
}
