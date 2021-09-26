package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no5676 {

	static long[] arr;
	static long[] tree;

	static long divideAndMakeTree(int node, int s, int e) {

		if (s == e) {

			if (arr[s] > 0) {

				return tree[node] = 1;

			}

			else if (arr[s] == 0) {
				return tree[node] = 0;
			}

			else {

				return tree[node] = -1;
			}

		}

		int mid = (s + e) / 2;
		long left = divideAndMakeTree(node * 2, s, mid);
		long right = divideAndMakeTree(node * 2 + 1, mid + 1, e);

		return tree[node] = multi(right, left);
	}

	static long multi(long r, long l) {
		if (r*l> 0)
			return +1;

		if (r*l == 0)
			return 0;

		else
			return -1;

	}

	static long sumQ(int arrS, int arrE, int node, int s, int e) {

		if (arrE < s || arrS > e) {
			return 1;
		}

		if (arrS <= s && e <= arrE) {
			return tree[node];
		}

		int middle = (s + e) / 2;
		long left = sumQ(arrS, arrE, node * 2, s, middle);
		long right = sumQ(arrS, arrE, node * 2 + 1, middle + 1, e);

		return multi(left, right);

	}

	static long updateQ(int target, long newValue, int node, int s, int e) {

		if (target < s || target > e) {
			return tree[node];
		}

		if (s == e) {
			if (newValue > 0) {

				return tree[node] = 1;

			}

			else if (newValue == 0) {
				return tree[node] = 0;
			}

			else {

				return tree[node] = -1;
			}
		}

		int middle = (s + e) / 2;
		long left = updateQ(target, newValue, node * 2, s, middle);
		long right = updateQ(target, newValue, node * 2 + 1, middle + 1, e);

		// 트리 재작성
		return tree[node] = multi(left, right);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		while ((st = new StringTokenizer(br.readLine(), " ")).hasMoreTokens())

		{
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			arr = new long[N];
			tree = new long[4 * N];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}

			divideAndMakeTree(1, 0, N - 1);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < K; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				char ch = st.nextToken().charAt(0);

				int a = Integer.parseInt(st.nextToken());
				long b = Long.parseLong(st.nextToken());

				if (ch == 'C')
					updateQ(a - 1, b, 1, 0, N - 1);

				else {
					long x = sumQ(a - 1, (int) b - 1, 1, 0, N - 1);

					if (x == 1) {
						sb.append("+");
					} else if (x == 0) {
						sb.append("0");
					} else if (x == -1) {
						sb.append("-");
					}
				}

			}

			System.out.println(sb);
		}

	}

}
