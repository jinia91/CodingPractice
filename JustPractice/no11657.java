import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	
	int start;
	int end;
	long distance;
	
	Edge(int a, int b, int c){
		start = a;
		end = b;
		distance = c;
	}
	
}


public class no11657 {

	static Edge[] edges;
	static final long INF = Long.MAX_VALUE;
	static long[] shortdis;
	
	
	static boolean bf(int start, int N, int M){
		shortdis[start] = 0L;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if( shortdis[edges[j].start] != INF && shortdis[edges[j].end]>shortdis[edges[j].start] + edges[j].distance) {
					shortdis[edges[j].end] = shortdis[edges[j].start] + edges[j].distance;
					
					if(i==N-1) return false;
				}
				
			}
			
		}
		
		return true;
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		edges = new Edge[M];
		
		for(int i = 0 ; i< M ; i++) {
			
			st= new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			edges[i] = new Edge(a,b,c);
			
		}
		
		shortdis = new long[N+1];
		Arrays.fill(shortdis, INF);
		
		boolean flag = bf(1, N, M);

		if(!flag) {
			
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i<N+1; i++) {
			
			if(shortdis[i] == INF) {
				
				sb.append(-1).append("\n");
				continue;
			}
			
			sb.append(shortdis[i]).append("\n");
					
		}
		
		System.out.println(sb);
		
	}

}
