package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a,b,d;
	
	public Edge(int a, int b, int d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.d-o.d;
	}
}

public class no1197 {
	
	static int[] pNode;
	static Edge[] edgeSet;
	static int dSum;
	
	static int find(int x) {
		if(pNode[x] == x) return x;
		
		else return pNode[x] = find(pNode[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x > y) pNode[x] = y;
		else pNode[y] = x;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		pNode = new int[V+1];
		
		for(int i =0; i<V+1; i++) {
			pNode[i] = i;
		}
		
		edgeSet = new Edge[E];
		
		
		for(int i =0; i<E;i++) {
		
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
		
			edgeSet[i] = new Edge(a,b,c);
		}
		
		Arrays.sort(edgeSet);
		
		for(Edge tmp : edgeSet) {
			
			int nodeA = tmp.a;
			int nodeB = tmp.b;
			
			if(find(nodeA) !=find(nodeB)) {
				
				union(nodeA, nodeB);
				dSum += tmp.d;
			}
			
		}
		
		System.out.println(dSum);
	}

}
