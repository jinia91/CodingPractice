package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no11659 {

	static StringTokenizer st;
	static int N, M;

	static int[] memo;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		memo = new int[N + 1];
		memo[0] = 0;
		for (int i = 1; i < N + 1; i++) {
			memo[i] = memo[i - 1] + Integer.parseInt(st.nextToken());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			System.out.println(memo[e] - memo[s - 1]);
		}
	}

}
