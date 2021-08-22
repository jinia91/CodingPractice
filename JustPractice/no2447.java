	import java.util.*;
	
	
	public class no2447 {
	
		static int[][] board;     // ����
			
	
		static void starFunction(int N) {  // ����� ��ǥ �ʱ�ȭ �޼ҵ�
			int X = 0, Y=0;
			
			star(N, X, Y);
		}
		
		
		
		static void star(int N, int X, int Y) {    // 9���� ��� ���� �޼ҵ�
			
			
		 if (N ==1) return;                        // ��� Ż�ⱸ��
	
		 int count = 0;
		 
		 for(int i=X; i<X + N; i += N/3) {        // ���� 9���� �Լ�
			  
			for(int j = Y; j< Y + N; j+= N/3) {
				
				count++; 
					
				if(count == 5) {                 // 9���� �߾ӿ� ������� ����
				
					makeblank(N,i,j);
				
				}
				else {                          // 9���� �������� ��� ����
					
					star(N/3, j, i);
					
				}	
			}
			
		  }
	  
		 
		}	
		
	
		static void makeblank(int N, int X, int Y) {  // ���� �ĺ� �޼ҵ�
			
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
			
			for(int i = 0; i<N; i ++) {       // ������ 0,1�� �׸� ������Լ�
				
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
