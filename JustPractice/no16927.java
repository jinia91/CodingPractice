package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16927 {

	static int[][] arr;
	static int[][][] tmp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long R = Long.parseLong(st.nextToken());

		arr = new int[N][M];
		tmp = new int[2*(N-1)+2*(M-1)][N][M];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		for (int r = 0; r < 2*(N-1)+2*(M-1); r++) {

			// <-- 이동
			for (int i = 0; i < N / 2; i++) {
				for (int j = M - (i + 1); j >= (i + 1); j--) {
					tmp[r][i][j - 1]= arr[i][j] ;
				}
			}
			// ^ 이동
			for (int j = M - 1; j >= M / 2; j--) {
				for (int i = 1-j+(M-1); i < N + j - (M - 1); i++) {

					tmp[r][i - 1][j] = arr[i][j];

				}
			}

			// --> 이동
			for (int i = N - 1; i >= N / 2; i--) {
				for (int j = (N - 1) - i; j < M + i - N; j++) {
					tmp[r][i][j + 1] = arr[i][j];
				}
			}

			// 아래 이동
			for (int j = 0; j < M / 2; j++) {
				for (int i = j; i < N - j - 1; i++) {
					tmp[r][i + 1][j] =arr[i][j];
				}
			}
	
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < M; j++) {

					arr[i][j] = tmp[r][i][j];

				}

			}

			
		}
		
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				arr[i][j] = tmp[(int)((R-1)%(2*(N-1)+2*(M-1)))][i][j];
				
			}

		}

		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				sb.append(arr[i][j]).append(" ");

			}
			
			sb.append("\n");

		}
		
		System.out.println(sb);

	}

}
