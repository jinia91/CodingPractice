package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no17404 {

	static int N;
	static int[][] memo;
	static int[][] house;
	static StringTokenizer st;

	static int dp(int a, int b, int c) {
		
		if(a==N-1) memo = new int[N][3];

		if (a == 0)
			return memo[a][b];

		if (memo[a][b] == 0) {

			if (a == 1) {
				if (b == 0 && c == 0) {

					memo[a][b] = Math.min(house[0][1], house[0][2]) + house[a][b];

				} else if (b == 0 && c == 1) {

					memo[a][b] = house[0][2] + house[a][b];

				} else if (b == 0 && c == 2) {

					memo[a][b] = house[0][1] + house[a][b];

				} else if (b == 1 && c == 0) {

					memo[a][b] = house[0][2] + house[a][b];

				} else if (b == 1 && c == 1) {

					memo[a][b] = Math.min(house[0][0], house[0][2]) + house[a][b];

				} else if (b == 1 && c == 2) {

					memo[a][b] = house[0][0] + house[a][b];

				} else if (b == 2 && c == 0) {

					memo[a][b] = house[0][1] + house[a][b];

				} else if (b == 2 && c == 1) {

					memo[a][b] = house[0][0] + house[a][b];

				} else if (b == 2 && c == 2) {

					memo[a][b] = Math.min(house[0][1], house[0][0]) + house[a][b];
				}
			}

			else {
				switch (b) {

				case 0:
					memo[a][b] = Math.min(dp(a - 1, b + 1, c), dp(a - 1, b + 2, c)) + house[a][b];
					break;
				case 1:
					memo[a][b] = Math.min(dp(a - 1, b - 1, c), dp(a - 1, b + 1, c)) + house[a][b];
					break;
				case 2:
					memo[a][b] = Math.min(dp(a - 1, b - 2, c), dp(a - 1, b - 1, c)) + house[a][b];
					break;
				}
			}
		}

		return memo[a][b];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		memo = new int[N][3];
		house = new int[N][3];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {

				house[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
	
		System.out.println(Math.min(dp(N - 1, 0, 0), Math.min(dp(N - 1, 1, 1), dp(N - 1, 2, 2))));

	}

}
