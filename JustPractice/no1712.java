package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1712 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		for(Long i =0L; i<=Integer.MAX_VALUE; i++) {
			
			if(A + B*i < C*i) {
				System.out.println(i);
				System.exit(0);
			}
			
		}
		
		System.out.println(-1);
		
		
		
		
	}

}
