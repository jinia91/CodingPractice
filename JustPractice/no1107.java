package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1107 {

	static boolean[] brokenBtn = new boolean[10];
	static int N, M, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		if (M != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				brokenBtn[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		// 1. +,- 만 사용

		ans = Math.abs(N - 100);

		// 2. 0~999999 까지 버튼으로 이동하는 가짓수 완탐

		// 0으로 이동후 탐색
		if (!brokenBtn[0]) {
			ans = Math.min(N + 1, ans);
		}

		// 0이외
		for (int t = 1; t <= 999999; t++) {

			int cnt = 0;
			int target = t;

			while (target > 0) {
				if (brokenBtn[target % 10])
					break;
				else {
					cnt++;
					target /= 10;
				}
			}

			if (cnt == String.valueOf(t).length()) {
				int tmp = Math.abs(N - t);
				ans = Math.min(ans, tmp + cnt);
			}
		}

		System.out.println(ans);

	}

}
