package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class no11651 {

	static class Index implements Comparable<Index> {

		int x;
		int y;

		public Index(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Index o) {
			if (this.y == o.y) {

				return this.x - o.x;

			}

			return this.y - o.y;
		}

	}

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Index> list = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Index(x, y));

		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(Index i : list) {
			sb.append(i.x+" "+i.y+"\n");
		}
		
		System.out.println(sb);
	}

}
