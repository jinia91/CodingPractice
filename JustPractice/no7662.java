package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class no7662 {

	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			int N = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> ts = new TreeMap<>();

			for (int j = 0; j < N; j++) {

				st = new StringTokenizer(br.readLine(), " ");

				String oper = st.nextToken();

				if (oper.equals("I")) {
					int num = Integer.parseInt(st.nextToken());

					if (ts.containsKey(num)) {
						ts.put(num, ts.get(num) + 1);
					}

					else {
						ts.put(num, 1);
					}
				}

				else if (oper.equals("D") && !ts.isEmpty()) {
					int flag = Integer.parseInt(st.nextToken());

					if (flag < 0) {

						if (ts.get(ts.firstKey()) == 1) {
							ts.pollFirstEntry();
						}

						else {
							ts.put(ts.firstKey(), ts.get(ts.firstKey()) - 1);
						}

					} else if (flag > 0) {
						if (ts.get(ts.lastKey()) == 1) {
							ts.pollLastEntry();
						}

						else {
							ts.put(ts.lastKey(), ts.get(ts.lastKey()) - 1);
						}
					}
				}

			}

			StringBuilder sb = new StringBuilder();

			if (ts.isEmpty())
				System.out.println("EMPTY");

			else {

				sb.append(ts.lastKey()).append(" ").append(ts.firstKey());


				System.out.println(sb);
			}
		}
	}

}
