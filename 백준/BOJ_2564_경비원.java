import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2564_경비원 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(input.readLine());
		int[] values = new int[n+1];
		for(int i=0;i<=n;i++) {
			st = new StringTokenizer(input.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				values[i] = value;
				break;
			case 2:
				values[i] = 2 * width + height - value;
				break;
			case 3:
				values[i] = 2 * (width + height) - value;
				break;
			case 4:
				values[i] = width + value;
				break;
			}
		}
		
		int sum=0;
		for(int i=0;i<n;i++) {
			int dist = Math.abs(values[n] - values[i]);
			sum += (dist > (width + height)) ? 2 * (width + height) - dist : dist;
		}
		System.out.println(sum);

	}

}
