package coding;

import java.util.Scanner;

public class BOJ_17478 {

	static int cnt = 0;
	static void recur(int n) {
		if (n < 0) {
			if(cnt>1) {
				for(int i=1;i<cnt;i++) System.out.print("----");
			}
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
		} else {
			cnt++;
			if(cnt==0)System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
			if(cnt>1) {
				for(int i=1;i<cnt;i++) System.out.print("----");
			}
			System.out.println("\"����Լ��� ������?\"");
			if(cnt>1) {
				for(int i=1;i<cnt;i++) System.out.print("----");
			}
			System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
			if(cnt>1) {
				for(int i=1;i<cnt;i++) System.out.print("----");
			}
			System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
			if(cnt>1) {
				for(int i=1;i<cnt;i++) System.out.print("----");
			}
			System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
			recur(n - 1);
			
			for(int i=cnt;i<0;i--) System.out.print("----");
			System.out.println("��� �亯�Ͽ���.");
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		recur(sc.nextInt());
	}

}
