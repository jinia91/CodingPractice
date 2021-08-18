import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no2407 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		BigInteger rs = new BigInteger("1");

		for (int i = 0; i<M; i++) {

			rs = rs.multiply(BigInteger.valueOf(N--));

		}
		

		
		BigInteger rs2 = new BigInteger("1");
		
		for (int i = 1; i <= M; i++) {

			rs2 = rs2.multiply(BigInteger.valueOf(i));

		}




		System.out.println(rs.divide(rs2));
		
	}

}
