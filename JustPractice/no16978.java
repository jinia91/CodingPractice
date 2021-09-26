package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class updateQuery {

	int target;
	long newValue;

	public updateQuery(int target, long newValue) {
		this.target = target;
		this.newValue = newValue;
	}

}

class sumQuery implements Comparable<sumQuery> {

	int line;
	int a;
	int b;
	int order;

	public sumQuery(int line, int a, int b, int o) {
		this.line = line;
		this.a = a;
		this.b = b;
		this.order = o;
	}

	@Override
	public int compareTo(sumQuery o) {
		return this.line - o.line;
	}

}

public class no16978 {

	static long[] arr;
	static long[] tree;
	
	static long[] rsOrder;

	static ArrayList<updateQuery> uList = new ArrayList<>();
	static PriorityQueue<sumQuery> pq = new PriorityQueue<>();

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

		int N = Integer.parseInt(br.readLine());

		arr = new long[N];
		tree = new long[4 * N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		divideAndMakeTree(1, 0, N - 1);

		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		
		rsOrder = new long[M];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int q = Integer.parseInt(st.nextToken());

			if (q == 1) {

				int a = Integer.parseInt(st.nextToken());
				long b = Long.parseLong(st.nextToken());

				uList.add(new updateQuery(a, b));

			}

			else {
				int order = i;
				int line = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				pq.add(new sumQuery(line, a, b, i));

			}

		}

		for (int i = 0; i <= uList.size(); i++) {

			while (!pq.isEmpty()) {

				if(pq.peek().line == i) {
				
				sumQuery sq = pq.poll();

				long rs = sumQ(sq.a - 1, sq.b - 1, 1, 0, N - 1);
				

				rsOrder[sq.order] = rs;
				}
				
				else break;
			}

			if(i != uList.size())
			updateQ(uList.get(i).target - 1, uList.get(i).newValue, 1, 0, N - 1);

		}
		
		for(int i =0; i<M; i++) {
			
			if(rsOrder[i]!=0) {
				
				sb.append(rsOrder[i]+"\n");
				
				
			}
			
			
		}

		System.out.println(sb);

	}

}
