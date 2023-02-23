import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static ArrayList<Character> list = new ArrayList<>();
	static char[] target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			list.add(st.nextToken().charAt(0));
		}
		target = new char[L];
		Collections.sort(list);		// list 정렬

		comb(0, 0);
		System.out.println(sb);
	}
	static StringBuilder sb = new StringBuilder();
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == target.length) {	// 뽑은 조합에서 자음,모음수가 조건을 만족하는지 확인
			if (check_tgt()) {			// 만족한다면 답 sb에 더하기
				for (Character c : target) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = srcIdx; i < list.size(); i++) {
			target[tgtIdx] = list.get(i);
			comb(i + 1, tgtIdx + 1);
		}
	}

	static boolean check_tgt() {
		int cnt_v = 0; // 모음
		int cnt_c = 0; // 자음
		for (Character c : target) {
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				cnt_v++;
				break;
			default:
				cnt_c++;
			}
			if(cnt_v >= 1 && cnt_c >=2) return true;	// 모음 개수가 1, 자음 개수가 2 이상이면 true
		}
		return false;		// 아니면 false
	}
}
