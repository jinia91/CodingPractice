package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no9370 {

	static int T;
	static int[] memo;
	static ArrayList<ArrayList<Node>> graph;
	static ArrayList<Integer> maybeEnd;
	static ArrayList<Integer> maybeAnswer;
	static boolean[] answerCheck;
	static StringTokenizer st;
	static final int INF = 10000000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			memo = new int[n + 1];

			for(int j = 0; j<n+1; j++) {
				memo[j] = INF;
			}

			for (int j = 0; j < n + 1; j++) {
				graph.add(new ArrayList<Node>());
			}

			st = new StringTokenizer(br.readLine(), " ");

			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				graph.get(a).add(new Node(b, d));
				graph.get(b).add(new Node(a, d));

			}

			answerCheck = new boolean[t];

			maybeEnd = new ArrayList<>();
			maybeAnswer = new ArrayList<>();
			
			dij(s);
			
			for (int j = 0; j < t; j++) {
				maybeEnd.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(maybeEnd);
			
			for (int j = 0; j < t; j++) {
				maybeAnswer.add(memo[maybeEnd.get(j)]);
			}
			
			// 1. s->g->h->t
			
			int case1g = memo[g];

			for(int j = 0; j<n+1; j++) {
				memo[j] = INF;
			}
			dij(g);
			int case1h = memo[h];
			
			for (int j = 0; j < t; j++) {

				for(int K = 0; K<n+1; K++) {
					memo[j] = INF;
				}
				dij(h);
				int case1t = memo[maybeEnd.get(j)];

				int sum = case1g + case1h + case1t;

				if(sum == maybeAnswer.get(j)) answerCheck[j] = true;
				
			}
			
			// 2. s->h->g->t
			for(int j = 0; j<n+1; j++) {
				memo[j] = INF;
			}
			
			dij(s);
			
			int case2h = memo[h];
			
			for(int j = 0; j<n+1; j++) {
				memo[j] = INF;
			}
			
			dij(h);
			int case2g = memo[g];
			
			for (int j = 0; j < t; j++) {

				for(int K = 0; K<n+1; K++) {
					memo[j] = INF;
				}
				
				dij(g);
				int case2t = memo[maybeEnd.get(j)];

				int sum = case2g + case2h + case2t;

				if(sum == maybeAnswer.get(j)) answerCheck[j] = true;
			}

			StringBuilder sb = new StringBuilder();
			
			for(int j =0; j<answerCheck.length; j++) {
				
			if(answerCheck[j]) sb.append(maybeEnd.get(j)).append(" ");	
				
			}
			
			System.out.println(sb);
			sb.setLength(0);

		}

	}

	static void dij(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		memo[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			int cur = curNode.cur;
			int dis = curNode.dis;

			if (memo[cur] >= dis) {
				for (int i = 0; i < graph.get(cur).size(); i++) {

					Node nextNode = graph.get(cur).get(i);

					if (memo[nextNode.cur] > memo[cur] + nextNode.dis) {
						memo[nextNode.cur] = memo[cur] + nextNode.dis;
						pq.add(new Node(nextNode.cur, memo[nextNode.cur]));
					}

				}

			}
		}
	}
}

class Node implements Comparable<Node> {

	int cur;
	int dis;

	Node(int cur, int dis) {

		this.cur = cur;
		this.dis = dis;

	}

	@Override
	public int compareTo(Node o) {
		return this.dis - o.dis;
	}

}