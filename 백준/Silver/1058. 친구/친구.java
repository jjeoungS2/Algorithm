import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

// 친구
public class Main {
    static int N;
    static int[] res;
    static boolean[] visited;
    static ArrayList<Integer> map[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N];
        res = new int[N];
        StringTokenizer st;

        for(int i = 0 ; i<N;i++){
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N;j++){
                if(s.charAt(j) == 'Y'){
                    map[i].add(j);
                }
            }
        }

        for(int i = 0; i < N ;i++){
            visited = new boolean[N];
            Queue<Integer> q = new ArrayDeque<>();
            visited[i] = true;
             for(int j : map[i]){
                q.add(j);
                visited[j] = true;
                res[i]++;
            }
            while(!q.isEmpty()){
                int x = q.poll();
                if(!map[x].isEmpty()){
                    for(int j : map[x]){
                        if(!visited[j] && j!=i){
                            visited[j] = true;
                            res[i]++;
                        }
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0; i<N;i++){
            result = Math.max(res[i],result);
        }
        System.out.print(result);
    }
}
