package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no17069 {

	static int N;

	static int[][] room;

	static long[][] case1; // ����
	static long[][] case2; // ����
	static long[][] case3; // �밢�� -> 3�����迭���ص��ɰ��� �����ϱ� ���ϰ� 2�����迭 3������

	static long[][] ans;

	static void dp() {

		for (int i = 0; i < N; i++) {

			for (int j = 2; j < N; j++) {

				// ��ó��
				if (room[i][j] == 1)
					continue;

				// case1
				if (j - 1 >= 0) {
					case1[i][j] = case1[i][j - 1] + case3[i][j - 1];
				}

				// case2
				if (i - 1 >= 0) {
					case2[i][j] = case2[i - 1][j] + case3[i - 1][j];
				}

				// case3
				if (i - 1 >= 0 && j - 1 >= 0) {

					//case3 ��ó��
					if(room[i-1][j] ==1||room[i][j-1] ==1) {
						ans[i][j] = (long)case1[i][j] + case2[i][j] + case3[i][j];
						continue;
					}
					
					case3[i][j] = case1[i - 1][j - 1] + case2[i - 1][j - 1] + case3[i - 1][j - 1];

				}

				ans[i][j] = (long)case1[i][j] + case2[i][j] + case3[i][j];

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		room = new int[N][N];
		case1 = new long[N][N];
		case2 = new long[N][N];
		case3 = new long[N][N];
		ans = new long[N][N];
		
		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				room[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		case1[0][1] = 1;
		
		dp();
		
		
		System.out.println(ans[N-1][N-1]);

		
		
	}

}
