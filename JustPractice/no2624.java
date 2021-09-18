package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no2624 {

	static int T, N;

	static StringTokenizer st;

	static ArrayList<Integer> coin = new ArrayList<>();

	static int[][] memo;

	static void dp() {
		
		for(int t = 1; t<T; t++) {
			
			boolean flag = false;
			
			for(int n = 1; n<coin.size(); n++) {
	
				if(coin.get(n) == coin.get(n-1)) flag = true;

				if(t == coin.get(n)) {
					
					if(!flag) {	
						memo[t][n]++;
					}
					
					else
						memo[t][n] = memo[t][n-1];
					
				}
				
				if(t>coin.get(n)) {

					if(!flag) {
						memo[t][n] = memo[t-coin.get(n)][n-1] + memo[t][n-1];
					}
					else {
						
						
					}
					
				}
				
			}
			
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		N = Integer.parseInt(br.readLine());

		coin.add(0);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int c = Integer.parseInt(st.nextToken());
			int cNum = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cNum; j++) {
				coin.add(c);
			}

		}

		memo = new int[T + 1][coin.size()];

	}

}
