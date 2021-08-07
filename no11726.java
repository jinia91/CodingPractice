import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no11726 {

	static int[] memo;
	
	static int dp(int x) {
		
		if(memo[x]==0&&x>1) {
			
			memo[x] = dp(x-1)+ dp(x-2);
			
			memo[x] %= 10007;
			
		}
		
		
		return memo[x];
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		memo = new int[N+1];
		
		memo[0] = 1;
		memo[1] = 1;
		
		
		System.out.println(dp(N));
		
		
		
		
	}

}
