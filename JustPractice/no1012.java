import java.util.*;
import java.io.*;


public class no1012 {

	static int[][] map;
	
	static int count =0;
	
	static void dfscount(int x, int y, int M, int N) {
		
		if(map[x][y]==1) count ++;
		dfs(x,y,M,N);
	}
	
	
	
	static void dfs(int x, int y,int M, int N) {
		if(map[x][y]==1) {
			map[x][y] = 0;
			if (y+1<M) dfs(x,y+1,M,N);
			if (y-1>=0) dfs(x,y-1,M,N);
			if (x+1<N) dfs(x+1,y,M,N);
			if (x-1>=0) dfs(x-1,y,M,N);
		}		
	}
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int M = Integer.valueOf(st.nextToken());
			int N = Integer.valueOf(st.nextToken());
			int K = Integer.valueOf(st.nextToken());
			
			map = new int[N][M];
			
			
			for(int j =0; j<K; j++) {
				
				st = new StringTokenizer(br.readLine()," ");
				
				int X = Integer.valueOf(st.nextToken());
				int Y = Integer.valueOf(st.nextToken());
				
				map[Y][X] = 1;
			}
			
			
			
			for(int x=0; x<N;x++) {
				for(int y=0; y<M; y++) {
					dfscount(x,y,M,N);
				}
			}
			
			sb.append(count).append("\n");
			count =0;
			
		}
		
		System.out.println(sb);
		
		
		
		
	}

}
