package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no1916 {

	static StringTokenizer st;

	static int N, M;
	static final Integer INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	static String[] tracking;
	static int[] d;
	

	static void dijkstra(int start) {

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		pq.add(new Edge(start, 0));

		d[start] = 0;
		tracking[start] = start+"";
		
		while (!pq.isEmpty()) {

			Edge edge = pq.poll();
			int curIdx = edge.e;
			int dis = edge.d;

			// 이미 최단거리를 구해놓은 상태(checked)
			if (d[curIdx] < dis)
				continue;

			for (int i = 0; i < graph.get(curIdx).size(); i++) {

				Edge nextEdge = graph.get(curIdx).get(i);

				int cost = d[curIdx] + nextEdge.d;

				if (cost < d[nextEdge.e]) {
					d[nextEdge.e] = cost;
					tracking[nextEdge.e] = tracking[curIdx].toString()+" "+nextEdge.e; 
					pq.add(new Edge(nextEdge.e, cost));
				}

			}

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {

			graph.add(new ArrayList<Edge>());
			
		}

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Edge(b, c));

		}
		
		d = new int[N+1];
		tracking = new String[N+1];
		Arrays.fill(d, INF);
		Arrays.fill(tracking, "");
		
		st = new StringTokenizer(br.readLine(), " ");

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		dijkstra(start);
		
		System.out.println(d[end]);
		
		String[] list = tracking[end].split(" ");
		
		System.out.println(list.length);
		System.out.println(tracking[end]);

	}

	static class Edge implements Comparable<Edge> {

		int e;
		int d;

		public Edge(int e, int d) {

			this.e = e;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return this.d - o.d;
		}

	}

}
