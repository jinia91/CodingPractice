package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] room = new int[N];

		for (int i = 0; i < N; i++) {

			room[i] = Integer.parseInt(st.nextToken());

		}

		int cnt = 0;

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		for (int num : room) {

			num = num - a;
			cnt++;

			if (num > 0) {
				if (num % b != 0) {

					int ans = num / b;
					cnt += ans + 1;
				}

				else {
					int ans = num / b;
					cnt += ans;
				}
			}
		}

		System.out.println(cnt);
	}

}
