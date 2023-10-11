import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세 참가자의 입학 연도를 100으로 나눈 나머지를 오름차순으로 정렬해서 이어 붙인 문자열
// 세 참가자 중 성씨를 영문으로 표기했을 때의 첫 글자를 백준 온라인 저지에서 해결한 문제가 많은 사람부터 차례대로 나열한 문자열
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        // 입학 연도 100으로 나눈 나머지
        int[] year = new int[3];
        // 백준 해결문제 많은 순
        String[][] bg = new String[3][2];

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            bg[i][0] = st.nextToken();
            year[i] = Integer.parseInt(st.nextToken())%100;
            bg[i][1] = st.nextToken();
        }

        Arrays.sort(year);
        Arrays.sort(bg, (o1, o2) -> Integer.compare(Integer.parseInt(o2[0]), Integer.parseInt(o1[0])));

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<year.length;i++){
            sb.append(year[i]);
        }
        sb.append("\n");
        for(int i=0;i<bg.length;i++){
            String s = bg[i][1];
            sb.append(s.charAt(0));
        }

        System.out.print(sb);

    }
}
