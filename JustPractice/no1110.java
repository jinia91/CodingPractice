import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1110 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int x = Integer.valueOf(br.readLine());	
		
		int y = x;
		int cnt = 0;
		
		while(true) {
			
			
			int a = y/10;
			int b = y%10;
			
			y = b*10+(a+b)%10;
			
			cnt++;
			
			if(x == y) break;
			
		}
		
		cnt = cnt==0? 1:cnt;
		
		System.out.println(cnt);
		
	}

}
