import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> q = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(q.empty()){
                q.add(x);
            } else {
                char n = q.peek();
                if(x == n) q.add(x);
                else if(x == ')' && n == '(') q.pop();
            }
        }
        
        if(q.empty()) answer = true;
        else answer = false;
        return answer;
    }
}