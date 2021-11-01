package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2417 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long input = Long.parseLong(br.readLine());
		
		
		double sqrt = Math.sqrt(input);
		
	
		long s = (long)sqrt;
		
		if(s*s == input) System.out.println(s);
		else System.out.println(s+1);
		
	}

}
