package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no2696 {

	static int T;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			PriorityQueue<Integer> front = new PriorityQueue<>((o1, o2) -> o2 - o1);
			PriorityQueue<Integer> back = new PriorityQueue<>((o1, o2) -> o1 - o2);
			int idx = 1;

			int N = Integer.parseInt(br.readLine());

			StringBuilder answer = new StringBuilder();

			while (N > 0) {

				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 10; j++) {

					if(!st.hasMoreTokens()) break;
					
					int x = Integer.parseInt(st.nextToken());

					if (front.size() == back.size()) {

						front.add(x);

						if (back.size() != 0 && front.peek() > back.peek()) {
							swap(front, back);
						}

						if (idx % 10 == 0) {
							answer.append(front.peek()).append("\n");
							idx++;
						}

						else {
							answer.append(front.peek()).append(" ");
							idx++;
						}
					}

					else {

						back.add(x);
						if (front.peek() > back.peek()) {
							swap(front, back);
						}

					}
				}

				N = N - 10;

			}

			System.out.println(idx - 1);
			System.out.println(answer);

		}

	}

	private static void swap(PriorityQueue<Integer> front, PriorityQueue<Integer> back) {
		int tmp = front.poll();
		front.add(back.poll());
		back.add(tmp);
	}

}
