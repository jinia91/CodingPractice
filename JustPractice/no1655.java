package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class no1655 {

	static PriorityQueue<Integer> front;
	static PriorityQueue<Integer> back;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		front = new PriorityQueue<>((i1, i2) -> i2 - i1);
		back = new PriorityQueue<>((i1, i2) -> i1 - i2);
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {

			if (front.size() == back.size()) {
				front.add(Integer.parseInt(br.readLine()));

				// && 는 앞에서 false 판단시 뒤에 판단안하므로 nullpointexception 방어가능
				if (!back.isEmpty()&&front.peek() > back.peek()) {
					swap();
				}
			}

			else {
				back.add(Integer.parseInt(br.readLine()));

				if (front.peek() > back.peek()) {
					swap();
				}
			}
		
			sb.append(front.peek()).append("\n");
		}
		
		System.out.println(sb);
		
	}

	private static void swap() {
		int tmp = front.poll();
		front.add(back.poll());
		back.add(tmp);
	}

}
