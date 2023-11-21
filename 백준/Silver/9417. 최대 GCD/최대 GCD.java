import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int res = 0;
        for(int i = 0;i < N; i++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            int cnt = st.countTokens();
            for(int j = 0; j < cnt; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            int num = 0;
            int max;
            int min;
            for(int a = 0; a < arr.length; a++){
                for(int b = a + 1; b < arr.length; b++){
                    if(arr[a] > arr[b]){
                        max = arr[a];
                        min = arr[b];
                    } else {
                        max = arr[b];
                        min = arr[a];
                    }

                    while(true){
                        if(max % min > 0){
                            int temp = min;
                            min = max % min;
                            max = temp;
                        } else {
                            num = min;
                            break;
                        }
                    }
                    if(num > res){
                        res = num;
                    }
                }
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
