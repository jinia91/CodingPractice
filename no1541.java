import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");

		int sum = Integer.MAX_VALUE;

		while (st.hasMoreTokens()) {

			int tmp = 0;
			StringTokenizer add = new StringTokenizer(st.nextToken(), "+");

			while (add.hasMoreTokens()) {

				tmp += Integer.valueOf(add.nextToken());

			}

			if (sum == Integer.MAX_VALUE) {
				sum = tmp;

			} else {

				sum -= tmp;

			}

		}


		System.out.println(sum);

	}
}
