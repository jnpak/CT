package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(input.readLine());
			String str = input.readLine();
			Stack<Character> st = new Stack();
			int result = 1;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ')') {
					if (!st.empty()&&st.peek() == '(') {
						st.pop();
					}else {result=0;break;}
				} else if (str.charAt(i) == ']') {
					if (!st.empty()&&st.peek() == '[') {
						st.pop();
					}else {result=0;break;}

				} else if (str.charAt(i) == '}') {
					if (!st.empty()&&st.peek() == '{') {
						st.pop();
					}else {result=0;break;}

				} else if (str.charAt(i) == '>') {
					if (!st.empty()&&st.peek()== '<') {
						st.pop();
					}else {result=0;break;}
				}else {
					st.push(str.charAt(i));
				}
			}
			output.append("#").append(tc).append(" ").append(result).append("\n");
		} // tc
		System.out.println(output);
	}// main

}
