package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2473 {

	static int N;
	static int answerA, answerB, answerC;
	static long minSum = Long.MAX_VALUE;
	static long[] arr;

	static void tPointer(int idx) {

		int e = arr.length - 1;
		int s = idx+1;
		
		while(s<e) {
			
			
			if(Math.abs(arr[idx]+arr[s]+arr[e])<Math.abs(minSum)) {
				minSum = arr[idx] + arr[s]+arr[e];
				answerA = s;
				answerB = e;
				answerC = idx;
				if(minSum == 0) return;
			}
			
			if(arr[s]+arr[e]+arr[idx]<0) s++;
			else e--;
			
		}
		
	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new long[N];

		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

		}
		
		Arrays.sort(arr);

		for(int i =0; i<N; i++) {

			if(minSum == 0) break;

			tPointer(i);

			
		}
		
		System.out.println(arr[answerC]+" " + arr[answerA] + " " + arr[answerB]);

	}

}
