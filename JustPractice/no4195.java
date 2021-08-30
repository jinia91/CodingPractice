package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class no4195 {

	static Map<String, Integer> map;
	static int[] fTable;
	static int[] cnt;

	static int find(int a) {

		if (fTable[a] == a)
			return a;

		else
			return fTable[a] = find(fTable[a]);
	}

	static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a == b)
			return;

		if (a > b) {
			fTable[a] = b;
		
			int tmp = cnt[a]+cnt[b];
			cnt[a] = tmp;
			cnt[b] = tmp;
		}
		else {
			fTable[b] = a;
			
			int tmp = cnt[a]+cnt[b];
			cnt[a] = tmp;
			cnt[b] = tmp;

		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();


		for (int tc = 1; tc <= TC; tc++) {

			int F = Integer.parseInt(br.readLine());
			int idx = 0;
			map = new HashMap<>();

			fTable = new int[F*2];

			for (int i = 0; i < F*2; i++) {
				fTable[i] = i;
			}
			
			cnt = new int[F*2];
			Arrays.fill(cnt, 1);
			

			for (int i = 0; i < F; i++) {

				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				String name = st.nextToken();

				if (!map.containsKey(name)) {

					map.put(name, idx++);

				}

				String name2 = st.nextToken();

				if (!map.containsKey(name2)) {

					map.put(name2, idx++);

				}

				Integer fA = map.get(name);
				Integer fB = map.get(name2);

				union(fA, fB);

				sb.append(cnt[find(fB)]).append("\n");
				
			}

			
		}
		

		System.out.println(sb);
		
	}

}
