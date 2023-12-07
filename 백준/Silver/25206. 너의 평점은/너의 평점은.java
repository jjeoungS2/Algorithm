import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 학점 * 과목평점 / 학점의 총합
public class Main {
	static double grade = 0;
	static double sum = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0 ; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			String subject = st.nextToken();
			double a = Double.parseDouble(st.nextToken());
			String b = st.nextToken();
			sum += a;
			switch (b) {
				case "A+" :
					grade += a*4.5;
					break;
				case "A0" :
					grade += a*4.0;
					break;
				case "B+" :
					grade += a*3.5;
					break;
				case "B0" :
					grade += a*3.0;
					break;
				case "C+" :
					grade += a*2.5;
					break;
				case "C0" :
					grade += a*2.0;
					break;
				case "D+" :
					grade += a*1.5;
					break;
				case "D0" :
					grade += a*1.0;
					break;
				case "F" :
					grade += a*0.0;
					break;
				default :
					sum -= a;
					break;
				
			}
		}
		System.out.println(grade/sum);
	}

}
