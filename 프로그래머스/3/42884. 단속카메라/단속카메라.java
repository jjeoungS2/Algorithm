import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (o1,o2) -> {
            return o1[1] - o2[1];
        });
        int cam = Integer.MIN_VALUE;
        for(int[] i : routes){
            if(cam < i[0]){
                cam = i[1];
                answer++;
            }
        }
        return answer;
    }
}