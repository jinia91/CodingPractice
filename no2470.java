import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2470 {
	
	static int sum, start, end, ansS,ansE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.valueOf(br.readLine());
		
		int[] arr = new int[N];
		int sum=0;
		

		st = new StringTokenizer(br.readLine(), " ");
		
		
		for(int i = 0; i < N; i++) {
			
			arr[i] = Integer.valueOf(st.nextToken()); 
			
		}
		
		Arrays.sort(arr);
		
		sum = Integer.MAX_VALUE;
		start = 0;
		end = N-1;
		
		
		
		while(start<end) {
			
			int tmp = arr[start]+arr[end];
			
			if(Math.abs(sum)>Math.abs(tmp)) {
				sum = tmp;
				ansS = start;
				ansE = end;
			}
			
			
			if(0<tmp) {
				end--;
			}
			else {
				start++;
			}
			
			
		}
		
		System.out.println(arr[ansS] + " " + arr[ansE]);
	}

}
