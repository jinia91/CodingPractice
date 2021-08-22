import java.util.*;
import java.io.*;

class node {

	int n;
	int m;
	int distant;
	
	node(int n, int m, int d){
		this.n=n;
		this.m=m;
		distant=d;
	}
}

public class mo2178 {
	
	static void bfs_search(int N, int M) {
		
		LinkedList<node> que = new LinkedList<>();
		
		int n = 0;
		int m = 0;
		int d = 1;
		
		
		que.offer(new node(n,m,d));
		map[n][m]=0;
		
		while(!que.isEmpty()) {
			node x =que.poll();
			
			n = x.n;
			m = x.m;
			
			
			if (n==N&&m==M) {
				d=x.distant;
				break;
			}
		
			if(m+1<=M&&map[n][m+1]==1)	{
			que.offer((new node(n,m+1,x.distant+1))); map[x.n][x.m+1]=0;}					
			if(m-1>=0&&map[n][m-1]==1) {
			que.offer((new node(n,m-1,x.distant+1))); map[x.n][x.m-1]=0;}				
			if(n+1<=N&&map[n+1][m]==1)	{
			que.offer((new node(n+1,m,x.distant+1))); map[x.n+1][x.m]=0;}					
			if(n-1>=0&&map[n-1][m]==1) {
			que.offer((new node(n-1,m,x.distant+1))); map[x.n-1][x.m]=0;}					
		}
		
		System.out.println(d);
		
	}
	

	static int map[][];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		map = new int[N][M];
		
		for(int i =0; i < N; i++) {
			
			String mapLine = br.readLine();
			
			for(int j = 0; j<M;j++) {
				
				map[i][j]=mapLine.charAt(j)-'0';
				
			}
			
		}
		
		
		bfs_search(N-1, M-1);
	}

}
