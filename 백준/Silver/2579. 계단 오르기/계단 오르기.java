import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 계단 오르기
	static int[] score;
	static int[] sum;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		score = new int[N + 1];
		sum = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());
			score[i] = n;
		}
		
		if (N == 1) {
			System.out.println(score[N]);
		} else if(N==2){
			System.out.println(score[1]+score[2]);
		} else if(N == 3) {
			System.out.println(Math.max(score[2] + score[3], sum[1] + score[3]));
		} else {
			sum[1] = score[1];
			sum[2] = score[1] + score[2];
			sum[3] = Math.max(score[2] + score[3], sum[1] + score[3]);

			for (int i = 4; i <= N; i++) {
				sum[i] = Math.max(sum[i - 3] + score[i - 1], sum[i - 2]) + score[i];
			}
			System.out.println(sum[N]);
		}
	}
}
