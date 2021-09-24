package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no14428 {

	static long[] arr;
	static int[] tree;

	static int N;

	static int divideAndMakeTree(int node, int s, int e) {

		if (s == e) {
			return tree[node] = s;
		}

		int mid = (s + e) / 2;
		int left = divideAndMakeTree(node * 2, s, mid);
		int right = divideAndMakeTree(node * 2 + 1, mid + 1, e);

		return tree[node] = min(left, right);
	}

	static int min(int l, int r) {
		if (arr[l] > arr[r]) {
			return r;
		}
		return l;
	}

	static int sumQ(int arrS, int arrE, int node, int s, int e) {

		if (arrE < s || arrS > e) {
			return N;
		}

		if (arrS <= s && e <= arrE) {
			return tree[node];
		}

		int middle = (s + e) / 2;
		int left = sumQ(arrS, arrE, node * 2, s, middle);
		int right = sumQ(arrS, arrE, node * 2 + 1, middle + 1, e);

		return min(left, right);

	}

	static int updateQ(int target, long newValue, int node, int s, int e) {

		if (target < s || target > e) {
			return tree[node];
		}

		if (s == e) {
			arr[s] = newValue;
			return tree[node];
		}

		int middle = (s + e) / 2;
		int left = updateQ(target, newValue, node * 2, s, middle);
		int right = updateQ(target, newValue, node * 2 + 1, middle + 1, e);

		// 트리 재작성
		return tree[node] = min(left, right);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new long[N + 1];
		tree = new int[4 * N];

		arr[N] = Integer.MAX_VALUE;

		Arrays.fill(tree, Integer.MAX_VALUE);

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		divideAndMakeTree(1, 0, N - 1);

		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int q = Integer.parseInt(st.nextToken());

			if (q == 1) {

				int a = Integer.parseInt(st.nextToken());
				long b = Long.parseLong(st.nextToken());

				updateQ(a - 1, b, 1, 0, N - 1);
			} else {
				sb.append(tree[1] + 1 + "\n");
			}
		}

		System.out.println(sb);

	}

}
