import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_계란으로_계란치기 {
	static class EGG {
		int durability, weight;

		public EGG(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}
	}

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static int max = Integer.MIN_VALUE;
	static EGG[] EGGS;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		EGGS = new EGG[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			EGGS[i] = new EGG(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Recursion(0);
		System.out.println(max);
	}

	// 0~N-1
	private static void Recursion(int num) {
		if (num == N) {
			int breakEgg = 0;
			// 깨진 계란 갯수 세기
			for (int i = 0; i < N; i++) {
				if (EGGS[i].durability <= 0)
					breakEgg++;
			}

			// 최대값 갱신
			max = Math.max(max, breakEgg);
			return;
		}

		for (int i = 0; i < N; i++) {
			// 손에 쥔 계란 내구도 > 0 && 손에 쥔 계란과 칠 계란은 같지않아야함 && 칠 계란 내구도 >0
			if (EGGS[num].durability > 0 && num != i && EGGS[i].durability > 0) {
				EGGS[num].durability -= EGGS[i].weight;
				EGGS[i].durability -= EGGS[num].weight;
				System.out.println("EGGS[" + num + "].durability : " + EGGS[num].durability);
				Recursion(num + 1);
				EGGS[num].durability += EGGS[i].weight;
				EGGS[i].durability += EGGS[num].weight;
			}
		}

	}

}
