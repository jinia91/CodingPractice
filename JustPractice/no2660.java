package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no2660 {

	static StringTokenizer st;
	static int[][] memo;
	static int[] max;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		memo = new int[N + 1][N + 1];
		max = new int[N+1];
		
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {

				
				memo[i][j] = 100;

				if(i==j) memo[i][j] = 0;
			}
		
		}

		while (true) {

			st = new StringTokenizer(br.readLine(), " ");

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == -1 && B == -1)
				break;

			memo[A][B] = 1;
			memo[B][A] = 1;

		}

		// 플로이드 와셜
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k][j]);
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {

				max[i] = Math.max(memo[i][j], max[i]);
			}
		}
		

		for(int i =1; i< N+1; i++) {
			min = Math.min(min, max[i]);
		}


		for (int i = 1; i < N + 1; i++) {
			if (max[i] == min)
				list.add(i);
			
		}


		StringBuilder sb = new StringBuilder();
		
		sb.append(min).append(" ").append(list.size()).append("\n");
		
		for(int i =0; i< list.size();i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
