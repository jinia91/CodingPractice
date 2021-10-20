package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no9465 {

	static int N;

	static int[][] stiker;
	static int[][] dp;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			stiker = new int[2][N];
			dp = new int[2][N];

			for (int c = 0; c < 2; c++) {

				st = new StringTokenizer(br.readLine(), " ");

				for (int n = 0; n < N; n++) {

					stiker[c][n] = Integer.parseInt(st.nextToken());

				}

			}

			dp[0][0] = stiker[0][0];
			dp[1][0] = stiker[1][0];

			if(N>1) {
			
			dp[0][1] = stiker[1][0] + stiker[0][1];
			dp[1][1] = stiker[0][0] + stiker[1][1];

			}
			
			for (int i = 2; i < N; i++) {

				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stiker[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stiker[1][i];

			}

			System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		}
	}

}
