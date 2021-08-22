import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class node5 implements Comparable<node5>{
	
	int index;
	int dis;
	
	node5(int index, int dis){
		this.index = index;
		this.dis = dis;
		
	}
	
	int getindex() {return index;}
	int getdis() {return dis;}
	
	

	@Override
	public int compareTo(node5 o) {

		return this.dis - o.dis;
		
	}

	
	
}


public class no1753 {
	
	static ArrayList<ArrayList<node5>> graph = new ArrayList<>();

	static final int INF = 1000000000;
	
	static int[] table = new int[20001];
	
	
	static void dij(int start) {
		
		PriorityQueue<node5> pq = new PriorityQueue<>();
		
		table[start] = 0;
		
		node5 node = new node5(start, 0);
		
		pq.offer(node);
		
		
		while(!pq.isEmpty()) {

			node5 nodes = pq.poll();
			int now = nodes.index;
			int dis = nodes.dis;
			
			if(table[now] < dis) continue;
			
			for(int i =0; i<graph.get(now).size(); i++) {
				
				int cost = table[now] + graph.get(now).get(i).dis;
				if(cost < table[graph.get(now).get(i).index]) {
					table[graph.get(now).get(i).index] = cost;
					pq.offer(new node5(graph.get(now).get(i).index, cost));
				}
			}
		}
		
	}
	
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.valueOf(st.nextToken());
		int E = Integer.valueOf(st.nextToken());
		
		int start = Integer.valueOf(br.readLine());
		
		Arrays.fill(table, INF);
		
		
		for(int i = 0; i<V+1; i++) {
			
			graph.add(new ArrayList<node5>());
			
			
		}
		
		
		
		for(int i = 0 ; i< E ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			int u = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());
			
			graph.get(u).add(new node5(v,w));
			
			
		}
		
		dij(start);
		
		for(int i = 1; i<V+1; i++) {
			
			if (table[i] == 1000000000) {System.out.println("INF");}
			
			else {System.out.println(table[i]);}
			
			
		}
		
		
	}

}
