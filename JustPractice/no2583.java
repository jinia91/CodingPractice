package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no2583 {

	static StringTokenizer st;

	static int N, M, K;
	static int cnt;

	static StringBuilder sb = new StringBuilder();
	
	static int[][] board;
	static int[] dx = {0, 1, 0 ,-1};
	static int[] dy = {1, 0, -1 ,0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[M][N];

		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			for (int x = a; x < c; x++) {

				for (int y = b; y < d; y++) {

					board[x][y] = 1;

				}

			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i< M; i++) {
			
			for(int j = 0; j<N; j++) {
				
				dfs(i,j);	
				
				if(cnt>0) {
					pq.add(cnt);
				}
				cnt =0;
			}
			
		}
		System.out.println(pq.size());
		
		while(!pq.isEmpty()) {
			
			sb.append(pq.poll()+" ");
			
		}
		System.out.println(sb);

	}

	private static void dfs(int i, int j) {

		if(i<0||j<0||i>=M||j>=N) return;
		

		if(board[i][j] == 0) {

			board[i][j] = 1;
			cnt++;
			
			for(int k=0; k<4; k++) {
				
				dfs(i+dx[k], j+dy[k]);
						
			}
			
		}
		
	}

}
