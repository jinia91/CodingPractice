package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1005 {

	static int[] memoTime;
	static int[] Time;

	static ArrayList<ArrayList<Integer>> graph;

	static int[] degree;

	static int N, K, W, rs;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			memoTime = new int[N + 1];
			
			Time = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {

				Time[j] = Integer.parseInt(st.nextToken());

			}

			graph = new ArrayList<>();
			degree = new int[N + 1];
			degree[0] =1;

			for (int j = 0; j < N + 1; j++) {

				graph.add(new ArrayList<>());

			}

			for (int j = 0; j < K; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				int s = Integer.valueOf(st.nextToken());
				int e = Integer.valueOf(st.nextToken());

				graph.get(s).add(e);

				degree[e]++;
			}

			W = Integer.parseInt(br.readLine());
			
			System.out.println(ps());

		}

	}

	static int ps() {

		LinkedList<Integer> que = new LinkedList<>();
		int rs = 0;
		
		for(int i=0; i<N+1; i++) {
			if(degree[i]==0) {
				memoTime[i] = Time[i];
				que.add(i);
			
			}
		}
		
		
		
		while(!que.isEmpty()) {
			
			int node = que.poll();
			
			if(node == W) return memoTime[node];
			
			for(int i =0; i< graph.get(node).size(); i++) {
				
				int next = graph.get(node).get(i);
				
				degree[next]--;
				
				memoTime[next] = Math.max(memoTime[next], memoTime[node]+Time[next]);
				
				if(degree[next] == 0){
					
					que.add(next);
					
				}
				
			}
			
		}
		
		return -1;
		
	}

}
