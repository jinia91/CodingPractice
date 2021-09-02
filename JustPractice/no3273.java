package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no3273 {

	static int N, target, cnt;
	static int[] arr;
	
	static void tPointer() {
		
		int s = 0;
		int e = arr.length-1;
		int sum =0;
		
		while(s<e) {
			
			sum = arr[s]+arr[e];
			if(sum == target) cnt++;
		
			if(sum>target) e--;
			else s++;
					
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		
		target = Integer.parseInt(br.readLine());
		
		tPointer();
		System.out.println(cnt);
	}

}
