package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2839 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		int tmp = Integer.MAX_VALUE;
		
		while (n >0) {

			if (n % 5 == 0) {
				System.out.println(cnt+n / 5);
				return;
			} else if (n % 3 == 0) {

				tmp = Math.min(cnt+n/3, tmp);
			} 
			
			n -= 5;
			cnt++;
			
		}
		

		if(tmp != Integer.MAX_VALUE) {
			System.out.println(tmp);
			return;
		}
		System.out.println(-1);
		
	}

}
