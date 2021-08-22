import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2630 {

	static int whiteCnt =0;
	static int blueCnt =0;
	static int[][] board;
	
	
	static boolean check(int r, int c, int N) {
		
		int color = board[r][c];
		
		for(int i = r; i< r+N; i++) {
			for(int j = c; j< c+N; j++) {
				
				if(color != board[i][j]) return false;
				
			}
			
		}
		
		return true;
	}
	
	
	
	static void divQ(int r, int c, int N) {
		
		if(check(r,c,N)) {
			
			if (board[r][c] == 1) blueCnt++;
			else whiteCnt++;
		
			return;
		}
		
		
		N = N/2;
		
		divQ(r,c,N);
		divQ(r+N,c,N);
		divQ(r,c+N,N);
		divQ(r+N,c+N,N);
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		board = new int[N][N];
		
		
		for(int i = 0 ; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				board[i][j]  = Integer.valueOf(st.nextToken());
			}
		}
		
		
		divQ(0,0,N);
		
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}

}
