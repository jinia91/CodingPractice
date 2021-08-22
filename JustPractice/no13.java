import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no13 {

	static boolean function(int x) {		
		int number = x;
		if (number>=100) {
			while(number >= 100) {
				boolean distint = (number/10%10-number/100%10)
						!=(number%10-number/10%10);
				if(distint) return false;
				number = number/10;
				}
			}
	return true;
}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int count =0;
		
		for(int i=1; i<=N;i++) 
			if (function(i)) count++;
				
		System.out.println(count);
	}
}
