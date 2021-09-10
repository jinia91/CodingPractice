package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no9935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String boom = br.readLine();

		char[] answer = new char[str.length()];
		int idx = 0;

		for (int i = 0; i < str.length(); i++) {

			answer[idx] = str.charAt(i);

			if (answer[idx] == boom.charAt(boom.length() - 1) 
					&& idx >= boom.length()-1) {

				int tIdx = idx;
				int length = boom.length()-1;
				boolean boomFlag = true;
				
				for (int j = 0; j < boom.length(); j++) {
				
					if(answer[tIdx--] != boom.charAt(length--)) {
						boomFlag = false;
						break;
					}
					
				}
				
				if(boomFlag) idx -= boom.length();

			}
			
			idx++;

		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(answer);
		sb.setLength(idx);
		
		if(sb.length() == 0) System.out.print("FRULA");
		else System.out.print(sb);

	}

}
