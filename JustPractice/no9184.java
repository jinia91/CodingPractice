package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no9184 {

	static int[][][] dp = new int[21][21][21];
	static final int INF = Integer.MAX_VALUE;
	static StringTokenizer st;

	static int w(int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			int rs = w(20, 20, 20);
			
			return rs;
		} else if (a < b && b < c) {
			if (dp[a][b][c] != INF) {
				return dp[a][b][c];
			}
			int rs = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			dp[a][b][c] = rs;
			return rs;
		} else {
			if (dp[a][b][c] != INF) {
				return dp[a][b][c];
			}
			int rs = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
			dp[a][b][c] = rs;
			return rs;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = 0;
		int b = 0;
		int c = 0;

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<21; i++) {
			for(int j =0; j<21; j++) {
				for(int k = 0; k < 21; k++) {
					dp[i][j][k] = INF;
				}
			}
		}

		while (true) {


			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1)
				break;

			
			
			sb.append("w("+a+", "+b+", "+c+") = ").append(w(a, b, c)).append("\n");

		}

		System.out.println(sb);

	}

}
