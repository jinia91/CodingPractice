import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1904 {

	static int[] memo;

	static int dp(int x) {

		if (memo[x] == 0) {

			memo[x] = (dp(x - 1) + dp(x - 2))%15746;

		}

		return memo[x];

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		memo = new int[N+1];
		
		memo[1] = 1;
		if(N>1) memo[2] = 2;
		
		
		System.out.println(dp(N));
		
		
		
	}

}
