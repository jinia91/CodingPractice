import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14 {
	
	static boolean[] prime;
	
	static void getprime() {
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i =2; i <= Math.sqrt(prime.length);i++) {
			if (prime[i]== true) continue;
			
			for(int j=2; i*j<prime.length;j++) {
				prime[i*j] = true
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int
		int M = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		
		
		prime = new boolean[N+1];
		
		getprime();
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = M; i <= N; i++) {
			if(!prime[i]) sb.append(i).append('\n');
		}
		
		System.out.println(sb);
		
	}

}
