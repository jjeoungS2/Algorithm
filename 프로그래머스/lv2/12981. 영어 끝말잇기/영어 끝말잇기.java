import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] res = new int[2];
        Map<String,Integer> map = new HashMap<>();
		boolean flag = true;
		int num = 0; // 첫번째 사람부터
		int game = 1;	// 몇번째 차례인지 
		int idx = 0; // 문자배열 inx
		
		char[] s;
		char last = ' ';
		char first;
		
		
		for(int i=0;i<words.length;i++){
			if(idx == 0) {
				s = words[0].toCharArray();
				last = s[s.length - 1];
				map.put(words[0], num);
				idx++;
				num++;
				continue;
			}
			
			s = words[idx].toCharArray();
			
			// 나왔던 단어라면 스톱 
			if(map.containsKey(words[idx])) {
				flag = false;
				break;
			}
			// 처음나온 단어 map에 넣기
			map.put(words[idx], num);
			
			first = s[0];
			if(last == first) {
				last = s[s.length-1];
				num++;
				idx++;	
				if(num == n) {
					num = 0;
					game++;
				}
				continue;
			} else {
				flag = false;
				break;
			}
		}
		if(flag == true) {
			res[0] = 0;
			res[1] = 0;
		} else {
			num++;
			if(num > n) num = 1;
			res[0] = num;
			res[1] = game;
		}
        
        return res;
    }
}