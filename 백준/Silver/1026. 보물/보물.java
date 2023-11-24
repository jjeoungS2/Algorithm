import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int res = 0;
        for(int i =0;i<N;i++) {
            res += A[i] * B[i];
        }
        System.out.print(res);
    }
}
