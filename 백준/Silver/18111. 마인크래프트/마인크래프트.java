import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

public class Main {

    static int N,M,B;
    static int[][] arr;
    static int[][] check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new int[N][M];
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > Max) Max = arr[i][j];
                if(arr[i][j] < Min) Min = arr[i][j];
            }
        }

        int h = Min;
        int time = Integer.MAX_VALUE;
        int height = Integer.MIN_VALUE;
        int inventory = B;
        int res = 0;
        int flag = 0;

        for(int i = 0 ; i <= Max-Min; i++){
            // 블록 지우고 인벤토리에 저장하기
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    if(arr[x][y] > h){
                        int a = arr[x][y] - h;
                        inventory += a;
                        res += a*2;
                        if(res > time){
                            flag = 1;
                            break;
                        }
                    }
                }
            }

            // 블록 올리기
            for(int x=0;x<N;x++){
                for(int y=0;y<M;y++){
                    if(arr[x][y] < h){
                        int a = h - arr[x][y];
                        if(a <= inventory) {
                            res += a;
                            inventory -= a;
                        } else {
                            flag = 1;
                            break;
                        }
                        if(res > time){
                            flag = 1;
                            break;
                        }
                    }
                }
                if(flag == 1) break;
            }
            if(flag == 1) continue;
            if( res < time ){
                time = res;
                height = h;
            } else if( res == time && h > height){
                height = h;
            }
            inventory = B;
            res = 0;
            flag = 0;
            h++;
        }

        System.out.print(time+" "+height);
    }
}
