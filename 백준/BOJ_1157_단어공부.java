package String;
import java.util.*;

public class BOJ_1157_단어공부 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		// 65 ~ 90 , 97 ~ 122
		int[] arr = new int[150];
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)]++;
		}
		
		for(int i=0;i<26;i++) {
			arr[i]+=arr[i+65];
			arr[i]+=arr[i+97];
		}
		
		int idx = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<26;i++) {
			if(arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		int cnt = 0;
		for(int i=0;i<26;i++) {
			if(max == arr[i]) cnt++;
		}

		if(cnt >= 2) System.out.println("?");
		else System.out.println((char)(idx+65));
		
	}

}
