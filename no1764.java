import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class no1764 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		
		
		ArrayList<String> set2 = new ArrayList<>();
		
		
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i< N; i++) {
			set.add(br.readLine());
		}
		
		
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0; i< M; i++) {
			
			String s = br.readLine();
			
			
			if(set.contains(s)) {
				set2.add(s);
				cnt++;  
			}
			
			
		}
		
		Collections.sort(set2);
		
		for(int i = 0 ; i<set2.size(); i++) {
			
			sb.append(set2.get(i)).append("\n");
			
		}
	
		System.out.println(cnt);
		System.out.println(sb);
		
	}

}
