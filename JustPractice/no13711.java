package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no13711 {

	static int N;
	static StringTokenizer sb;

	static int[][] memo;
	static int[] arrA;
	static int[] arrB;

	static void lcs() {

		for (int i = 1; i <= arrA.length; i++) {

			for (int j = 1; j <= arrB.length; j++) {

				if (arrA[i - 1] == arrB[j - 1]) {

					memo[i][j] = memo[i - 1][j - 1] + 1;

				}

				else {

					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arrA = new int[N];
		arrB = new int[N];
		memo = new int[arrA.length + 1][arrB.length + 1];

		sb = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {

			arrA[i] = Integer.parseInt(sb.nextToken());
		}

		sb = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {

			arrB[i] = Integer.parseInt(sb.nextToken());
		}
		
		

		lcs();

		System.out.println(memo[arrA.length][arrB.length]);

		
	
	}

}
