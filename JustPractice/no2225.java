package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2225 {

	static int K, N;
	static long[][] memo;

	static void dp() {
		for (int i = 3; i <= K; i++) {

			for (int j = 0; j <= N; j++) {

				for (int k = 0; k <= j; k++) {

					memo[i][j] += memo[i - 1][j - k]%1000000000;

				}

			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		memo = new long[K + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {

			memo[1][i] = 1;
		}

		if (K > 1) {
			for (int i = 0; i < N + 1; i++) {

				memo[2][i] = i + 1;
			}
		}

		dp();

		System.out.println(memo[K][N]%1000000000);

	}

}
