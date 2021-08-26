package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no12851 {

	static int[] visited = new int[200001];
	static int answerD = Integer.MAX_VALUE;
	static int cnt;
	static boolean flag;

	static void bfs(int x, int y) {

		LinkedList<int[]> que = new LinkedList<>();

		int[] X = new int[5];
		int dept = 0;

		X[0] = x;
		X[1] = dept;
		X[2] = x*2;
		X[3] = x+1;
		X[4] = x-1;

		que.offer(X);
		visited[x] = 1;

		while (!que.isEmpty()) {

			int[] check = que.poll();

			if (check[0] == y&&!flag) {

				flag = true;
				 answerD = check[1];
				 cnt++;

			}
			
			else if (check[0] == y&&flag) {
				
				cnt++;
			}

			else {
				int d = check[1];
				
				if (d>answerD) return;

				for(int i = 2; i<5;i++) {
					int next = check[i];

					if (next < 200001 && next >= 0) {
						if (visited[next]==0||visited[next]==visited[check[0]]+1) {

							visited[next] = visited[check[0]]+1;

							int[] tmp = new int[5];
							
							tmp[0] = next;
							tmp[1] = d+1;
							tmp[2] = next*2;
							tmp[3] = next+1;
							tmp[4] = next-1;

							que.add(tmp);
						}
					}
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		bfs(x, y);
		System.out.println(answerD);
		System.out.println(cnt);

	}

}
