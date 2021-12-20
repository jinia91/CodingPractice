package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2292 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cri = 1;
		
		int index = 0;
		
		for(int i =0; i<Integer.MAX_VALUE; i++) {
			

			cri += 6*i;
			
			if(N <= cri) {
				index = i;
				
				break;
			}
			
			
		}
		
		System.out.println(index+1);
		
		
	}

}
