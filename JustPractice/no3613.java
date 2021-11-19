package JustPractice;

import static java.util.regex.Pattern.compile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class no3613 {

	static final Pattern UPPER = compile("[A-Z]");
	static final Pattern UNDER = compile("[a-z]");

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		boolean jFlag = false;
		boolean cFlag = false;

		boolean cUFlag = false;

		StringBuilder sb = new StringBuilder();
		
		
		if((input.charAt(0)+"").equals("_")||
				(input.charAt(input.length()-1)+"").equals("_")||
				UPPER.matcher(input.charAt(0)+"").matches()) {
			System.out.println("Error!");
			return;
		}
		
		

		for (int i = 0; i < input.length(); i++) {

			String x = (input.charAt(i) + "");

			if (!jFlag && !cFlag) {
				if (UNDER.matcher(x).matches()) {

					sb.append(x);

				}

				else if (x.equals("_")) {

					cFlag = true;

				}

				else {
					jFlag = true;
				}
			}

			if(jFlag||cFlag) {

				if (cFlag) {

					if (UPPER.matcher(x).matches()) {
						System.out.println("Error!");
						return;
					}

					
					if (!cUFlag&&x.equals("_")) {
						cUFlag = true;
					} else if(!cUFlag&&!x.equals("_")) {
						sb.append(x);
					}else if(cUFlag&&x.equals("_")){

						System.out.println("Error!");
						return;
						
						
					} else {
						cUFlag = false;
						sb.append(x.toUpperCase());
					}
				}

				else if (jFlag) {
					if (x.equals("_")) {
						System.out.println("Error!");
						return;
					}

					if (UPPER.matcher(x).matches()) {

						sb.append("_" + x.toLowerCase());

					}

					else {
						sb.append(x);
					}

				}

			}

		}
		
		System.out.println(sb);

	}

}
