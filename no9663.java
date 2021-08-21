import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;




public class no9663 {
	

	static int N, cnt;
//	static Stack<Integer> rowX = new Stack<>();
	static int[] rowX;
	
	static boolean putable(int x, int y) {
		
		if (x == 0) return true;
		
		for(int qX =0; qX<x;qX++) {
			
			int qY =rowX[qX];
			
			if(qX == x||
				qY == y||
				Math.abs(qX-x) == Math.abs(qY-y)
				) {
				return false;
			}
			
		}
		
		return true;
		
	}
	
	
	static void backtracking(int nowX) {

		if(nowX == N) {			
			cnt++;
			return;
		}
		
		for(int y =0; y < N; y++) {
			
				if(putable(nowX,y)) {
					rowX[nowX] = y;
					backtracking(nowX+1);
				}
				
		}
		
	}
		
				

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		N = Integer.parseInt(br.readLine());
		
		rowX = new int[N];
		
	
		backtracking(0);
		System.out.println(cnt);
		
		
	}

}
