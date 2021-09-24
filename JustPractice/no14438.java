package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no14438{

	static long[] arr;
	static long[] tree;

	static long divideAndMakeTree(int node, int s, int e) {

		if (s == e) {
			return tree[node] = arr[s];
		}

		int mid = (s + e) / 2;
		long left = divideAndMakeTree(node * 2, s, mid);
		long right = divideAndMakeTree(node * 2 + 1, mid + 1, e);

		return tree[node] = min(right, left);
	}

	static long min(long r, long l) {
		return Math.min(r, l);
	}

	static long sumQ(int arrS, int arrE, int node, int s, int e) {

		if (arrE < s || arrS > e) {
			return Long.MAX_VALUE;
		}

		if (arrS <= s && e <= arrE) {
			return tree[node];
		}

		int middle = (s + e) / 2;
		long left = sumQ(arrS, arrE, node * 2, s, middle);
		long right = sumQ(arrS, arrE, node * 2 + 1, middle + 1, e);

		return min(left, right);

	}

	static long updateQ(int target, long newValue, int node, int s, int e) {

		if (target < s || target > e) {
			return tree[node];
		}

		if (s == e)
			return tree[node] = newValue;

		int middle = (s + e) / 2;
		long left = updateQ(target, newValue, node * 2, s, middle);
		long right = updateQ(target, newValue, node * 2 + 1, middle + 1, e);

		// 트리 재작성
		return tree[node] = min(left, right);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		tree = new long[4*N];
		
		Arrays.fill(tree, Long.MAX_VALUE);

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i = 0; i< N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		divideAndMakeTree(1, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< M; i++) {

			st = new StringTokenizer(br.readLine()," ");
			
			int q = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(q == 1) updateQ(a-1, b, 1, 0, N-1);
			 
			else sb.append(sumQ(a-1, (int)b-1, 1,0,N-1) + "\n");
			
		}

		System.out.println(sb);
		
	}

}
