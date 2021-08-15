import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2579 {

	static int[] memo;

	static int[] stair;

	static int dp(int x) {
		
		if (x == 0) return 0;

		if (memo[x] == 0) {
			memo[x] = Math.max((dp(x - 2) + stair[x]), (dp(x - 3) + stair[x - 1] + stair[x]));
		}

		return memo[x];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		memo = new int[N + 1];
		stair = new int[N + 1];

		
		for (int i = 1; i < N + 1; i++) {

			stair[i] = Integer.parseInt(br.readLine());

		}
		
		
		
		memo[1] = stair[1];
		
		if(N>1) memo[2] = stair[1] + stair[2];

		
		System.out.println(dp(N));

	}

}
