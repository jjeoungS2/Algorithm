import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> A = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            A.put(want[i],number[i]);
        }
        
        for(int i = 0; i < 10; i++){
            if(A.containsKey(discount[i])){
                A.put(discount[i], A.get(discount[i]) - 1);
            }
        }
        
        boolean flag = true;
        
        for(String key : A.keySet()){
            if(A.get(key) != 0) {
                flag = false;
                break;
            }
        }
        
        if(flag) answer++;
        
        for(int i = 10; i < discount.length; i++){
            if(A.containsKey(discount[i])){
                A.put(discount[i], A.get(discount[i]) - 1);
            }
            if(A.containsKey(discount[i-10])){
                A.put(discount[i-10], A.get(discount[i-10]) + 1);
            }
            
            flag = true;
            for(String key : A.keySet()){
                if(A.get(key) != 0) {
                   flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        
        return answer;

    }
}