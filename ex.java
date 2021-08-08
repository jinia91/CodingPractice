import java.util.*;
import java.io.*;



public class ex {

	
	
	static int checkPoint(String S) {
		
		int cnt = 0;
		int sum = 0;
		
		
		for(int i = 0 ; i < S.length(); i++) {
			
			
			if(S.charAt(i) == 'O') {
				
				cnt++;
				
				sum += cnt;
			}
			
			else {
				
				cnt = 0;
				
			}
			
		}
		
		return sum;
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		
		
		for(int i = 0; i<N; i++) {
			
			String S = br.readLine();
			
			System.out.println(checkPoint(S));
			
			
		}
		
		
		
	}

}
