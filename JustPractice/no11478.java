package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class no11478 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		Set<String> set = new HashSet<>();

		for (int i = 1; i <= input.length(); i++) {

			for (int j = 0; j+i <= input.length(); j++) {

				set.add(input.substring(j, j+i));
			
			}

		}
		
		System.out.println(set.size());
		
	}

}
