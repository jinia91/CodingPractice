import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no9095 {

	static int[] memo = new int[11];

	static int dp(int x) {

		if (memo[x] == 0 && x > 3) {

			memo[x] = dp(x - 1) + dp(x - 2) + dp(x - 3);

		}

		return memo[x];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		memo[0] = 0;
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		
		
		for (int i = 0; i < N; i++) {

			int x = Integer.valueOf(br.readLine());
			sb.append(dp(x)).append("\n");

		}
		
		System.out.println(sb);

	}

}
