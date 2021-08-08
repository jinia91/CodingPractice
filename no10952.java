import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no10952 {

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String s;

		while ((s = br.readLine()) != null) {
			st = new StringTokenizer(s, " ");

			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());

			if(x==0&&y==0) break;
			
			sb.append(x + y).append("\n");
		
		
		
		}

		System.out.println(sb);

	}

}
