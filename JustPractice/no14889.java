package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no14889 {

	static int[][] board;

	static StringTokenizer st;

	static int N;
	
	static int min = Integer.MAX_VALUE;

	static boolean[] checked;

	static List<Integer> teamList = new ArrayList<>();
	static List<Integer> teamListB = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		checked = new boolean[N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				board[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		dfs(0,0);
		
		System.out.println(min);

	}

	static void dfs(int d, int start) {

		if (teamList.size() == N / 2) {

			int scoreA = 0;

			for (int i = 0; i < teamList.size(); i++) {

				for (int j = 0; j < teamList.size(); j++) {

					if (i == j)
						continue;

					scoreA += board[teamList.get(i)][teamList.get(j)];

				}

			}
			
			for (int i = 0; i < N; i++) {

				boolean flag = false;

				for (int j : teamList) {

					if (i == j) {
						flag = true;
						break;
					}
				
				}
				
				if(flag) continue;
				
				teamListB.add(i);
				
			}
			


			int scoreB = 0;

			for (int i = 0; i < teamListB.size(); i++) {

				for (int j = 0; j < teamListB.size(); j++) {

					if (i == j)
						continue;

					scoreB += board[teamListB.get(i)][teamListB.get(j)];

				}

			}


			min = Math.min(Math.abs(scoreA-scoreB), min);
			teamListB.clear();
			return;
			
		}

		for (int i = start; i < N; i++) {

			if (!checked[i]) {

				teamList.add(i);
				checked[i] = true;

				dfs(d + 1, i + 1);
				checked[i] = false;
				teamList.remove(teamList.size()-1);
				
			}

		}

	}

}
