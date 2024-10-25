class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        // s = s.replace("0","");
        // System.out.println(s);
        int len_b = s.length();
        int len_a = 0;
        int rem = 0;
        int cnt = 0;
        while(!s.equals("1")){
            len_b = s.length();
            s = s.replace("0","");
            len_a = s.length();
            rem += len_b - len_a;
            System.out.println("제거할 0 개수 : " + (len_b - len_a));
            s = Integer.toBinaryString(len_a);
            System.out.println(s);
            cnt++;
        }
        System.out.println(cnt+" "+rem);
        answer[0] = cnt;
        answer[1] = rem;
        return answer;
    }
}