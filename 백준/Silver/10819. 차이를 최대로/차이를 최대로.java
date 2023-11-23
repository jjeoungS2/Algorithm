import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static int[] arr2;
    static int res;
    static void comb(int cnt){
        if(cnt == N){
            int sum = 0;
            for(int i =0;i<N-1;i++){
                sum += Math.abs(arr2[i] - arr2[i+1]);
            }
            res = Math.max(res,sum);
            return;
        }
        for(int i =0;i<N;i++){
            if(!visited[i]){
                arr2[cnt] = arr[i];
                visited[i] = true;
                comb(cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        arr2 = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        comb(0);
        System.out.println(res);

    }
}
