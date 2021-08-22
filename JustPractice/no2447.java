	import java.util.*;
	
	
	public class no2447 {
	
		static int[][] board;     // 보드
			
	
		static void starFunction(int N) {  // 별찍기 좌표 초기화 메소드
			int X = 0, Y=0;
			
			star(N, X, Y);
		}
		
		
		
		static void star(int N, int X, int Y) {    // 9분할 재귀 수행 메소드
			
			
		 if (N ==1) return;                        // 재귀 탈출구문
	
		 int count = 0;
		 
		 for(int i=X; i<X + N; i += N/3) {        // 보드 9분할 함수
			  
			for(int j = Y; j< Y + N; j+= N/3) {
				
				count++; 
					
				if(count == 5) {                 // 9분할 중앙에 공백출력 조건
				
					makeblank(N,i,j);
				
				}
				else {                          // 9분할 나머지엔 재귀 돌입
					
					star(N/3, j, i);
					
				}	
			}
			
		  }
	  
		 
		}	
		
	
		static void makeblank(int N, int X, int Y) {  // 공백 식별 메소드
			
			for(int i = X; i< X+N/3; i++) {
				
				for (int j = Y; j<Y+N/3; j++)
					
					board[i][j] = 1;	
			}
			
		}
		
		
		public static void main(String[] args) {
			
			Scanner S = new Scanner(System.in);
			
			int N = S.nextInt();
			
			
			
			board = new int[N][N];
					
		
			starFunction(N);
			
		 	
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i<N; i ++) {       // 보드판 0,1로 그림 만드는함수
				
				for (int j =0; j< N; j++) {
					
					if(board[i][j]==0) {
						sb.append("*");
					}
					else {
						sb.append(" ");
					}
					
					
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
		
		}
	
	
	}
