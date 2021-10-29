package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no10872 {

	static int result = 1;
	
	static void facto(int i) {
		
		if(i<1) return;
		
		result = result*i;
		
		i--;
		
		facto(i);
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		facto(input);
		System.out.println(result);
		
	}

}
