package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no13537 {

	static long[] arr;
	static long[] tree;

	static long sum(long r, long l) {
		return r + l;
	}

	static long updateQ(int arrS, int arrE, int k, int node, int s, int e) {

		// 범위 초과 무시
		if (arrE < s || arrS > e) {
			return 0;
		}

		if (s == e) {

			if (arr[s] > k) {

				return tree[node] = 1;
			}
			else {
				return tree[node] = 0;
			}
		}
		int middle = (s + e) / 2;
		long left = updateQ(arrS, arrE, k, node * 2, s, middle);
		long right = updateQ(arrS, arrE, k, node * 2 + 1, middle + 1, e);

		// 트리
		return tree[node] = sum(left, right);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		arr = new long[N];
		tree = new long[4 * N];

		st = new StringTokenizer(br.readLine(), " ");

		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			sb.append(updateQ(a - 1, b - 1, k,1, 0, N - 1) + "\n");
			
		}

		System.out.println(sb);

	}

}
