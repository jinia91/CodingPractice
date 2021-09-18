package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no2629 {

	static int N, M;
	static int[] W, m;
	static StringTokenizer st;
	static ArrayList<Integer> canCalList = new ArrayList<>();

	static boolean[] flag;

	static void dp() {

		canCalList.add(0);

		for (int n = 0; n < N; n++) {

			int size = canCalList.size();
			
			for (int i = 0; i < size; i++) {

				int target = canCalList.get(i);

				// 추로 표현 가능한 모든 수 기록
				// 1.현재 기록된 수와 현재 추의 차 절대값 => 표현가능한 수
				// 2.현재 기록된 수와 현재 추의 합 = > 표현가능한 수
				if (Math.abs(W[n] - target)<40001&&
						!flag[Math.abs(W[n] - target)]) {
					canCalList.add(Math.abs(W[n] - target));
					flag[Math.abs(W[n] - target)] = true;
				}

				if (Math.abs(W[n] - target)<40001&&!flag[W[n] + target]) {
					canCalList.add(W[n] + target);
					flag[W[n] + target] = true;
				}
			}

		}
	}



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		W = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());

		m = new int[M];

		flag = new boolean[40001];

		dp();

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());

			if (flag[x])
				sb.append("Y").append(" ");
			else
				sb.append("N").append(" ");

		}

		System.out.println(sb);

	}

}
