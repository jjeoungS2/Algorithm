class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int i = 3; i < sum/2; i++){
            int w = sum/i;
            if(w>=i){
                if ((i - 2) * (w - 2) == yellow) {
                answer[0] = w;
                answer[1] = i;
                break;
                }
            }
        }
        return answer;
    }
}