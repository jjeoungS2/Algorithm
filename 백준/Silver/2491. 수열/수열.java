import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int res = 1;
        int num = Integer.parseInt(st.nextToken());
        int up = 1;
        int down = 1;
        for(int i = 1; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(num > a){
                if(up!=1) {
                    if (res < up) res = up;
                    up = 1;
                }
                down++;
            } else if (num < a){
                if(down!=1) {
                    if (res < down) res = down;
                    down = 1;
                }
                up++;
            } else {
                down++;
                up++;
            }
            num = a;
        }


        int m = Math.max(up,down);
        res = Math.max(m,res);

        System.out.print(res);
    }
}
