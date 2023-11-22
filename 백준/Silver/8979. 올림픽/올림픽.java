import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 국가수
        K = Integer.parseInt(st.nextToken());   // 등수 알고싶은 국가
        int[][] C = new int[N][4];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++){
                C[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(C, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    if(o1[2] == o2[2]){
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });

        int gold = -1;
        int si = -1;
        int bro = -1;
        int flag = 0;
        int res = 0;
        int same = 0;
        
        for(int i = 0; i < N; i++){
            flag = 0;
            if(C[i][1]!=gold) {
                gold = C[i][1];
                flag = 1;
            }
            if(C[i][2]!=si){
                si = C[i][2];
                flag = 1;
            }
            if(C[i][3]!= bro){
                bro = C[i][3];
                flag = 1;
            }
            if(flag == 0){
                same = 1;
            }
            if(flag != 0 ){
                if(same == 1){
                    res+=2;
                    same = 0;
                }
                else{
                    res++;
                }
                flag = 0;
            }
            if(C[i][0] == K) break;
        }
        System.out.print(res);
    }
}
