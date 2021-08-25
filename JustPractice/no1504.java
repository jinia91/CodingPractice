
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

public class exercise {

	static int[] length;
	static int must1, must2;
	static ArrayList<ArrayList<Node>> graph;
	static int INF = 200000001;

	static void dij(int start) {

		PriorityQueue<Node> que = new PriorityQueue<>();

		que.add(new Node(start, 0));
		length[start] = 0;

		while (!que.isEmpty()) {

			Node endNode = que.poll();

			if (length[endNode.cur] >= endNode.dis) {

				for (int i = 0; i < graph.get(endNode.cur).size(); i++) {

					Node adjNode = graph.get(endNode.cur).get(i);

					if (length[adjNode.cur] > length[endNode.cur] + adjNode.dis) {

						length[adjNode.cur] = length[endNode.cur] + adjNode.dis;

						que.add(new Node(adjNode.cur, length[endNode.cur] + adjNode.dis));

					}

				}

			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		length = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {

			graph.add(new ArrayList<Node>());
			length[i] = INF;
		}

		for (int i = 0; i < E; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a,c));

		}

		st = new StringTokenizer(br.readLine(), " ");

		must1 = Integer.parseInt(st.nextToken());
		must2 = Integer.parseInt(st.nextToken());

		dij(1);

		int m1Dis = length[must1];

		for (int i = 0; i < N + 1; i++) {
			length[i] = INF;
		}
		
		dij(must1);
		
		int m2Dis = length[must2];
		
		for (int i = 0; i < N + 1; i++) {
			length[i] = INF;
		}
		
		dij(must2);
		
		int nDis = length[N];

		for (int i = 0; i < N + 1; i++) {
			length[i] = INF;
		}		
		
		int case1Answer = m1Dis + m2Dis+nDis;
		////////////////////////////////////////////////////////////
		
		dij(1);

		m2Dis = length[must2];

		for (int i = 0; i < N + 1; i++) {
			length[i] = INF;
		}
		
		dij(must2);
		
		m1Dis = length[must1];
		
		for (int i = 0; i < N + 1; i++) {
			length[i] = INF;
		}
		
		dij(must1);
		
		nDis = length[N];
		
		int case2Answer = m1Dis + m2Dis+nDis;
		
		int min = Math.min(case1Answer, case2Answer);
		
		if(min >= INF) System.out.println(-1);
		
		else System.out.println(min);
		
	}

}
