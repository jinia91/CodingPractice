package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no2056 {

	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] memoT;
	static int[] time;
	static int[] degree;
	static int max;

	static int ps() {

		LinkedList<Integer> que = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {

			if (degree[i] == 0) {

				que.add(i);
				memoT[i] = time[i];
			}

		}

		while (!que.isEmpty()) {

			Integer node = que.poll();

			max = Math.max(max, memoT[node]);
			
			for (int i = 0; i < graph.get(node).size(); i++) {

				Integer next = graph.get(node).get(i);
			
				memoT[next] = Math.max(memoT[next], memoT[node]+time[next]);
				
				degree[next]--;
				
				if(degree[next] == 0) {
					
					que.add(next);
					
				}
			
			}

		}

		return max;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		
		for(int i = 0; i<N+1; i++) {
			
			graph.add(new ArrayList<Integer>());
			
		}
		
		
		memoT = new int[N + 1];
		time = new int[N + 1];
		degree = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			time[i] = Integer.parseInt(st.nextToken());

			int n = Integer.parseInt(st.nextToken());

			degree[i] = n;

			for (int j = 0; j < n; j++) {

				graph.get(Integer.parseInt(st.nextToken())).add(i);
			}

		}

		
		
		System.out.println(ps());
		
	}

}
