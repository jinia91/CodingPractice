package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no12865 {

	static int N, K;
	static int[] W, V;
	static StringTokenizer st;

	static int[][] memo;

	static void dp() {

		for (int i = 0; i < K + 1; i++) {

			for (int j = 0; j < N; j++) {

				if (i == 0)
					continue;

				// 가방에 j번 물건 넣을수 있는 경우
				if (i >= W[j]) {

					if(j != 0)
					memo[j][i] = Math.max(memo[j - 1][i], memo[j - 1][i - W[j]] + V[j]);

					else memo[j][i] = V[j];

				}

				// j번 물건 못넣는 경우
				else {
					if(j != 0)
					memo[j][i] = memo[j - 1][i];

					else memo[j][i] = 0;
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		W = new int[N];
		V = new int[N];

		memo = new int[N][K + 1];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());

		}
		
		dp();
		
		System.out.println(memo[N-1][K]);

	}

}
