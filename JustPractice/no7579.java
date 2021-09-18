package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no7579 {

	static int N, M, vSum;
	static int[] W, V;
	static StringTokenizer st;

	static int[][] memo;

	static int dp() {

		while (true) {

			for (int n = 0; n < N; n++) {

				if (V[n] <= vSum) {

					if (n != 0)
						memo[vSum][n] = Math.max(memo[vSum][n - 1], W[n] + memo[vSum - V[n]][n-1]);

					else
						memo[vSum][n] = W[n];
				}

				else {
					if (n != 0)
						memo[vSum][n] = memo[vSum][n - 1];
					else
						memo[vSum][n] = 0;
				}

				if (memo[vSum][n] >= M) {
					return vSum;
				}
			}
			vSum++;
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		W = new int[N];
		V = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i<N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i<N; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		memo = new int[10001][N];
		
		System.out.println(dp());

	}

}
