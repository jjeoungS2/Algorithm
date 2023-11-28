import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean visited[][];
    static String s = "Hing";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.print(s);
    }

    static int[] dx = {0,1};
    static int[] dy = {1,0};
    public static void dfs(int x, int y){
        if(map[x][y] == -1){
            s = "HaruHaru";
            return;
        }
        for(int i = 0; i < 2; i++){
            int a = x + dx[i] * map[x][y];
            int b = y + dy[i] * map[x][y];
            if(a>=N || b>=N || visited[a][b]) continue;

            visited[a][b] = true;
            dfs(a, b);
        }
    }
}
