import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1463 {

	static int[] memo;

	static int divide(int x) {

		if (memo[x] == 0&&x>1) {

			if (x%3 == 0 && x%2 == 0) {

				memo[x] = Math.min(divide(x / 3), Math.min(divide(x / 2), divide(x - 1))) + 1;

			}

			else if (x%3 == 0) {

				memo[x] = Math.min(divide(x / 3), divide(x - 1)) + 1;

			}

			else if (x%2 == 0) {

				memo[x] = Math.min(divide(x / 2), divide(x - 1)) + 1;

			}

			else memo[x] = divide(x - 1) + 1;
		}

		return memo[x];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.valueOf(br.readLine());

		memo = new int[x + 1];

		memo[0] = 0;

		memo[1] = 0;

		System.out.println(divide(x));

	}

}
