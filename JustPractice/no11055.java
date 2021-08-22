	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class no11055 {
	
		static int[] arr;
		static int[] memo;
	
		static int dp(int x) {
	
			if (memo[x] == 0) {
	
				for (int i = 0; i < x; i++) {
	
					if(arr[x]>arr[i])
					memo[x] = Math.max(dp(i) + arr[x], memo[x]) ;
	
				}
				
				
				if(memo[x] == 0) memo[x] = arr[x];
				
	
			}
			
			return memo[x];
	
		}
	
		public static void main(String[] args) throws IOException {
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int N = Integer.parseInt(br.readLine());
	
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
			arr = new int[N];
	
			for (int i = 0; i < N; i++) {
	
				arr[i] = Integer.parseInt(st.nextToken());
	
			}
			
			memo = new int[N];
			
	
			int max = 0;
			for(int i =0; i<N; i++) {
				
				max = Math.max(dp(i), max);
				
			}
			
			
			
			System.out.println(max);
			
		}
	
	}
