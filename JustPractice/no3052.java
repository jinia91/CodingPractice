package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no3052 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int[] arr = new int[42];

		int N = 10;
		
		while(N-->0) {
			
			int x = Integer.parseInt(br.readLine());
			
			arr[x%42]++;
			
		}
		
		int sum = 0;
		
		for(int i : arr) {
			if(i>0) sum++;
		}
		
		
		System.out.println(sum);
		
	}

}
