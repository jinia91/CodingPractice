package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1956 {

	static int[][] memo;

	static int V, E;
	static int INF = 10001;
	static int min = Integer.MAX_VALUE;

	static void bf() {

		for (int k = 1; k < V + 1; k++) {
			for (int i = 0; i < V + 1; i++) {
				for (int j = 0; j < V + 1; j++) {

					memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k][j]);

				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.valueOf(st.nextToken());
		E = Integer.valueOf(st.nextToken());
		
		memo = new int[V+1][V+1];
		
		for(int i =0; i<V+1; i++) {
			for(int j =0; j<V+1; j++) {
			
				memo[i][j] = INF;
				
			}
		}
			
		
		for(int i = 0; i<E; i++) {
		
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
				
			memo[a][b] = c;
			
		}
		
		bf();
		
		for(int i = 0; i<V+1; i++) {
		
			min = Math.min(memo[i][i], min);
			
		}
		
		if(min == INF) System.out.println(-1);
		
		else System.out.println(min);
		
	}

}
