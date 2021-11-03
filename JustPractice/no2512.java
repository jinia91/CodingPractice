package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2512 {

	static int N, M, sum, max;
	static StringTokenizer st;
	static int[] budgetR;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		budgetR = new int[N];

		for (int i = 0; i < N; i++) {

			budgetR[i] = Integer.parseInt(st.nextToken());

			sum += budgetR[i];
			max = Math.max(max, budgetR[i]);
		}

		M = Integer.parseInt(br.readLine());

		System.out.println(binarySearch());


	}

	private static int binarySearch() {

		int start = M / N;
		int end = max+1;

		while (start < end) {

			int mid = (start + end) / 2;
		
			if(cal(mid)<=M) {
				

				start = mid+1;
				
			}
			
			else {
				
				end = mid;
				
				
			}
		
		
		
		}
		
		return end-1;

	}

	private static int cal(int mid) {

		int sum = 0;
		
		for(int x : budgetR) {
			
			if(mid >= x) {
				
				sum += x;
				
			}
			
			else {
				
				sum += mid;
				
			}
			
			
		}	
		
		return sum;
		
	}

}
