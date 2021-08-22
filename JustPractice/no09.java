import java.util.*;

public class no09 {

	public static void main(String[] args) {
		
		Scanner S = new Scanner(System.in) ;
		
		int N = S.nextInt();
		int count = 0;
		
		
		for (int i = 0 ;  i < N; i++) {
			int n = S.nextInt();
			if (Sosu(n) == true) count++;
			}
			
		System.out.println(count);
	
	}
		

	

	static boolean Sosu(int number) {
		if(number == 1) return false;
	
		for(int i = 2; i <= Math.sqrt(number) ; i++) {
			
			if(number%i == 0 && i != number) {
				return false; 
			}
		}
	return true;
	}
	
}
