import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no11399 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		
		int[] arr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		
		
		for(int i = 0 ; i < N; i++) {
			int x = Integer.valueOf(st.nextToken());

			arr[i] = x;
		}
		
		Arrays.sort(arr);
		
		int sum=0;
		
		for(int i = 0 ; i < N; i++) {
			
			int tmpsum = 0;
			
			for(int j=0; j <= i; j++) {
				
				tmpsum += arr[j];
				
			}
			
			sum +=tmpsum;
			
		}
		
		
		System.out.println(sum);
		
	}

}
