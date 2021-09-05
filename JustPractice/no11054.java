package JustPractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no11054 {

	static int[] arr;
	static int[] memo;
	static int[] memo2;

	static int dp(int x) {

		if (memo[x] == 0) {

			for (int i = 0; i < x; i++) {

				if(arr[x]>arr[i])
				memo[x] = Math.max(dp(i)+1, memo[x]);

			}

		}
		
		return memo[x];

	}
	
	static int dp2(int x) {

		if (memo2[x] == 0) {

			for (int i = memo2.length-1; i > x; i--) {

				if(arr[x]>arr[i])
				memo2[x] = Math.max(dp2(i)+1, memo2[x]);

			}

		}
		
		return memo2[x];

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
		memo2 = new int[N];

		int max = 0;
		for(int i =0; i<N; i++) {
			
		 max = Math.max(dp(i)+dp2(i), max);
			
		}
		
		
		System.out.println(max+1);
		
	}

}
