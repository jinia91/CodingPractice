package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no4803 {

	static StringTokenizer st;

	static ArrayList<ArrayList<Integer>> graph;

	static int N, M, T;
	static boolean[] visited;
	static boolean[] hasParent;
	static int cnt;

	static void isTree(int start) {

		LinkedList<Integer> que = new LinkedList<>();

		que.add(start);

		int nodeCnt = 0; 
		int edgeCnt = 0;
		
		while (!que.isEmpty()) {

			int parent = que.poll();
			nodeCnt += 1;
			visited[parent] = true;
			
			
			for (Integer child : graph.get(parent)) {

				edgeCnt += 1;
				
				if (!visited[child]) {
					que.add(child);
				}

			}

		}
			
		// 트리 간선갯수가 N-1인걸 활용해서 사이클 판단
		if((edgeCnt/2)+1 == nodeCnt) cnt++;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {

			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			T++;

			graph = new ArrayList<>();

			visited = new boolean[N + 1];
			hasParent = new boolean[N + 1];

			for (int i = 0; i < N + 1; i++) {

				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < M; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				graph.get(a).add(b);
				graph.get(b).add(a);

			}

			for (int i = 1; i < N + 1; i++) {

				if (!visited[i])
					isTree(i);

			}

			if (cnt > 1) {
				sb.append("Case " + T + ": A forest of " + cnt + " trees." + "\n");

			} else if (cnt == 1) {

				sb.append("Case " + T + ": There is one tree." + "\n");

			}

			else {

				sb.append("Case " + T + ": No trees." + "\n");

			}
			cnt = 0;
		}

		System.out.println(sb);

	}

}
