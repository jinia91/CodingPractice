package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2740 {

	static int N, M, K;
	static StringTokenizer st;

	static int[][] arrA;
	static int[][] arrB;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arrA = new int[N][M];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {

				arrA[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		st = new StringTokenizer(br.readLine(), " ");

		Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arrB = new int[M][K];


		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < K; j++) {


				arrB[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		int[][] ans = cal();

		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< N; i++) {
			
			for(int j =0; j< K; j++) {
		

				sb.append(ans[i][j]).append(" ");
				
				
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
		
	}

	private static int[][] cal() {

		int[][] ans = new int[N][K];

		for (int i = 0; i < N; i++) {

			for (int k = 0; k < K; k++) {
				
				for (int j = 0; j < M; j++) {

					ans[i][k] += arrA[i][j] * arrB[j][k];

				}

			}

		}

		return ans;
	}

}
