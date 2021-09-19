package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no3584 {

	static ArrayList<ArrayList<Integer>> graph;

	static StringTokenizer st;
	static int T, N, tarA, tarB, root;

	static int[] dept;
	static int[] parent;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			N = Integer.parseInt(br.readLine());

			dept = new int[N + 1];
			parent = new int[N + 1];
			graph = new ArrayList<>();

			for (int j = 0; j < N + 1; j++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int j = 0; j < N - 1; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				int pNode = Integer.parseInt(st.nextToken());
				int cNode = Integer.parseInt(st.nextToken());

				parent[cNode] = pNode;
				graph.get(pNode).add(cNode);
			}

			st = new StringTokenizer(br.readLine(), " ");
			tarA = Integer.parseInt(st.nextToken());
			tarB = Integer.parseInt(st.nextToken());

			findRoot();
			dfs(root, 0);
			lca();
			
			System.out.println(tarA);

		}

	}

	static void lca() {

		if (dept[tarA] > dept[tarB]) {

			while (dept[tarA] != dept[tarB]) {
				tarA = parent[tarA];
			}
		}
		
		else if (dept[tarA] < dept[tarB]) {

			while (dept[tarA] != dept[tarB]) {
				tarB = parent[tarB];
			}
		}
		
		while(tarA != tarB) {
			
			tarA = parent[tarA];
			tarB = parent[tarB];
			
		}

	}

	static void dfs(int node, int d) {

		if (dept[node] != 0)
			return;

		for (int i = 0; i < graph.get(node).size(); i++) {

			int cNode = graph.get(node).get(i);

			dfs(cNode, d + 1);

		}

		dept[node] = d;

	}

	private static void findRoot() {
		for (int j = 1; j < N + 1; j++) {

			if (parent[j] == 0) {
				root = j;
				return;
			}

		}
	}

}
