package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2580 {

	static int[][] sdoku = new int[9][9];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 9; j++) {

				sdoku[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		dfs(0, 0);


	}

	private static void dfs(int i, int j) {

		
		if(j == 9) {
			dfs(i+1, 0);
		}
		
		if(i == 9) {
			
			StringBuilder sb = new StringBuilder();

			for (int I = 0; I < 9; I++) {

				for (int J = 0; J < 9; J++) {

					sb.append(sdoku[I][J]).append(" ");

				}

				sb.append("\n");
			}

			System.out.println(sb);
			
			System.exit(0);
			
		}
		
		if (sdoku[i][j] == 0) {

			for (int x = 1; x <= 9; x++) {

				if(isPossible(i, j, x)) {
					
					sdoku[i][j] = x;
					dfs(i, j+1);
					
				}
				
			}
			
			sdoku[i][j] = 0;
			return;

		}
		dfs(i, j+1);
		

	}

	private static boolean isPossible(int i, int j, int x) {

		// x 작성 가능 여부 세로확인

		for (int I = 0; I < 9; I++) {

			if (sdoku[I][j] == x)
				return false;
		}

		// 가로도 검토

		for (int J = 0; J < 9; J++) {

			if (sdoku[i][J] == x)
				return false;
		}

		// 3x3 범위 검토

		int r = i / 3;
		int c = j / 3;

		for (int I = 3 * r; I < 3 * r + 3; I++) {

			for (int J = 3 * c; J < 3 * c + 3; J++) {

				if (x == sdoku[I][J]) {
					return false;
				}
			}

		}

		return true;

	}

}
