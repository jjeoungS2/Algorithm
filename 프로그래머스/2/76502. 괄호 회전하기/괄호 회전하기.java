import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        Deque<Character> dq = new ArrayDeque<>();
        
        for(int i = 0; i < len; i++){
            dq.addLast(s.charAt(i));
        }
  
        for(int i = 0; i < len; i++){
            Character[] list = dq.toArray(new Character[0]);
            Stack<Character> q = new Stack<>();
            q.push(list[0]);
            if(list[0] == ')' || list[0] == ']' || list[0] == '}') {
                char a = dq.pollFirst();
                dq.addLast(a);
                continue;
            }
            else {
                for(int j = 1; j < len; j++){
                    char b = list[j];
                    if(q.isEmpty()){
                        if(b == ']' || b == ')' || b == '}') {
                            q.push(b);
                            break;
                        }
                        else q.push(b);
                    } else {
                        char a = q.peek();
                        // System.out.println("a:"+a+" b:"+b);
                        if(a == '(' && b ==')') q.pop();
                        else if(a == '{' && b =='}') q.pop();
                        else if(a == '[' && b==']') q.pop();
                        else q.push(b);
                    }
                }
            }
            if(q.isEmpty()) {
                answer++;
                // System.out.println("answer:"+answer);
            }
            char a = dq.pollFirst();
            dq.addLast(a);
        }
        return answer;
    }
}