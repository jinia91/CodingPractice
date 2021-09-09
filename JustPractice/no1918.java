package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class no1918 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] cArr = br.readLine().toCharArray();

		StringBuilder answer = new StringBuilder();
		Stack<Character> oper = new Stack<>();

		for (char x : cArr) {

			boolean flag =false;
			
			if ('A' <= x && x <= 'Z')
				answer.append(x);

			else if (x == '(') {
				oper.add(x);
			}

			else if (x == '+' || x == '-') {

				while (!oper.isEmpty()) {
					if (oper.peek() == '(') {
						oper.add(x);
						flag = true;
						break;
					}
					answer.append(oper.pop());
				}
				
				if(!flag) oper.add(x);

			}

			else if (x == '*' || x == '/') {
				while (!oper.isEmpty()) {
					if (oper.peek() != '*' && oper.peek() != '/') {
						oper.add(x);
						flag = true;
						break;
					}
					answer.append(oper.pop());
				}

				if(!flag) oper.add(x);
				
			}

			else if (x == ')') {
				char pop = ' ';
				while ((pop = oper.pop()) != '(') {
					answer.append(pop);
				}
			}

		}

		while (!oper.isEmpty())

		{
			answer.append(oper.pop());
		}

		System.out.println(answer);

	}

}
