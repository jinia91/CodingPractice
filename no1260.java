import java.io.*;
import java.util.*;

public class no1260 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int V = Integer.valueOf(st.nextToken());
		
		
		graph g = new graph(N);
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());	
			int y = Integer.valueOf(st.nextToken());
			g.addege(x, y);
		}
		
		g.dfs(V);
		g.markedoff();
		g.bfs(V);
	}	

}


class graph{
	
	class node{
		int data;
		LinkedList<Integer> adj;
		boolean marked;
		
		node(int data){
			this.data = data;
			adj = new LinkedList<Integer>();
			marked = false;
		}
	}
	
	node[] nodes;
	
	graph(int N){
		nodes = new node[N+1];
		for(int i = 0; i < N+1; i++) nodes[i] = new node(i);
	}
	
	
	void addege(int x, int y) {
		if(!nodes[x].adj.contains(y)) {nodes[x].adj.add(y);}; 
		if(!nodes[y].adj.contains(x)) {nodes[y].adj.add(x);}; 
		}

	
	StringBuilder st = new StringBuilder();	

	void dfs(int V) {
		
		node f = nodes[V];
		dfs(f);
		System.out.println(st);
		st.setLength(0);
		
	}
	
	void dfs(node f) {
				
		f.marked = true;
		st.append(f.data).append(" ");
		
		Collections.sort(f.adj);
		Iterator<Integer> it = f.adj.iterator();
		
		while(it.hasNext()) {
			int adjNode = it.next();
			if(nodes[adjNode].marked==false) 
				dfs(nodes[adjNode]);	
		}
	}
	
	void markedoff() {
		for(int i = 0; i < nodes.length;i++) {
			nodes[i].marked = false;
		}
	}
	
	void bfs(int V) {
		node root = nodes[V];
		LinkedList<node> que = new LinkedList<>();
		que.offer(root);
		root.marked = true;
		
		while(!que.isEmpty()) {
			node f = que.poll();
			Collections.sort(f.adj);
			Iterator<Integer> it = f.adj.iterator();
				while(it.hasNext()) {
					int adnodeidx = it.next();
					if(nodes[adnodeidx].marked==false) {
						nodes[adnodeidx].marked=true;
						que.offer(nodes[adnodeidx]);
					}
				}
			st.append(f.data).append(" ");
		}
		System.out.println(st);
		
	}

}
