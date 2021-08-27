package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no12852 {

	static int[] memo;
	static StringBuilder sb = new StringBuilder();

	static int divide(int x) {

		if (memo[x] == 0 && x > 1) {

			if (x % 3 == 0 && x % 2 == 0) {

				memo[x] = Math.min(divide(x / 3), Math.min(divide(x / 2), divide(x - 1))) + 1;
			}

			else if (x % 3 == 0) {

				memo[x] = Math.min(divide(x / 3), divide(x - 1)) + 1;
			}

			else if (x % 2 == 0) {

				memo[x] = Math.min(divide(x / 2), divide(x - 1)) + 1;
			}

			else {
				memo[x] = divide(x - 1) + 1;
			}
		}

		return memo[x];
	}

	static void backtracking(int x) {

		if(x==1) {
			return;
		}
		
		sb.append(x).append(" ");

		int a = x / 3;
		int b = x / 2;
		int c = x - 1;
		
		

		if (x % 3 == 0 && x % 2 == 0) {

			int min = Math.min(divide(x / 3), Math.min(divide(x / 2), divide(x - 1)));

			if (min == memo[a])
				backtracking(a);
			else if (min == memo[b])
				backtracking(b);
			else if (min == memo[c])
				backtracking(c);

		}

		else if (x % 3 == 0) {

			int min = Math.min(divide(x / 3), divide(x - 1));

			if (min == memo[a])
				backtracking(a);
			else if (min == memo[c])
				backtracking(c);
		}

		else if (x % 2 == 0) {

			int min = Math.min(divide(x / 2), divide(x - 1));

			if (min == memo[b])
				backtracking(b);
			else if (min == memo[c])
				backtracking(c);
		}

		else {
			backtracking(x-1);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.valueOf(br.readLine());

		memo = new int[x + 1];

		memo[0] = 0;

		memo[1] = 0;
		
	

		System.out.println(divide(x));
		backtracking(x);
		sb.append(1);
		System.out.println(sb);

	}

}
