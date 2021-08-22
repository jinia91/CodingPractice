import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class no1620 {
	
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());


		HashMap list = new HashMap();
		
		
		for(int i =1; i<=N; i++) {
			String S = br.readLine();

			String I =Integer.toString(i);
			
			list.put(I, S);
			list.put(S, i);
		
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i<M; i++) {
			
			String S = br.readLine();
			
			sb.append(list.get(S)).append("\n");
			
		}
		
		System.out.println(sb);
	}

}
