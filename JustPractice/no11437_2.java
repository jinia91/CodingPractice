package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no11437_2 {

	static int N,M;
	static StringTokenizer st;
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] check;
	static int[] parent;
	static int[] dept;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		check = new boolean[N+1];
		parent = new int[N+1];
		dept = new int[N+1];
		
		for(int i =0; i< N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N-1; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			
			graph.get(nodeA).add(nodeB);
			graph.get(nodeB).add(nodeA);
			
		}
		
		dfs(1,0,1);
		
		M = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		
		for(int i =0; i<M; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");

			int tarA = Integer.parseInt(st.nextToken());
			int tarB = Integer.parseInt(st.nextToken());

			
			answer.append(lca(tarA,tarB)).append("\n");
			
		}
		
		System.out.print(answer);

	}
	
	static void dfs(int node, int d, int pNode) {
		
		parent[node] = pNode;
		pNode = node;
		check[node] = true;
		if(dept[node] != 0) return;
		
		for(int i =0; i< graph.get(node).size(); i++) {
			
			int cNode = graph.get(node).get(i);
			
			if(check[cNode]) continue;
			
			dfs(cNode, d+1, pNode);
		}
		
		dept[node] = d;
		
	}
	
	static int lca(int tarA, int tarB) {
		
		if(dept[tarA]>dept[tarB]) {
			while(dept[tarA]!=dept[tarB]) {
				tarA= parent[tarA];
			}
		}
		
		else if(dept[tarA]<dept[tarB]) {
			while(dept[tarA]!=dept[tarB]) {
				tarB= parent[tarB];
			}
		}
		
		while(tarA!=tarB) {
			tarA = parent[tarA];
			tarB = parent[tarB];
		}
		
		return tarA;
	}

}
