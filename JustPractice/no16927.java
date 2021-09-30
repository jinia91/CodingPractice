package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16927 {

	static int[][] arr;
	static int[][] tmp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long R = Long.parseLong(st.nextToken());

		arr = new int[N][M];
		tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		int min = Math.min(N,M);
		
		for (int dept = 1; dept <= min / 2; dept++) {

			long r = R % (2 * ((N - 1-(dept-1)*2) + (M - 1-(dept-1)*2)));

			while (r-- > 0) {
				spin(N, M, dept);
				swap(N,M, dept);
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

	private static void swap(int N, int M, int dept) {

		for (int j = M - dept; j >= dept; j--) {
			arr[dept - 1][j - 1] = tmp[dept-1][j - 1];
		}

		// v
		for (int i = dept - 1; i < N - dept; i++) {
			arr[i+1][dept - 1] = tmp[i + 1][dept-1];
		}

		// ->
		for (int j = dept - 1; j < M - dept; j++) {
			arr[N - dept][j+1] = tmp[N - dept][j + 1];
		}

		// ^
		for (int i = N - dept; i >= dept; i--) {
			arr[i-1][M - dept] = tmp[i - 1][M - dept];
		}
	}

	private static void spin(int N, int M, int dept) {

		// <-
		for (int j = M - dept; j >= dept; j--) {
			tmp[dept-1][j - 1] = arr[dept - 1][j];x
		}

		// v
		for (int i = dept - 1; i < N - dept; i++) {
			tmp[i + 1][dept-1] = arr[i][dept - 1];
		}

		// ->
		for (int j = dept - 1; j < M - dept; j++) {
			tmp[N - dept][j + 1] = arr[N - dept][j];
		}

		// ^
		for (int i = N - dept; i >= dept; i--) {
			tmp[i - 1][M - dept] = arr[i][M - dept];
		}
	}

}
