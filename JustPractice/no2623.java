package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no2623 {

	static int[] degree;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static ArrayList<Integer> order = new ArrayList<>();
	static StringTokenizer st;
	static int N;

	static void ts() {

		LinkedList<Integer> que = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {

			if (degree[i] == 0) {
				que.add(i);
			}
		}

		while (!que.isEmpty()) {

			int node = que.poll();

			order.add(node);

			for (int i = 0; i < graph.get(node).size(); i++) {

				int now = graph.get(node).get(i);

				degree[now]--;

				if (degree[now] == 0) {

					que.add(now);

				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		degree = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {

			graph.add(new ArrayList<Integer>());

		}

		for (int i = 0; i < M; i++) {

			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {

				list.add(Integer.parseInt(st.nextToken()));
			}

			for (int j = 0; j < list.size() - 1; j++) {

				int nodeA = list.get(j);
				int nodeB = list.get(j + 1);

				graph.get(nodeA).add(nodeB);
				degree[nodeB]++;

			}

		}

		ts();
		StringBuilder sb = new StringBuilder();

		Iterator<Integer> it = order.iterator();

		while (it.hasNext()) {

			sb.append(it.next()).append("\n");

		}

		
		if(order.size()==N)
		System.out.println(sb);
		else
			System.out.println(0);

	}

}
