package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1021 {

	static LinkedList<Integer> dq;
	static int[] query;

	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dq = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		query = new int[M];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			query[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : query) {

			perform(x);

		}

		System.out.println(count);

	}

	static void perform(int x) {

		if (x == dq.peekFirst()) {
			dq.pollFirst();
		}

		else {

			LinkedList<Integer> clone = (LinkedList<Integer>) dq.clone();

			int cnt = 0;
			while (clone.peek() != x) {
				int y = clone.pollFirst();
				clone.addLast(y);
				cnt++;
			}

			int cnt2 = 0;
			while (dq.peek() != x) {
				int y = dq.pollLast();
				dq.addFirst(y);
				cnt2++;
			}

			if (cnt < cnt2) {
				dq = clone;
				dq.poll();
				count += cnt;
			}

			else {
				dq.poll();
				count += cnt2;
			}
		}

	}

}
