package JustPractice;

import java.io.*;
import java.math.BigInteger;

public class no10826 {

	static BigInteger[] fibovalue2;


	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		fibovalue2 = new BigInteger[N + 1];
		
		fibovalue2[0] = BigInteger.ZERO;
		if(N>0)
		fibovalue2[1] = BigInteger.ONE;

		for (int i = 2; i < N + 1; i++) {

			fibovalue2[i] = fibovalue2[i - 1].add(fibovalue2[i - 2]);

		}

		System.out.println(fibovalue2[N]);

	}

}
