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
		
		
		while (true) {
			if(idx == 0) {
				s = words[0].toCharArray();
				last = s[s.length - 1];
				map.put(words[0], num);
				idx++;
				num++;
				continue;
			}
			
			// 인덱스 길이랑 배열 길이랑 같아지면 스탑 
			if(idx == words.length) break;
			
			s = words[idx].toCharArray();
			
			// 나왔던 단어라면 스톱 
			if(map.containsKey(words[idx])) {
				flag = false;
				break;
			}
			// 단어 map에 넣
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