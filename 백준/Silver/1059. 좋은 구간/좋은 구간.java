import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        L = Integer.parseInt(br.readLine());
        int[] arr = new int[L];
        int start = 0;
        int end = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<L;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < L; i++){
            if(i == 0){
                if(n > 0 && n < arr[i]){
                    start = 1;
                    end = arr[i] - 1;
                    break;
                }
                continue;
            }
            if(n > arr[i-1] && n < arr[i]){
                start = arr[i-1] + 1;
                end = arr[i] - 1;
                break;
            }
        }
        int res = 0;
        if(start == 0 && end == 0) System.out.print(0);
        else{
            for(int i = start; i <= n;i++){
                for(int j = n; j<=end; j++){
                    if(i!=j) res++;
                }
            }
            System.out.print(res);
        }
    }
}
