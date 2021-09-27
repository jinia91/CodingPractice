package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2941 {

	final static String[] ca = {"c=","c-","dz=","d-","lj","nj","s=","z="};
	static int cnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder input = new StringBuilder();
		
		input.append(br.readLine());
		
		for(String match : ca) {
			
			while(input.toString().contains(match)) {
				cnt++;
				int idx = input.toString().indexOf(match);
				input.replace(idx,idx+match.length(),"¤±");
			}
		}
		
		String ans = input.toString().replaceAll("¤±","");
		
		cnt += ans.length();
		
		System.out.println(cnt);
		
	}

}
