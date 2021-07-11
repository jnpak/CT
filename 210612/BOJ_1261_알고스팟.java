import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M,map[][];
	static boolean[][] visited;
	static int min=Integer.MAX_VALUE;
	
	static class spot implements Comparable<spot>{
		int x,y,cnt;
		public spot(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		//cnt가 적은 순으로 정렬
		@Override
		public int compareTo(spot o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String str=input.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=str.charAt(j) - '0';
			}
		}
		//벽을 부순 카운트가 적은 순으로 BFS 진입
		PriorityQueue<spot> pq = new PriorityQueue<spot>();
		pq.add(new spot(0,0,0));
		visited[0][0]=true;
		
		while(!pq.isEmpty()) {
			spot cur = pq.poll();
			// 목적지에 도달하면 break
			if(cur.x == N-1 && cur.y == M-1) {
				min = cur.cnt;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				
				if(visited[nx][ny]) continue;
				
				visited[nx][ny]= true;
				
				if(map[nx][ny]==0) pq.add(new spot(nx,ny,cur.cnt));
				else pq.add(new spot(nx,ny,cur.cnt+1));
			}
		}
		System.out.println(min);
	}
}
