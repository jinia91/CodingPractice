package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2805 {

	static int K, N, maxLine;
	static int[] lines;

	static long upperBound() {
		
		long start = 0;
		long end = maxLine;
		end++;
		
		while(start < end) {
			
			long mid = (start+end)/2;
			
			
			if(cutLine(mid) < N ) {
				
				end = mid;
				
			}
			
			else start = mid+1;
			
		}
		
		return start-1;
		
	}

	static long cutLine(long length) {

		long cnt = 0;

		for (int x : lines) {

			if((x - length)>0) {
				cnt+= x-length;
			};

		}
		
		return cnt;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lines = new int[K];

		st= new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < K; i++) {

			lines[i] = Integer.parseInt(st.nextToken());

			maxLine = Math.max(maxLine, lines[i]);

		}
		
		
		long ans = upperBound();
		
		System.out.println(ans);

	}

}
