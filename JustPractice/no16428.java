package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no16428 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		BigInteger a = new BigInteger(st.nextToken());
		BigInteger b = new BigInteger(st.nextToken());
		
		BigInteger divide = a.divide(b);
		BigInteger remainder = a.remainder(b);
		
		if(a.compareTo(BigInteger.ZERO)<0&&
				a!=BigInteger.ZERO&& 
				b.compareTo(BigInteger.ZERO)>0) {
			System.out.println(divide.subtract(BigInteger.ONE));
			System.out.println(a.subtract(divide.subtract(BigInteger.ONE).multiply(b)));

		}
		else if(a.compareTo(BigInteger.ZERO)<0&&
				a!=BigInteger.ZERO&&
				b.compareTo(BigInteger.ZERO)<0){
			
			System.out.println(divide.add(BigInteger.ONE));
			System.out.println(a.subtract(divide.add(BigInteger.ONE).multiply(b)));
		
		}
		
		else {
			
			System.out.println(divide);
			System.out.println(remainder);
			
		}
		
		
	}

}
