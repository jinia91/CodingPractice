package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no18436 {

	static long[] arr;
	static long[] tree;

	static long divideAndMakeTree(int node, int s, int e) {

		if (s == e) {

			if (arr[s] % 2 == 0) {
				return tree[node] = 1;
			}

			return tree[node] = 0;
		}

		int mid = (s + e) / 2;
		long left = divideAndMakeTree(node * 2, s, mid);
		long right = divideAndMakeTree(node * 2 + 1, mid + 1, e);

		return tree[node] = sum(right, left);
	}

	static long sum(long r, long l) {
		return r + l;
	}

	static long sumQ(int arrS, int arrE, int node, int s, int e) {

		if (arrE < s || arrS > e) {
			return 0;
		}

		if (arrS <= s && e <= arrE) {
			return tree[node];
		}

		int middle = (s + e) / 2;
		long left = sumQ(arrS, arrE, node * 2, s, middle);
		long right = sumQ(arrS, arrE, node * 2 + 1, middle + 1, e);

		return sum(left, right);

	}

	static long updateQ(int target, long newValue, int node, int s, int e) {

		if (target < s || target > e) {
			return tree[node];
		}

		if (s == e) {

			if (newValue % 2 == 0) {

				return tree[node] = 1;
			}
			else {
				return tree[node] = 0;
			}
		}
		int middle = (s + e) / 2;
		long left = updateQ(target, newValue, node * 2, s, middle);
		long right = updateQ(target, newValue, node * 2 + 1, middle + 1, e);

		// 트리 재작성
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

		divideAndMakeTree(1, 0, N - 1);

		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int q = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			if (q == 1)
				updateQ(a - 1, b, 1, 0, N - 1);

			else if(q==2) {
				sb.append(sumQ(a - 1, (int) b - 1, 1, 0, N - 1) + "\n");
			}
			else {
				sb.append((b-a+1)-sumQ(a - 1, (int) b - 1, 1, 0, N - 1) + "\n");
			}
		}

		System.out.println(sb);

	}

}
