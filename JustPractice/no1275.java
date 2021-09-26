package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1275 {

	static long[] arr;
	static long[] tree;

	static long divideAndMakeTree(int node, int s, int e) {

		if (s == e) {
			return tree[node] = arr[s];
		}

		int mid = (s + e) / 2;
		long left = divideAndMakeTree(node * 2, s, mid);
		long right = divideAndMakeTree(node * 2 + 1, mid + 1, e);

		return tree[node] = sum(right, left);
	}

	static long sum(long r, long l) {
		return r+l;
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

		if (s == e)
			return tree[node] = newValue;

		int middle = (s + e) / 2;
		long left = updateQ(target, newValue, node * 2, s, middle);
		long right = updateQ(target, newValue, node * 2 + 1, middle + 1, e);

		// 트리 재작성
		return tree[node] = sum(left, right);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		tree = new long[4*N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i< N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		divideAndMakeTree(1, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< M; i++) {

			st = new StringTokenizer(br.readLine()," ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(y>x) {
			sb.append(sumQ(x-1, y-1, 1,0,N-1) + "\n");
			}
			else
			sb.append(sumQ(y-1, x-1, 1,0,N-1) + "\n");
				
			
			
			updateQ(a-1, b, 1, 0, N-1);
			 
		}

		System.out.println(sb);
		
	}

}
