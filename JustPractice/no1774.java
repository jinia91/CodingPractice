package JustPractice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1774 {

	static StringTokenizer st;

	static int N, M;
	static ArrayList<Point> nodes = new ArrayList<>();
	static ArrayList<Edge> edges = new ArrayList<>();
	static int[] parent;

	static class Edge implements Comparable<Edge> {

		int nodeA;
		int nodeB;

		double d;

		public Edge(int nodeA, int nodeB) {

			this.nodeA = nodeA;
			this.nodeB = nodeB;

			double distance = nodes.get(nodeA).distance(nodes.get(nodeB));

			this.d = distance;

		}

		@Override
		public int compareTo(Edge o) {

			if(d> o.d) {
				return +1;
			}
			
			else if(d == o.d){
				return 0;
			}
			
			else return -1;

		}

	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		} else
			return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;
		if (x > y)
			parent[x] = y;
		else
			parent[y] = x;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			Point point = new Point(x, y);

			nodes.add(point);

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());

			union(nodeA-1, nodeB-1);

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (i == j)
					continue;
				edges.add(new Edge(i, j));

			}
		}

		Collections.sort(edges);

		double sum = 0;

		for (Edge e : edges) {

			int a = e.nodeA;
			int b = e.nodeB;

			if (find(a) == find(b))
				continue;

			else {
				sum += e.d;
				union(a, b);
			}

		}

		System.out.printf("%.2f", (double) Math.round(sum * 100) / 100);
		
	}

}
