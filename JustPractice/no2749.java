package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2749 {

	static int[][] fibo = {{1,1},
						   {1,0}};

	

	static int[][] multi(int[][] a, int[][] b) {

		long[][] tmp = new long[2][2];
		int[][] rs = new int[2][2];

		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 2; j++) {

				for (int k = 0; k < 2; k++) {

					long tmpa = a[i][k];
					tmp[i][j] += tmpa * b[k][j];

				}

				rs[i][j] = (int) (tmp[i][j] % 1000000);

			}

		}

		return rs;

	}

	static int[][] fibo(int[][] a, long b) {

		
		if (b == 1L) {
			return fibo;

		}

		if (b % 2 == 0) {

			int[][] tmp = fibo(a, b / 2);
			return multi(tmp, tmp);

		}

		int[][] tmp = fibo(a, b / 2);

		return multi(multi(tmp, tmp), a);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long b = Long.parseLong(br.readLine());
		
		if(b==1) {
			System.out.println(1);
			System.exit(0);
		
		}
		
		int[][] rs = fibo(fibo, b-1);
		
		
		
		System.out.println(rs[0][0]);
		
	}

}
