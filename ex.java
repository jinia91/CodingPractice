import java.util.*;
import java.io.*;



public class ex {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.valueOf(br.readLine());
	   
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<N; i++) {
				
			int x = Integer.valueOf(st.nextToken());
			
			arr[i] = x;
			
		}	
		
		Arrays.sort(arr);
		
		int M = Integer.valueOf(br.readLine());

		StringBuilder sb = new StringBuilder();


		st = new StringTokenizer(br.readLine(), " ");

		
		for(int i = 0; i<M; i++) {
			
				
			int x = Integer.valueOf(st.nextToken());
			
			int y = 0;
			
			y = Arrays.binarySearch(arr, y, arr.length, x);
			
			int cnt;
			
			while(y>=0) {
				
				cnt++;
				
				y = Arrays.binarySearch(arr, y, arr.length+1, x);

			}	
					
					
			sb.append(cnt).append(" ");
				
			}
			
		}

		
		
		System.out.println(sb.toString().trim());
		
		
		
		
		
	}

}
