package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no2565 {

	static int N;

	static StringTokenizer st;

	static PriorityQueue<int[]> pq;
	static int[] S;
	
	static ArrayList<Integer> memo = new ArrayList<>();
	static int[] memo2;

	static void dp(int x, int i) {

		if (x > memo.get(memo.size() - 1)) {
			memo.add(x);
			memo2[i] = memo.size()-1;
			return;
		}

		int idx = upperBound(x);

		memo2[i] = idx;
		memo.set(idx, x);
	}

	private static int upperBound(int x) {
		int left = 0;
		int right = memo.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if(memo.get(mid)<x) {
				left = mid+1;
			}
			else {
				right = mid;
			}
			
		}
		
		return right;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>((int[] o1, int[] o2) -> o1[1] - o2[1]);

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int[] idx = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

			pq.add(idx);
		}

		int size = pq.size();
		
		S = new int[size];
		memo2 = new int[size];
		
		for (int i =0; i< size; i++) {

			S[i] = pq.poll()[0];
		}
		
		memo.add(S[0]);
		
		for(int i =1; i<N; i++) {
			
			dp(S[i], i);
			
		}
		
		
		System.out.println(S.length - memo.size());

	}

}
