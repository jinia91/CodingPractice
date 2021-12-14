package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no4344 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		while(N-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			int sum =0;
			
			int[] arr = new int[n]; 
			
			for(int i =0; i<n; i++) {
				
				arr[i] =  Integer.parseInt(st.nextToken());
				
				sum += arr[i];
				
			}
		

			int avr = sum/n;
			
			int cnt = 0;
			
			for(int x : arr) {
				
				if(x > avr) cnt++;
				
			}
			
			System.out.printf("%.3f%%%n",(cnt/(double)n)*100);
			
		}
		
	}

}
