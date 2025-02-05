import java.util.*;
class Solution {
    public List solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue <Integer> q = new LinkedList<>();
        int num = 0;
        for(int i = 0; i < progresses.length; i++){
            num = 100 - progresses[i];
            if(num%speeds[i] != 0) {
                q.add(num/speeds[i] + 1);
            }
            else {
                q.add(num/speeds[i]);
            }
        }
        num = q.poll();
        int cnt = 1;
        System.out.print(num+" ");
        while(!q.isEmpty()){
            if(q.peek() <= num){
                q.poll();
                cnt++;
            } else {
                num = q.poll();
                answer.add(cnt);
                cnt = 1;
            }
        }
        answer.add(cnt);
        return answer;
    }
}