package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1707 {

	static StringTokenizer st;
	static int V, E;
	static ArrayList<ArrayList<Integer>> graph;
	// 사이클링 판단위해 방문 지점을 1과 -1로 번갈아 기록
	static int[] checked;

	static boolean isNotCycle(int x) {

		LinkedList<Integer> que = new LinkedList<>();

		if (checked[x] == 0) {
			que.add(x);
			checked[x] = 1;
		}

		while (!que.isEmpty()) {

			int start = que.poll();

			ArrayList<Integer> node = graph.get(start);

			for (int i = 0; i < node.size(); i++) {

				int end = node.get(i);

				// 방문지점이 이미 방문했으며, 시작지점이랑 같은 기록인경우 = cycle
				if (checked[start] == checked[end]) {
					return false;
				}

				// 양방향간선을 다시 타는 케이스
				if (checked[end] != 0)
					continue;

				// 기록
				if (checked[start] == 1)
					checked[end] = -1;
				else
					checked[end] = 1;

				que.add(end);

			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			V= Integer.parseInt(st.nextToken());
			E= Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			
			for(int i =0; i<V+1; i++) {
				
				graph.add(new ArrayList<>());
				
			}
			
			checked = new int[V+1];
			
			for(int i =0; i<E; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				graph.get(b).add(a);
				
				
			}
			
			boolean flag = true;
			for(int i =1; i<=V; i++) {
				
				if(!isNotCycle(i)) {
				
					flag = false;
					break;
				};
				
			}
			
			if(flag) sb.append("YES\n");
			else sb.append("NO\n");
			
		}
		
		System.out.println(sb);
	}

}
