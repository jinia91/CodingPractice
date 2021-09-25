package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no9426 {

	static int N, K;
	static long[] tree;

	static long sum(long r, long l) {
		return r + l;
	}

	static long sumQ(int arrS, int arrE, int node, int qS, int qE) {

		if (arrE < qS || arrS > qE) {
			return 0;
		}

		if (arrS <= qS && qE <= arrE) {
			return tree[node];
		}

		int middle = (qS + qE) / 2;
		long left = sumQ(arrS, arrE, node * 2, qS, middle);
		long right = sumQ(arrS, arrE, node * 2 + 1, middle + 1, qE);

		return sum(left, right);
	}

	static long updateQ(int target, long newValue, int node, int qS, int qE) {

		if (target < qS || target > qE) {
			return tree[node];
		}

		if (qS == qE)
			return tree[node] += newValue;

		int middle = (qS + qE) / 2;
		long left = updateQ(target, newValue, node * 2, qS, middle);
		long right = updateQ(target, newValue, node * 2 + 1, middle + 1, qE);
		return tree[node] = sum(left, right);
	}

	static int biSearch(int s, int e, long target) {

		while (s <= e) {
			int m = (s + e) / 2;
			long sum = sumQ(0, m, 1, 0, 1000000);

			if (sum < target)
				s = m + 1;
			else
				e = m - 1;
		}

		return s;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		tree = new long[4 * 1000000];

		int delete = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {

			int x = Integer.parseInt(br.readLine());

			if (i < K - 1) {

				updateQ(x-1, 1, 1, 0, 1000000);

			}

			if (i == K - 1) {
				updateQ(x-1, 1, 1, 0, 1000000);
				delete = x;
				int target = biSearch(0, 1000000, 2);

				System.out.println(target);
				
				sum += target;

			}

			else if(i > K-1){
			updateQ(x, 1, 1, 0, 1000000);
			updateQ(delete, -1, 1, 0, 1000000);
			delete = x;
			int target = biSearch(0, 1000000, 2);

			System.out.println(target);
			
			sum += target;
			}
		}

		System.out.println(sum);

	}

}
