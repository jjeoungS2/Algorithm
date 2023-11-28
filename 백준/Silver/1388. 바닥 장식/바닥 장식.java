import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바닥 장식
public class Main {
    static int N,M;
    static char[][] map;
    static boolean visited[][];
    static int res = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j);
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]) dfs(i,j,map[i][j]);
            }
        }
        System.out.println(res);
    }

    public static void dfs(int x, int y, char c){
        visited[x][y] = true;
        // 1 이면 -
        // 2 면 |

        if(c == '-'){
            for(int i = y+1; i<M; i++){
                if(!visited[x][i] && map[x][i] == '-'){
                    visited[x][i] = true;
                } else{
                    res++;
                    return;
                }
            }
            res++;
        }
        else if(c == '|'){
            for(int i = x+1; i<N; i++){
                if(!visited[i][y] && map[i][y] == '|'){
                    visited[i][y] = true;
                } else{
                    res++;
                    return;
                }
            }
            res++;
        }


    }
}
