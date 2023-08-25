import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] arr;
    static int[][] visit;
    static int[][] res;
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = 0,y = 0;
        arr = new int[N][M];
        visit = new int[N][M];
        res = new int[N][M];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x,y);

        StringBuilder sb = new StringBuilder();
         for(int i =0;i<N;i++){
             for(int j=0;j<M;j++){
                 if(arr[i][j] == 1 && visit[i][j]!=1){
                     sb.append("-1").append(" ");
                 } else {
                     sb.append(res[i][j]).append(" ");
                 }
             }
             sb.append("\n");
         }
         System.out.println(sb);
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static void bfs(int a, int b){
        Queue<int[]> q = new ArrayDeque<>();
        visit[a][b] = 1;
        q.add(new int[]{a,b});
        int cnt = 1;

        while(!q.isEmpty()){
            int[] idx = q.poll();
            int x = idx[0];
            int y = idx[1];

            for(int i = 0; i < 4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];

                if(X >= N || X < 0 || Y >= M || Y < 0){
                    continue;
                } else{
                    if(visit[X][Y] != 1 && arr[X][Y] != 0){
                        q.add(new int[]{X,Y});
                        visit[X][Y] = 1;
                        res[X][Y] = res[x][y] + 1;
                    }
                }


            }
        }
    }
}
