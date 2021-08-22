import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no11404 {

	
	static final int INF = 1000000000;
	
	static int[][] table;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		table = new int[n+1][n+1];
		
		for(int i =0; i<n+1; i++) {
			
			Arrays.fill(table[i], INF);
			for(int j = 0; j<n+1; j++) {
				
				if(i==j) table[i][j] =0;
				
			}
			
			
		}
		
		
		for(int i = 0 ; i< m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			
			
			table[a][b] = Math.min(table[a][b], c);
			
			
		}
		
		
		for(int k =1; k<n+1; k++) {
			for(int i = 1; i< n+1; i++) {
				for(int j =1; j< n+1; j++) {
					table[i][j] = Math.min(table[i][j], table[i][k]+table[k][j]);
				}
			}
		}

		
		StringBuilder sb = new StringBuilder();

		for(int i =1; i<n+1; i++) {
			
			for(int j =1; j<n+1; j++) {
				
				if(table[i][j]==INF) sb.append(0).append(" ");
				
				else sb.append(table[i][j]).append(" ");	
				
			}
			
			sb.append("\n");
		}
	
		System.out.println(sb);
		
	}

}

