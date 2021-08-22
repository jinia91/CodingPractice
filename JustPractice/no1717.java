import java.util.*;
import java.io.*;



public class no1717 {

	static int[] parent;
	
	
	static int find (int x) {
		
		if(parent[x] == x) return x;
		
		else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
		
	}
	
	static void union (int x, int y) {
		
		x = find(x);
		y = find(y);
		
		
		if(x==y) {
			return;
		}
		if(x>y) {parent[x] = y;}
		else {parent[y] = x;}
		
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		parent = new int[N+1];
		
		for(int i = 0; i < N+1; i++) {
			
			parent[i] = i;
			
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i <M; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int z = Integer.valueOf(st.nextToken());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			
			if(z == 0) {
				union(a, b);
			}
			else {
				if(find(a)==find(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}

		}
		
		System.out.println(sb);
		
	}

}
