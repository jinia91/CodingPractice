package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class edge{
	
	int start;
	int end;
	int dis;
	
	edge(int s, int e, int d){
		
		start = s;
		end = e;
		dis = d;
		
	}
	
}


public class no1865 {

	static long[] memo; 
	static int N,M,W;
	static long INF = Long.MAX_VALUE;
	static ArrayList<edge> edgeSet;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i =0; i<T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			edgeSet = new ArrayList<>();
			
			for(int j =0; j<M; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				
				edgeSet.add(new edge(s,e,t));
				edgeSet.add(new edge(e,s,t));
				
			}
			
			for(int j =0; j<W; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = -Integer.parseInt(st.nextToken());
				
				edgeSet.add(new edge(s,e,t));
				
			}
			
			if(bf(edgeSet.get(1).start))
			System.out.println("NO");
			else System.out.println("YES");
		}
		
	}
	
	
	static boolean bf(int start) {
		
		memo = new long[N+1];
		
		memo[start] = 0;
		
		for(int i = 0; i<N;i++) {
			for(int j =0; j<edgeSet.size(); j++) {
				edge edge = edgeSet.get(j);
				
				long st = memo[edge.start];
				long end = memo[edge.end];
				int dis = edge.dis;
				
				if(memo[edge.end]>memo[edge.start]+edge.dis) {
					memo[edge.end] = memo[edge.start]+edge.dis;
					if(i == N-1) return false;		
				}
			}
			
		}
		
		return true;
	}

}
