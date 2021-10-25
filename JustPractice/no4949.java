package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class no4949 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = null;
		while (!(input = br.readLine()).equals(".")) {

			Stack<Character> st = new Stack<>();

			boolean flag = true;
			
			for (int i = 0; i < input.length(); i++) {

				char check = input.charAt(i);

				if (check == '(' || check == '[') {

					st.add(check);

				}

				else if (check == ')') {

					if (st.isEmpty() || st.peek() != '(') {
			
						sb.append("no\n");
						flag = false;
						break;
					
					}
					
					else {
						st.pop();
					}

				}
				
				else if (check == ']') {

					if (st.isEmpty() || st.peek() != '[') {
						
						sb.append("no\n");
						flag = false;
						break;
					
					}

					else {
						st.pop();
					}

					
				}

			}
			
			if(flag)
				if(!st.isEmpty())
					sb.append("no\n");

				else 
					sb.append("yes\n");

		}

		System.out.println(sb);
		
	}

}
