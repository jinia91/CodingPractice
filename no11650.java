import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class no11650 {
	
	public static void main(String[] args) throws IOException {

		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.valueOf(br.readLine());
		
		
		int[][] arr = new int[N][2];
		
		
		for(int i = 0 ; i<N ; i ++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
			
		}
		
		
		Arrays.sort(arr, new Comparator<int[]>() {

			public int compare(int[] arg0, int[] arg1) {
				if (arg0[0] == arg1[0]) {
					return arg0[1] - arg1[1];
				}
				else return arg0[0]-arg1[0];
			}
		
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<N; i++) {
				
				sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
				
		}
	
		System.out.println(sb);
		
	}
		
	
	
	
}
		
		
		
	

