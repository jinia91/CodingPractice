import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2675 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		for (int i = 0; i < N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			StringBuilder sb = new StringBuilder();

			int a = Integer.valueOf(st.nextToken());
			String S = st.nextToken();

			for (int j = 0; j < S.length(); j++) {
				for (int x = 0; x < a; x++) {
					sb.append(S.charAt(j));
				}
			}
			
			System.out.println(sb);
			
		}

	}

}
