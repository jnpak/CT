import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	static int F, S, G, U, D;
	static int[] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		F = Integer.parseInt(st.nextToken()); // 전체층수
		S = Integer.parseInt(st.nextToken()); // 현재위치
		G = Integer.parseInt(st.nextToken()); // 목적지
		U = Integer.parseInt(st.nextToken()); // 위로 칸수
		D = Integer.parseInt(st.nextToken()); // 아래로 칸수

		map = new int[F + 1];
		if (S == G) {
			System.out.println(map[G]);
		}
		BFS();
		if (map[G] == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(map[G]);
		}
	}

	private static void BFS() {

		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		while (!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println(cur+" " + map[cur]);
			//현재위치가 목적지보다 아래일 경우
			if (cur < G) {
				//현재위치에서 올라갈경우 건물범위를 벗어나는 경우
				if(cur+U >F) {
					if(map[cur - D] != 0) break;
					map[cur -D] = map[cur] + 1;
					q.add(cur - D);
				}else {
					
					if (map[cur + U] != 0) break;
					map[cur + U] = map[cur] + 1;
					q.add(cur + U);
					
				}
			//현재위치가 목적지보다 위일 경우
			} else if (cur > G) {
				//현재위치에서 내려갈경우 건물범위를 벗어나는 경우
				if(cur-D <1) {
					if(map[cur+ U]!=0)break;
					map[cur+U] = map[cur] + 1;
					q.add(cur+U);
				}else {
					
				if (map[cur - D] != 0) break;
				map[cur - D] = map[cur] + 1;
				q.add(cur - D);
				
				}
			} else {
				break;
			}
		}
	}
}
