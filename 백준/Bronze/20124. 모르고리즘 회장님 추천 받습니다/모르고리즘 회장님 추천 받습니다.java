import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 모르고리즘 회장님 추천 받습니다.
public class Main {
    static int N;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }
        Arrays.sort(arr, (o1,o2) -> {
            if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){
                return o1[0].compareTo(o2[0]);
            } else{
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        System.out.print(arr[0][0]);
    }
}
