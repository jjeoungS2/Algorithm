import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Idx> Home;
	static ArrayList<Idx> Ck;
	static int[][] tgt;
	static int result_min = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Home = new ArrayList<>();
		Ck = new ArrayList<>();
		tgt = new int[M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1)
					Home.add(new Idx(i, j));
				else if (num == 2)
					Ck.add(new Idx(i, j));
			}
		}

		comb(0, 0);
		System.out.println(result_min);

	}

	static void check() {
		int min;
		int sum = 0;
		for (Idx idx : Home) {
			min = 10000000;
			for (int i = 0; i < tgt.length; i++) {
				min = Math.min(Math.abs(idx.x - tgt[i][0]) + Math.abs(idx.y - tgt[i][1]), min);
			}
			sum += min;
		}
		result_min = Math.min(sum, result_min);
	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			check();
			return;
		}

		for (int i = srcIdx; i < Ck.size(); i++) {
			tgt[tgtIdx][0] = Ck.get(i).x;
			tgt[tgtIdx][1] = Ck.get(i).y;
			comb(i + 1, tgtIdx + 1);
		}
	}
}

class Idx {
	int x;
	int y;

	Idx(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
