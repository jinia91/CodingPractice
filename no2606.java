import java.util.*;
import java.io.*;


public class no2606 {

	static private ArrayList<ArrayList<Integer>> graph;
	static private boolean[] marked;
	static private int cnt = 0;
	
	static private void graphmake(int num) {
		graph = new ArrayList<>();
		
		for (int i = 0; i <= num; i ++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	
	static private void dfs(int N) {
		marked[N] = true;
		
		for(int i = 0; i<graph.get(N).size();i++) {

			int adj = graph.get(N).get(i);
			
			if(marked[adj]==false) {
				marked[adj] = true;
				cnt++;
				dfs(adj);
				}
		}
			
	}
		
	static private void addAdj(int x, int y) {
		if(!graph.get(x).contains(y)) graph.get(x).add(y);
		if(!graph.get(y).contains(x)) graph.get(y).add(x);
	}
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.valueOf(br.readLine());
		int line = Integer.valueOf(br.readLine());
		
		marked = new boolean[num+1];
		
		graphmake(num);
		
		for(int i = 0 ; i < line; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			
			addAdj(x,y);
		}
				
		dfs(1);
		
		System.out.println(cnt);
		
	}

}
