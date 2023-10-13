import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[5];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(Math.abs(arr[1]-arr[3]) >= 4){
                sb.append("KIN\n");
            } else {
                int sum = arr[1]+arr[2]+arr[3];
                sb.append(sum).append("\n");
            }
        }

        System.out.print(sb);

    }
}
