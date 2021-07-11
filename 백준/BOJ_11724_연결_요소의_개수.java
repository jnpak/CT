package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_����_�����_���� {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	
	static int N,M;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken()); //���
		M = Integer.parseInt(st.nextToken()); //����
		
		arr =  new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(input.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	arr[x].add(y);
        	arr[y].add(x);
    	}
		//System.out.println(Arrays.deepToString(arr));
		
		int cnt=0;
		//System.out.println(arr[1].get(0));
		for(int i=1;i<=N;i++) {
			if(!visit[i]) { //visit[i]�� false �̸� DFS ����
				DFS(i);     //�����Ҹ� ��� �湮�ϰ�
				cnt++;		//cnt 1 ����
			}
		}
		System.out.println(cnt);
		
	}//main
	public static void DFS(int start) {
		visit[start]=true; // start �湮
		
//		for(int i=0;i<arr[start].size();i++) {
//			if(!visit[arr[start].get(i)]) {
//				DFS(i);
//			}
//		}
		ArrayList<Integer> nodes = arr[start];
		for(Integer node : nodes) { //�迭 start ��° ��ҿ� ����� ������
			if(!visit[node]) {		// ���
				DFS(node);			// �湮
			}
		}
	}
}
