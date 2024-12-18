import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int idx = people.length-1;
        Arrays.sort(people);
        int n = 0;
        while(true){
            if(idx <= n) {
                if(idx == n) answer++;
                break;
            }
            if(people[n] + people[idx] <= limit){
                n++;
            } 
            answer++;
            idx--;
        }
        
        return answer;
    }
}