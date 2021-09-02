package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2467 {

	static int N, answerA, answerB;
	static long minSum = Long.MAX_VALUE;
	static int[] arr;

	static void tPointer() {

		int e = arr.length - 1;
		int s = 0;
		
		while(s<e) {
			
			if(Math.abs(arr[s]+arr[e])<Math.abs(minSum)) {
				minSum = arr[s]+arr[e];
				answerA = s;
				answerB = e;
				if(minSum == 0) return;
			}
			
			if(arr[s]+arr[e]<0) s++;
			else e--;
			
		}
		
	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

		}

		tPointer();

		System.out.println(arr[answerA] + " " + arr[answerB]);

	}

}
