package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1644 {

	static boolean[] prime;
	static int cnt;

	static void eraPrime(int x) {

		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(x); i++) {

			if(prime[i] == true) continue;
			
			for(int j = 2; i*j<= x; j++) {
				
				prime[i*j] = true;
				
			}
			
			
		}

	}
	
	static void twoPoint(int x) {
		
		int sum = 0;
		int start =0;
		int end = 0;
		
		for(int i = 0; i<=x; i++) {
			
			if(prime[i] == false) {
				
				start = i;
				end = i;
				break;
			}
		}
		
		
		for(int i = start; i<=x; i++) {
			
			if(prime[i] == true) continue;
			
			
			while(sum<x&& end <= x) {
				
				if(prime[end]== true) {
					end++;
					continue;
				}
				
				sum += end;
				end++;
				
			}
			
			if(sum == x) {
				cnt++;
			}
			
			sum -= i;
			
		}
		
	}
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		
		prime = new boolean[x+1];	
		
		eraPrime(x);
		twoPoint(x);
		
		System.out.println(cnt);
		
		
		
		
	}

}
