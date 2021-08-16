import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1932 {

	static int[][] memo;
	static int[][] triangle;
	static StringTokenizer st;
	static int N;

	static int dp(int x, int y) {

		if(x == N-1) return memo[x][y];
		
		if (memo[x][y] == 0) {

			memo[x][y] = Math.max(dp(x + 1, y)+triangle[x][y], dp(x + 1, y + 1)+triangle[x][y]);

		}

		return memo[x][y];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		memo = new int[N][N];
		triangle = new int[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < i + 1; j++) {

				triangle[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		for (int i = 0; i < N; i++) {

			memo[N - 1][i] = triangle[N - 1][i];

		}
		
		
		
		System.out.println(dp(0,0));

	}

}
