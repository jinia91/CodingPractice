package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2357 {

	static long max2 = 0;
	static long[] arr;
	static long[] tree;
	static long[] tree2;

	static long divideAndMakeTreeMax(int node, int s, int e) {

		if (s == e) {
			return tree[node] = arr[s];
		}

		int mid = (s + e) / 2;
		long left = divideAndMakeTreeMax(node * 2, s, mid);
		long right = divideAndMakeTreeMax(node * 2 + 1, mid + 1, e);

		return tree[node] = max(right, left);
	}

	static long divideAndMakeTreeMin(int node, int s, int e) {

		if (s == e) {
			return tree2[node] = arr[s];
		}

		int mid = (s + e) / 2;
		long left = divideAndMakeTreeMin(node * 2, s, mid);
		long right = divideAndMakeTreeMin(node * 2 + 1, mid + 1, e);

		return tree2[node] = min(right, left);
	}

	static long max(long r, long l) {
		if (r > l) {

			max2 = Math.max(l, max2);

			return r;
		} else {

			max2 = Math.max(r, max2);

			return l;
		}
	}

	static long min(long r, long l) {
		return (Math.min(r, l));
	}

	static long max(int arrS, int arrE, int node, int s, int e) {

		if (arrE < s || arrS > e) {
			return 0;
		}

		if (arrS <= s && e <= arrE) {
			return tree[node];
		}

		int middle = (s + e) / 2;
		long left = max(arrS, arrE, node * 2, s, middle);
		long right = max(arrS, arrE, node * 2 + 1, middle + 1, e);

		return max(left, right);

	}

	static long min(int arrS, int arrE, int node, int s, int e) {

		if (arrE < s || arrS > e) {
			return Long.MAX_VALUE;
		}

		if (arrS <= s && e <= arrE) {
			return tree2[node];
		}

		int middle = (s + e) / 2;
		long left = min(arrS, arrE, node * 2, s, middle);
		long right = min(arrS, arrE, node * 2 + 1, middle + 1, e);

		return min(left, right);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new long[N];
		tree = new long[4 * N];
		tree2 = new long[4 * N];

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		divideAndMakeTreeMax(1, 0, N - 1);
		divideAndMakeTreeMin(1, 0, N - 1);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			max2=0;
			
			
			sb.append(min(a - 1, b - 1, 1, 0, N - 1) + " " + max(a - 1, b - 1, 1, 0, N - 1) + "\n");

			System.out.println(max2);
		}

		System.out.println(sb);

	}

}
