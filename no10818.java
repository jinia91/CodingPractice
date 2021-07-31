import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no10818 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.valueOf(br.readLine());
		
		StringBuilder SB = new StringBuilder();
		
		for(int i = 0 ; i <T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int H = Integer.valueOf(st.nextToken());
			int W = Integer.valueOf(st.nextToken());
			int N = Integer.valueOf(st.nextToken());
			
			int cnt = 1;
			
			while (N>H) {
				N = N-H;
				cnt++;
			}
			
			
			
			
			
			StringBuilder sb= new StringBuilder();
			
			
			
			sb.append(N);

			if (cnt>=10) {
				
				sb.append(cnt);
				
			}
			
			else {sb.append(0).append(cnt);}
			
			SB.append(sb).append("\n");
			
		}
		
		
		System.out.println(SB);
		
		
	}

}
