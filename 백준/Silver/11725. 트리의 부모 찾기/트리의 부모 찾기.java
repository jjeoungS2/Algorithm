import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class Main {
    static int N;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<Integer> list[];
    public static  void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        list = new ArrayList[N+1];
        parent = new int[N+1];

        Arrays.setAll(list, i -> new ArrayList<>());

        for(int i = 0; i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i<N+1; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int index){
        visit[index] = true;
        for(int i : list[index]){
            if(!visit[i]){
                parent[i] = index;
                dfs(i);
            }
        }
    }
}
