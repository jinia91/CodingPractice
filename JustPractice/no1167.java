
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {

	ArrayList<int[]> adjNodes = new ArrayList<>();

}

public class no1167 {

	static int V, maxLenth, longNode;
	static StringTokenizer st;
	static ArrayList<Node> graph = new ArrayList<>();
	static boolean[] visited;
	
	static void dfs(int cur, int dis) {
		
		visited[cur] = true;
		
		for(int i = 0; i<graph.get(cur).adjNodes.size(); i++) {
			int[] adj = graph.get(cur).adjNodes.get(i);
			
			if(!visited[adj[0]]) {
				
				if(maxLenth<dis+adj[1]) {
					
					maxLenth = dis+adj[1];
					longNode = adj[0];
				}
				
				dfs(adj[0], dis+adj[1]);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		visited = new boolean[V+1];

		for(int i = 0; i< V+1; i++) {
			
			graph.add(new Node());
			
		}

		for (int i = 1; i <= V; i++) {


			st = new StringTokenizer(br.readLine(), " ");

			int idx = Integer.parseInt(st.nextToken());

			while (true) {

				int adj = Integer.parseInt(st.nextToken());
				if (adj == -1)
					break;

				int edge = Integer.parseInt(st.nextToken());

				int[] adjNode = { adj, edge };

				graph.get(idx).adjNodes.add(adjNode);

			}

		}
		
		dfs(1,0);
		
		visited = new boolean[V+1];
		maxLenth = 0;

		dfs(longNode,0);
		
		System.out.println(maxLenth);
		
		

	}

}
