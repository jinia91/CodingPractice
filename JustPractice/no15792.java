package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class no15792 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		

		BigDecimal A = new BigDecimal(st.nextToken());
		BigDecimal B = new BigDecimal(st.nextToken());
		
		
		System.out.println(A.divide(B,1000,BigDecimal.ROUND_UP));
		
		
	}

}
