package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1516 {

	static StringTokenizer st;

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

	static int N;
	static int[] time;
	static int[] memoT;
	static int[] degree;

	static void ps() {

		LinkedList<Integer> que = new LinkedList<>();
		
		int rs = 0;

		for (int i = 1; i < N + 1; i++) {

			if (degree[i] == 0) {
				que.add(i);
				memoT[i] = time[i];
			}
		}
		
		while(!que.isEmpty()) {
			
			int node = que.poll();
			
			rs = Math.max(rs, memoT[node]);
			
			for(int i=0; i< graph.get(node).size();i++) {
				
				int next = graph.get(node).get(i);
				
				memoT[next] = Math.max(memoT[next], memoT[node]+time[next]);
				
				degree[next]--;
				
				if(degree[next] == 0) {
					
					que.add(next);
					
				}
				
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph.add(new ArrayList<>());
		
		time = new int[N + 1];
		memoT = new int[N + 1];
		degree = new int[N + 1];

		for(int i =0; i<N+1; i++) {
			
			graph.add(new ArrayList<>());			
		}
		
		
		
		for (int i = 1; i < N + 1; i++) {

			String str = br.readLine();
			
			st = new StringTokenizer(str, " ");


			time[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int x = Integer.parseInt(st.nextToken());
				if (x == -1)
					break;

				graph.get(x).add(i);
				degree[i]++;

			}
		}
		
		ps();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1 ; i<memoT.length; i++) {
			
			sb.append(memoT[i]).append("\n");
			
		}
		
		System.out.println(sb);

	}

}
