package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2884 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Integer H = Integer.parseInt(st.nextToken());
		Integer M = Integer.parseInt(st.nextToken());
		
		
		if(M>=45) {
			M = M-45;
		}
		
		else if(M<45&&H>0) {
			H = H-1;
			M = M+15;
		}
		
		else if(M<45 && H==0) {
			H = 23;
			M = M+15;
		}
		
		System.out.println(H+" "+M);
		
	}

}
