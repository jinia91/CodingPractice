package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no9372 {

	static StringTokenizer st;

	static int[] parent;

	static int find(int x) {

		if (x == parent[x])
			return x;

		else {

			return parent[x] = find(parent[x]);

		}

	}

	static void union(int a, int b) {

		a = find(a);
		b = find(b);

		if (a == b)
			return;

		else if (a > b)
			parent[a] = b;
		else
			parent[b] = a;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			
			for(int i = 0 ; i< N+1; i++) {
				
				parent[i] =i;
				
			}

			
			int cnt = 0;

			for (int i = 0; i < M; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if(find(a) != find(b)) {
					cnt++;
					union(a,b);
				}
			}
			sb.append(cnt+"\n");
			
		}
		
		System.out.println(sb);

	}

}
