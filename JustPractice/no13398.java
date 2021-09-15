package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no13398 {

	static int N, max;
	static int[] arr;

	static int[] memo;
	static int[] memo2;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i  =0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		
		memo = new int[N];
		memo[0] = arr[0];
		memo2 = new int[N];
		max = arr[0];
		
		for(int i =1; i< N; i++) {
			
			memo[i] = Math.max(memo[i-1]+arr[i], arr[i]);
			memo2[i] = Math.max(memo[i-1], memo2[i-1]+arr[i]);
			max = Math.max(memo[i], Math.max(max, memo2[i]));
		}
		
		System.out.println(max);
		
		
	}

}
