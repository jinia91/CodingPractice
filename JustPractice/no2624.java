package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no2624 {

	static int T, k, answer;

	static StringTokenizer st;

	static int[][] coin;
	static int[][] memo;

	static int dfs(int countMoney, int dept) {

		
		if (countMoney == T) {
//			answer++;
			return 1;
		}
		if (dept == k)
			return 0;
		if (countMoney > T)
			return 0;
		
		if(memo[dept][countMoney] != -1) {
			return memo[dept][countMoney];
		}

		int rs = 0;
		for (int n = 0; n <= coin[dept][1]; n++) {
			rs += dfs(countMoney + coin[dept][0] * n, dept + 1);
		}
		
		return memo[dept][countMoney] = rs; 
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		k = Integer.parseInt(br.readLine());

		coin = new int[k][2];

		for (int i = 0; i < k; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			coin[i][0] = Integer.parseInt(st.nextToken());
			coin[i][1] = Integer.parseInt(st.nextToken());

		}
		
		
		memo = new int[k][T+1];
		for(int i=0; i<k; i++) {
			for(int j=0; j<T; j++) {
				memo[i][j] = -1;
			}
		}

		System.out.println(dfs(0,0));

	}

}
