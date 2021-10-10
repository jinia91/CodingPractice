package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1654 {

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

			cnt += x / length;

		}
		
		return cnt;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lines = new int[K];

		for (int i = 0; i < K; i++) {

			lines[i] = Integer.parseInt(br.readLine());

			maxLine = Math.max(maxLine, lines[i]);

		}
		
		
		long ans = upperBound();
		
		System.out.println(ans);

	}

}
