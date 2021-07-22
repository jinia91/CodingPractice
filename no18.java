import java.util.*;

public class no18 {
		
	public static void main(String[] args) {
			
		Scanner S = new Scanner(System.in);
		
		int N = S.nextInt();
		int M = S.nextInt();

		boolean[][] sheet = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String row =S.next();
			for(int j = 0; j<M;j++) {
				if(row.charAt(j)=='W') 
					sheet[i][j] = true;
			}
		}
		
		ArrayList countList1 = new ArrayList();
		for(int X = 0; X<N-7 ;X++) {
			for (int Y = 0; Y<M-7 ; Y++){
	
				int count1 = 0;	
			
				for(int i = X; i< X+8; i++) {					
					for(int j = Y; j < Y+8; j++) {
						boolean even;
						if((i+j)%2 == 0) even = true;
						else even = false;
				
						if (even == sheet[i][j]) {
							count1++;
						}	
					}	
				}
			countList1.add(64-count1);
			}
		}

	int x=(int) Collections.min(countList1);
		
	
	
	
	ArrayList countList2 = new ArrayList();
		for(int X = 0; X<N-7 ;X++) {
			for (int Y = 0; Y<M-7 ; Y++){
			
				int count1 = 0;	

				for(int i = X; i< X+8; i++) {
						
						for(int j = Y; j < Y+8; j++) {
							boolean even;
							if((i+j)%2 != 0) even = true;
							else even = false;
				
							if (even == sheet[i][j]) {
								count1++;
							}	
						}	
					}
			countList2.add(64-count1);		
			}
			
		}
		
	int y=(int) Collections.min(countList2);
		
	
	
System.out.println(x>y?y:x);		

	}

}
