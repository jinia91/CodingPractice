package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no3176 {

	static int N, M;
	static StringTokenizer st;

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] check;
	static int[][] parentLog;
	static int[][] dis; 
	static int[] dept;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		check = new boolean[N + 1];

		int k = 0;
		for (int i = 1; i <= N; i *= 2) {
			k++;
		}

		parentLog = new int[k][N + 1];

		dept = new int[N + 1];
		
		dis = new int[N+1][N+1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			int d =  Integer.parseInt(st.nextToken());
			
			graph.get(nodeA).add(nodeB);
			graph.get(nodeB).add(nodeA);
			
			dis[nodeA][nodeB] = d;
			dis[nodeB][nodeA] = d;

		}

		dfs(1, 0, 1);
		fillParentLog();

		M = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int tarA = Integer.parseInt(st.nextToken());
			int tarB = Integer.parseInt(st.nextToken());

			answer.append(lca(tarA, tarB)).append("\n");

		}

		System.out.print(answer);

	}

	static void fillParentLog() {
		for (int i = 1; i < parentLog.length; i++) {

			for (int j = 1; j <= N; j++) {

				int parentX = parentLog[i - 1][j];
				 
				parentLog[i][j] = parentLog[i - 1][parentX];
			}
		}
	}

	static void dfs(int node, int d, int pNode) {

		parentLog[0][node] = pNode;
		pNode = node;
		check[node] = true;
		if (dept[node] != 0)
			return;

		for (int i = 0; i < graph.get(node).size(); i++) {

			int cNode = graph.get(node).get(i);

			if (check[cNode])
				continue;

			dfs(cNode, d + 1, pNode);
		}

		dept[node] = d;

	}

	static int lca(int tarA, int tarB) {

		if (dept[tarA] > dept[tarB]) {

			for (int i = parentLog.length - 1; i >= 0; i--) {

				if (Math.pow(2, i) <= dept[tarA] - dept[tarB]) {
					tarA = parentLog[i][tarA];
				}

			}

		} else if (dept[tarA] < dept[tarB]) {

			for (int i = parentLog.length - 1; i >= 0; i--) {

				if (Math.pow(2, i) <= dept[tarB] - dept[tarA]) {
					tarB = parentLog[i][tarB];
				}

			}

		}

		if (tarA == tarB)
			return tarA;

		for (int i = parentLog.length - 1; i >= 0; i--) {
			if (parentLog[i][tarA] != parentLog[i][tarB]) {
				tarA = parentLog[i][tarA];
				tarB = parentLog[i][tarB];
			}
		}
		return parentLog[0][tarA];
		
	}

}
