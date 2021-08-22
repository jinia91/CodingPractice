import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2231 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
	
		int answer = Integer.valueOf(br.readLine());
		
		int i=1;
		int sum =0;
		
		while(true) {
			
			int x = i;
			sum += x;
			
			while(x != 0) {
				
				sum += x%10;
				
				x /= 10;
				
			}
			
			if (sum==answer) break;
			else {
				
				i++;
				sum =0;
			}
			
			if(i>1000000) {i=0; break;}
		}
		
		
		
		System.out.println(i);
		
		
		
	}

}
