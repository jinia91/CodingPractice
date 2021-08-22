import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class no4153 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		String S = null;
		while(true) {
			S = br.readLine();
			String[] X = S.split(" ");
			
			int a = Integer.valueOf(X[0]);
			int b = Integer.valueOf(X[1]);
			int c = Integer.valueOf(X[2]);
			
			if (a==0&&b==0&c==0) break;
			
			if(a*a + b*b == c*c) {
				System.out.println("right");
			}
			else if(a*a+c*c == b*b) System.out.println("right");
			else if(b*b+c*c == a*a) System.out.println("right");
			else System.out.println("wrong");
			
		}
		
		
	}

}
