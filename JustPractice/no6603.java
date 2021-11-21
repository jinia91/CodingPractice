package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no6603 {

	static StringTokenizer st;

	static int[] input;
	static int[] output;
	static boolean[] check;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			input = new int[n];
			output = new int[6];
			check = new boolean[n];
			sb = new StringBuilder();

			for (int i = 0; i < n; i++) {

				input[i] = Integer.parseInt(st.nextToken());

			}
			
			dfs(0,0);
			
			System.out.println(sb);
			

		}

	}

	static public void dfs(int dept, int start) {


			if (dept == 6) {

				for (int j = 0; j < output.length; j++) {
					sb.append(output[j]+" ");
				}

				sb.append("\n");
				return;
			}

			for (int i = start; i < input.length; i++) {

				if (!check[i]) {
					output[dept] = input[i];

					check[i] = true;
					dfs(dept + 1, i);
					check[i] = false;
				}
			}
		

	}

}
