class Solution {
    public int[] solution(int n) {
        int[][] tri = new int[n][n];
        int x = -1;
        int y = 0;
        int[] answer = new int[(n*(n+1))/2];

        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i%3 == 0){
                    x++;
                } else if(i%3 == 1){
                    y++;
                } else if(i%3==2){
                    x--;
                    y--;
                }
                tri[x][y] = num++;
            }
        }

        int idx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(tri[i][j] == 0) break;
                answer[idx++] = tri[i][j];
            }
        }
        return answer;
    }
}