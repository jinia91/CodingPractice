package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no10217 {

	static StringTokenizer st;

	static int N, C, M;
	static final Integer INF = 100000;
	static ArrayList<ArrayList<Edge>> graph;

	static int[][] d;

	static void dijkstra(int start) {

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(start, 0, 0));

		d[start][0] = 0;

		while (!pq.isEmpty()) {

			// 간선 이동시 
			Edge edge = pq.poll();
			int curIdx = edge.e;
			int dis = edge.d;
			int cos = edge.c;
			
			// 우선순위큐로 최단시간 최소비용 도착 이후 도착 간선 검토 x
			if(curIdx == N) break;
			

			// 현 노드에서 연결간선 탐색
			for (int i = 0; i < graph.get(curIdx).size(); i++) {
		
				Edge nextEdge = graph.get(curIdx).get(i);
						
				// 간선 이동 총비용 검토
				if (cos + nextEdge.c > C)
					continue;

				// 이미 최단거리 계산한상태(checked)
				if (d[nextEdge.e][cos + nextEdge.c] <= nextEdge.d+dis)
					continue;
			
				//테이블 갱신 시작
				for(int j = cos+nextEdge.c; j< C+1; j++) {
					
					if(d[nextEdge.e][j]> dis+nextEdge.d) 
						
						d[nextEdge.e][j] = dis+nextEdge.d;
					
				}
				
				d[nextEdge.e][cos+nextEdge.c] = dis+nextEdge.d;
				pq.add(new Edge(nextEdge.e, cos+nextEdge.c, dis+nextEdge.d));
							
			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");

			graph = new ArrayList<>();

			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N + 1; i++) {

				graph.add(new ArrayList<Edge>());

			}

			for (int i = 0; i < M; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				graph.get(a).add(new Edge(b, c, d));

			}

			d = new int[N + 1][C + 1];

			for (int[] a : d) {
				Arrays.fill(a, INF);
			}

			int start = 1;
			int end = N;

			dijkstra(start);

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < C + 1; i++) {

				min = Math.min(d[end][i], min);

			}

			if (min >= INF) {
				sb.append("Poor KCM\n");
			} else {
				sb.append(min + "\n");
			}

		}

		System.out.println(sb);

	}

	static class Edge implements Comparable<Edge> {

		int e;
		int c;
		int d;

		public Edge(int e, int c, int d) {

			this.e = e;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {

			if (this.d == o.d) {

				return this.c - o.c;

			}

			return this.d - o.d;
		}

	}
}