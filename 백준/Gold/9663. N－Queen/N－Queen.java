import java.util.Scanner;

public class Main {
	static int N, col[], answer;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		
		setQueen(1);
		System.out.println(answer);
	}

	private static void setQueen(int rowNo) { // rowNo : 놓으려고 하는 퀸의 행 번호
		if (!isAuailable(rowNo - 1)) return;

		if (rowNo > N) {
			answer += 1;
			return;
		}

		for (int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueen(rowNo + 1);
		}

	}

	private static boolean isAuailable(int rowNo) {
		for (int k = 1; k < rowNo; k++) { // k : 비교대산 queen의 행
			if (col[k] == col[rowNo] || // 같은 열에 있어용
					Math.abs(col[k] - col[rowNo]) == rowNo - k) // 열차이, 행차이가 같으면 같은 대각선상
				return false;
		}
		return true;
	}

}