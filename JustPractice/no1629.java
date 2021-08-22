import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1629 {

	static Long A, B, C;

	static long dq(long a, long b) {

		if (b == 1)
			return a % C;

		long temp = dq(a, b / 2);

		long result = temp * temp %C;

		if (b % 2 == 0)

			return result;

		return result*A%C;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(dq(A, B));
	}

}
