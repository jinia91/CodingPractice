package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2096 {

	// 탑다운으로 풀면 메모리초과 바텀업으로 테이블 하나만 사용해서 인풋되는즉시 연산하는식으로 바꿔서 해야할듯
	// 최대값 최솟값을 모두 저장하기위해서는 4xN 배열로 만들어서
	// 0줄은 직전최댓값
	// 1번째줄은 입력받은값 + 현재 최댓값
	// 2번째줄은 직전 최솟값
	// 3번째줄은 입력받은값 + 현재 최솟값

	static int N;
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		memo = new int[4][3];
		int num =0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) {

				num = Integer.parseInt(st.nextToken());
				
				
				if (i == 0) {
	
					memo[0][j] = num;
					memo[2][j] = num;
					continue;
				}

				if (j == 0) {
					memo[1][0] = Math.max(memo[0][0], memo[0][1])+ num;
					memo[3][0] = Math.min(memo[2][0], memo[2][1])+ num;
				}
				
				if (j == 1) {
					memo[1][1] = Math.max(memo[0][0], Math.max(memo[0][1], memo[0][2]))+ num;
					memo[3][1] = Math.min(memo[2][0], Math.min(memo[2][1], memo[2][2]))+ num;
				}
				
				if (j == 2) {
					memo[1][2] = Math.max(memo[0][1], memo[0][2])+ num;
					memo[3][2] = Math.min(memo[2][1], memo[2][2])+ num;
				}
				

			}
			
			// 갱신
			if(i != 0) {
				for(int j =0 ; j<3; j++) {
					
					memo[0][j] = memo[1][j];
					memo[2][j] = memo[3][j];
				}
			}
		}
		
		int max = Math.max(memo[0][0], Math.max(memo[0][1], memo[0][2]));
		int min = Math.min(memo[2][0], Math.min(memo[2][1], memo[2][2]));

		System.out.println(max+" " +min);
	}
}

//	static int N;
//	static int[][] board;
//	static int[][] memo;
//
//	static int dp(int x, int y) {
//
//		if (memo[x][y] == 0) {
//
//			switch (y) {
//
//			case 0:
//				memo[x][0] = Math.max(dp(x - 1, 0), dp(x - 1, 1))+board[x][y];
//				break;
//			case 1:
//				memo[x][1] = Math.max(dp(x - 1, 0), Math.max(dp(x - 1, 1), dp(x - 1, 2)))+board[x][y];
//				break;
//			case 2:
//				memo[x][2] = Math.max(dp(x - 1, 1), dp(x - 1, 2))+board[x][y];
//				break;
//
//			}
//		}
//
//		return memo[x][y];
//
//	}
//	
//	static int dp2(int x, int y) {
//
//		if (memo[x][y] == 0) {
//
//			switch (y) {
//
//			case 0:
//				memo[x][0] = Math.min(dp2(x - 1, 0), dp2(x - 1, 1))+board[x][y];
//				break;
//			case 1:
//				memo[x][1] = Math.min(dp2(x - 1, 0), Math.min(dp2(x - 1, 1), dp2(x - 1, 2)))+board[x][y];
//				break;
//			case 2:
//				memo[x][2] = Math.min(dp2(x - 1, 1), dp2(x - 1, 2))+board[x][y];
//				break;
//
//			}
//		}
//
//		return memo[x][y];
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		N = Integer.parseInt(br.readLine());
//
//		board = new int[N][N];
//		memo = new int[N][N];
//
//		for (int i = 0; i < N; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//			for (int j = 0; j < N; j++) {
//
//				board[i][j] = Integer.parseInt(st.nextToken());
//				
//				if(i == 0) {
//					memo[i][j] = board[i][j];
//				}
//
//			}
//
//		}
//		
//		
//		
//		int dp = dp(N-1,0);
//		int dp2 = dp(N-1,1);
//		int dp3 = dp(N-1,2);
//
//		System.out.print(Math.max(dp, Math.max(dp2, dp3))+" ");
//		
//		memo = new int[N][N];
//
//
//		for(int i = 0; i<N; i++) {
//			memo[0][i] = board[0][i];
//		}
//
//		
//		dp = dp2(N-1,0);
//		dp2 = dp2(N-1,1);
//		dp3 = dp2(N-1,2);
//		
//		System.out.print(Math.min(dp, Math.min(dp2, dp3)));
//
//	}
