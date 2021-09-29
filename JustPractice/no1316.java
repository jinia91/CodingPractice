package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1316 {

	static boolean[] check = new boolean[26];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		
		for (int i = 0; i < N; i++) {

			String input = br.readLine();

			int beforeChk = 0;

			for (int j = 0; j < input.length(); j++) {
				int chk = input.charAt(j);

				if (beforeChk != chk) {

					if (check[chk - 97])
						break;

					check[chk - 97] = true;
					beforeChk = chk;
				}
				
				if (j == input.length()-1) cnt++;

			}
			

			check = new boolean[26];
			
		}

		System.out.println(cnt);
		
	}

}
