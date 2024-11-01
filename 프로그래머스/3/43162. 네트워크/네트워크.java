class Solution {
    static boolean[] visit;
    static int N;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        N = n;
        int answer = 0;

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                bfs(i,computers);
                answer++;
            }
        }
        return answer;    
    }
    public static void bfs(int x, int[][] computers){
        visit[x] = true;
        for(int i = 0; i < N; i++){
            if(!visit[i] && computers[x][i] == 1){
                bfs(i, computers);
            }
        }
    }
}