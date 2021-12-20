package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;

		int index = 0;
		
		for(int i = 1; i< Integer.MAX_VALUE; i++) {
			
			sum += i;
			
			if(sum >= N) {
				index = i;
				break;
			}
			
		}

		int x = N-(sum-index);
		
		if(index % 2 == 0) {
			
			System.out.println(x+"/"+(index-(x-1)));			
			
		}
		
		else {
			
			System.out.println(index-(x-1)+"/"+x);
			
		}
		
		
	}

}
