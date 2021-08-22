import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1149 {

	static int[][] memo;
	static int[][] house;
	static StringTokenizer st;

	static int dp(int a, int b) {

		if (a == 0)
			return memo[a][b];

		if (memo[a][b] == 0) {

			switch (b) {

			case 0:

				memo[a][b] = Math.min(dp(a - 1, b + 1), dp(a - 1, b + 2)) + house[a][b];

				break;
			case 1:

				memo[a][b] = Math.min(dp(a - 1, b - 1), dp(a - 1, b + 1)) + house[a][b];

				break;
			case 2:

				memo[a][b] = Math.min(dp(a - 1, b - 2), dp(a - 1, b - 1)) + house[a][b];

				break;

			}

		}

		return memo[a][b];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		memo = new int[N][3];
		house = new int[N][3];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {

				house[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		for (int i = 0; i < 3; i++) {

			memo[0][i] = house[0][i];

		}

		System.out.println(Math.min(dp(N-1, 0), Math.min(dp(N-1, 1), dp(N-1, 2))));
		
		
	}

}
