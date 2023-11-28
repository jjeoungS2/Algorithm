import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS
public class Main {
    static int N,M,V;
    static ArrayList<Integer> list[];
    static boolean visited[];
    static StringBuilder D = new StringBuilder();
    static StringBuilder B = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        int a;
        int b ;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i<=N;i++){
            if(list[i]!=null){
                list[i].sort(null);
            }
        }

        D.append(V).append(" ");
        dfs(V);
        visited = new boolean[N+1];
        bfs(V);
        System.out.println(D);
        System.out.println(B);
    }

    public static void dfs(int index){
        visited[index] = true;
        for(int i : list[index]){
            if(!visited[i]){
                D.append(i).append(" ");
                dfs(i);
            }
        }
    }

    public static void bfs(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = true;
        while(!q.isEmpty()){
            index = q.poll();
            B.append(index).append(" ");
            for(int i : list[index]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
