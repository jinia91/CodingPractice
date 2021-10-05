package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no11724 {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringTokenizer st;
	static int N, M, cnt;

	private static void bfs(int i) {

		LinkedList<Integer> que = new LinkedList<>();

		if(visited[i]) return;
		
		visited[i] = true;
		
		que.add(i);
		
		while(!que.isEmpty()) {
			
			int node = que.poll();
			
			for(int n = 0; n< graph.get(node).size(); n++) {
				
				int nextNode = graph.get(node).get(n);
				
				if(!visited[nextNode]) {
					que.add(nextNode);
					visited[nextNode] = true;
				}
				
			}
		}
		
		cnt++;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {

			graph.add(new ArrayList<Integer>());

		}

		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);

		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		System.out.println(cnt);
		
	}

}
