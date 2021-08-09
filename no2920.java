import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2920 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		StringBuilder sb = new StringBuilder();
		
		sb.setLength(8);
		
		boolean aflag = false;
		boolean dflag = false;

		String S = "";
		
		
		for(int i = 0 ; i< 8; i++) {

			int a = Integer.valueOf(st.nextToken());
			
			if(i+1 == a&&!dflag) {
				S = "ascending";
				aflag = true;
			}
			else if(8-i == a&&!aflag) {
				S = "descending";
				dflag = true;
			}
			else {
				S = "mixed";
				break;
			}
			
		}
		

		System.out.println(S);
			
		
	}

}
