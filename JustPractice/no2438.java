import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2438 {

	static void starmake(int x) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <x; i++) {
			
			sb.append("*");
			
			System.out.println(sb);
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
	
		starmake(N);
		
	}

}
