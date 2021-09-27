package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16926 {

	static int[][] arr;
	static int[][] tmp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());
		
		arr = new int[N][M];
		tmp = new int[N][M];
		
		for(int i = 0; i< N; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
			
		}
		
		for(int r =0; r< R; r++) {

			// <-- ÀÌµ¿	
			for(int i = 0; i<N-1/2) {
				
				for(int j = M-1; j<=1; j--) {
				arr[0][i] = tmp[0][i-1];
				}
				
				
				
			}
			
			
			
		}
		
	}

}
