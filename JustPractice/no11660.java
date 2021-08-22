import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no11660 {

	static int[][] board;
	static int[][] memo;
	static int N, M, a, b, c, d;

	static int calcul(int a, int b, int c, int d) {

		return memo[c][d] -memo[a-1][d]-memo[c][b-1]+memo[a-1][b-1];
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N + 1][N + 1];
		memo = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 1; j < N + 1; j++) {

				board[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		for (int i = 1; i < N + 1; i++) {

			for (int j = 1; j < N + 1; j++) {

				memo[i][j] = memo[i][j - 1] + memo[i - 1][j] - memo[i - 1][j - 1] + board[i][j];

			}

		}
		
		

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			sb.append(calcul(a, b, c, d)).append("\n");

		}

		System.out.println(sb);

	}

}
