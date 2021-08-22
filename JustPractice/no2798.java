import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2798 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");

		int[] arr = new int[N];
		
		for(int i =0; i< N; i++) {
			int x = Integer.valueOf(st.nextToken());
			arr[i] = x;
		}
		
		int answer=0;
		
		for(int i=0; i<N; i++) {
			
			for(int j=i+1; j<N;j++) {
				
				for(int k = j+1; k<N; k++) {
					if(arr[i]+arr[j]+arr[k] <=M&&M-answer>M-(arr[i]+arr[j]+arr[k])) {
						
						answer = arr[i]+arr[j]+arr[k];
					}
					
				}
				
				
			}
			
			
		}
		
		
		System.out.println(answer);

	}

}
