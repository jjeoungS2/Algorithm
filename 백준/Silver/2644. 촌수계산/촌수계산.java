import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int a,b;
    static ArrayList<Integer> list[];
    static int res = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < m+1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(a,b,0);
        if(res == 0){
            res = -1;
        }
        System.out.println(res);
    }

    public static void dfs(int start, int end, int cnt){
        if(start == end){
            res = cnt;
            return;
        }
        visited[start] = true;

        for(int i = 0; i < list[start].size(); i++){
            int next = list[start].get(i);
            if(!visited[next]) dfs(next,end,cnt+1);
        }

    }
}
