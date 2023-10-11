import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Integer[] run = new Integer[2];
        Integer[] trick = new Integer[5];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                run[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < 5; j++){
                trick[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(run, (o1,o2) -> o2 - o1);
            Arrays.sort(trick,(o1,o2) -> o2 - o1);
            int sum = run[0]+trick[0]+trick[1];
            if(max < sum) max = sum;
        }

        System.out.print(max);
    }
}
