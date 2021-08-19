
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no10830 {

	static int N;
	static long B;

	static int[][] matrix;
	static int[][] rm;

	static int[][] divq(int[][] mat, long b) {

		if (b == 1L) {

			int[][] aftermat = new int[N][N];

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					aftermat[i][j] = mat[i][j]%1000;

				}

			}

			return aftermat;

		}

		if (b % 2 == 0) {

			return multi(divq(mat, b / 2));

		}

		int[][] multimat = multi(divq(mat, b / 2));
		int[][] aftermat = new int[N][N];

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				for (int k = 0; k < N; k++) {

					aftermat[i][j] += (multimat[i][k] * mat[k][j]);

				}

				aftermat[i][j] %= 1000;

			}

		}

		return aftermat;

	}

	static int[][] multi(int[][] mat) {

		int[][] aftermat = new int[N][N];

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				for (int k = 0; k < N; k++) {

					aftermat[i][j] += mat[i][k] * mat[k][j];

				}

				aftermat[i][j] %= 1000;

			}

		}

		return aftermat;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());

		matrix = new int[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {

				matrix[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		rm = divq(matrix, B);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				sb.append(rm[i][j]).append(" ");

			}

			sb.append("\n");
		}

		System.out.println(sb);

	}

}
