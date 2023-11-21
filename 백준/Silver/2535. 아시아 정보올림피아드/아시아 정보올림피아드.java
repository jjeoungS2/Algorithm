import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        int[] con = new int[101];


        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr,(o1,o2) -> Integer.compare(o2[2],o1[2]));
        int cnt = 0;

        while(cnt < 3){
            for(int i = 0; i < N; i++){
                if(cnt == 3) break;
                if(con[arr[i][0]] != 2){
                    cnt++;
                    con[arr[i][0]]++;
                    sb.append(arr[i][0]).append(" ").append(arr[i][1]).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}
