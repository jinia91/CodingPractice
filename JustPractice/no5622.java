package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no5622 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		
		int sum = 0;
		
		for(int i =0; i< input.length(); i++) {
			
			if(65<=input.charAt(i)&&input.charAt(i)<=67) {
				
				sum += 3;
				
			}
			
			else if(68<=input.charAt(i)&&input.charAt(i)<=70) {
				
				sum += 4;
				
			}else if(71<=input.charAt(i)&&input.charAt(i)<=73) {
				
				sum += 5;
				
			}else if(74<=input.charAt(i)&&input.charAt(i)<=76) {
				
				sum += 6;
				
			}else if(77<=input.charAt(i)&&input.charAt(i)<=79) {
				
				sum += 7;
				
			}else if(80<=input.charAt(i)&&input.charAt(i)<=83) {
				
				sum += 8;
				
			}else if(84<=input.charAt(i)&&input.charAt(i)<=86) {
				
				sum += 9;
				
			}else if(87<=input.charAt(i)&&input.charAt(i)<=90) {
				
				sum += 10;
			}			
			
			
			
		}
		
		
		System.out.println(sum);
		
	}

}
