package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no13549 {

	static boolean[] visited = new boolean[200001];

	static class Node implements Comparable<Node> {

		int cur;
		int dept;

		@Override
		public int compareTo(Node o) {

			return this.dept - o.dept;

		}

	}

	static int bfs(int x, int y) {

		PriorityQueue<Node> que = new PriorityQueue<>();

		Node curNode = new Node();

		curNode.cur = x;
		curNode.dept = 0;

		que.offer(curNode);
	
		while (!que.isEmpty()) {

			Node check = que.poll();

			if (visited[check.cur]) {
				continue;
			}
			
			visited[check.cur] = true;
			
			
			if (check.cur == y) {

				return check.dept;

			}

			else {
				int d = check.dept;

				int next = check.cur * 2;

				if (next < 200001 && next >= 0) {
					if (!visited[next]) {

						Node nextNode = new Node();

						nextNode.cur = next;
						nextNode.dept = d;

						que.add(nextNode);

					}

				}

				next = check.cur + 1;

				if (next < 200001 && next >= 0) {
					if (!visited[next]) {

						Node nextNode = new Node();

						nextNode.cur = next;
						nextNode.dept = d + 1;

						que.add(nextNode);

					}

				}

				next = check.cur - 1;

				if (next < 200001 && next >= 0) {
					if (!visited[next]) {

						Node nextNode = new Node();

						nextNode.cur = next;
						nextNode.dept = d + 1;

						que.add(nextNode);

					}

				}

			}
		}
		return 0;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		System.out.println(bfs(x, y));

	}

}
