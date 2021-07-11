package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5432 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for(int tc=1;tc<=T;tc++) {
			String str = input.readLine();

			int pipe=0;
			int sum=0;
			for(int i=0;i<str.length();i++) {
				if (str.charAt(i) == '(') { //괄호 왼쪽
					pipe++;
				}else{ //괄호 오른쪽
					if(str.charAt(i-1)=='(') { // 레이저
						pipe--;
						if(pipe>0)sum+=pipe;
					}
					else { // 파이프 끝
						sum++;
						pipe--;
					}
				}
			}
			
			output.append("#").append(tc).append(" ").append(sum).append("\n");
		}//tc
		System.out.println(output);
	}//main

}
