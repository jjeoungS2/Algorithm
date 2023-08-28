import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] arr;
    static int[][] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new int[N][M];
        int start_x = 0;
        int start_y = 0;

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'I'){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        int res = bfs(start_x,start_y);
        if(res == 0){
            System.out.print("TT");
        } else {
            System.out.println(res);
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int bfs(int a, int b){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a,b});
        visit[a][b] = 1;
        int res = 0;

        while(!q.isEmpty()){
            int[] index = q.poll();
            for(int i =0;i<4;i++){
                int x = index[0] + dx[i];
                int y = index[1] + dy[i];

                if(x < 0 || x >= N || y < 0 || y >=M || visit[x][y] == 1) continue;
                if(arr[x][y] != 'X'){
                    visit[x][y] = 1;
                    if(arr[x][y] == 'P') res++;
                    q.add(new int[]{x,y});
                }
            }
        }
        return res;
    }
}
