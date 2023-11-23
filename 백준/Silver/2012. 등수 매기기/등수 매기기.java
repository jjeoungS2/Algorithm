import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        for(int i = 1; i < N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long res = 0;
        for(int i = 1; i < N+1; i++){
            if(arr[i] != i) {
                if(arr[i] >= N) continue;
                if(arr[arr[i]] != arr[i] ){
                    int temp = arr[arr[i]];
                    arr[arr[i]] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for(int i = 1; i < N+1 ;i++){
            if(arr[i]!= i){
                res+= Math.abs(arr[i]-i);
            }
        }
        System.out.println(res);
    }
}
