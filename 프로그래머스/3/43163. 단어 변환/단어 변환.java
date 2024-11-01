import java.util.*;
class Solution {
    static int[] visit;
    static Queue<Integer> q = new LinkedList<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        visit = new int[len];
        int cnt = 0;
        for(int i = 0; i < len; i++){
            if(dif(begin,words[i]) == 1){
                q.add(i);
                visit[i] = 1;
            }
            if(target.equals(words[i])){
                cnt = 1;
            }
        }
        
        if(cnt == 0){
            return 0;
        }
        
        while(!q.isEmpty()){
            int idx = q.poll();
            String s = words[idx];
            
            if(s.equals(target)){
                answer = visit[idx];
                break;
            }
            
            for(int i = 0; i < len; i++){
                if(visit[i] == 0 && dif(s,words[i]) == 1){
                    q.add(i);
                    visit[i] = visit[idx] + 1;
                }
            }
        }
        
        return answer;
    }
    public static void check(String target, String[] words){
        
    }
    public static int dif(String begin,String words){
        int cnt = 0;
        for(int i = 0; i < begin.length(); i++){
            if(words.charAt(i) != begin.charAt(i)){
                cnt++;
            }
            
        }
        return cnt;
    }
}