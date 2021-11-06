package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1300 {

	static long[] arr;
	static int K;
	static long N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		int rs = binarySerearch();
		
		System.out.println(rs);

	}

	private static int binarySerearch() {

		int s = 1;
		int e = (int) Math.min(1000000000, N * N)+1;

		while (s < e) {

			int mid = (s + e) / 2;

			if (cal(mid) < K) {

				s = mid + 1;

			}

			else {

				e = mid;

			}

		}

		return e;
	}

	private static int cal(int mid) {

		int sum = 0;

		for (int i = 1; i <= N; i++) {

			sum += Math.min(mid / i, N);

		}

		return sum;
	}

}
