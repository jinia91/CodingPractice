import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no1697 {

	static boolean[] visited = new boolean[200001];

	static int bfs(int x, int y) {

		LinkedList<LinkedList<Integer>> que = new LinkedList<>();

		LinkedList<Integer> X = new LinkedList<Integer>();
		int dept = 0;

		X.add(x);
		X.add(dept);
		X.add(x * 2);
		X.add(x + 1);
		X.add(x - 1);

		que.offer(X);
		visited[x] = true;

		while (!que.isEmpty()) {

			LinkedList<Integer> check = que.poll();

			if (check.poll() == y) {

				return check.poll();

			}

			else {
				int d = check.poll();

				while (!check.isEmpty()) {

					int next = check.poll();

					if (next < 200001 && next >= 0) {
						if (!visited[next]) {

							visited[next] = true;

							LinkedList<Integer> TMP = new LinkedList<Integer>();

							TMP.add(next);
							TMP.add(d + 1);
							TMP.add(next * 2);
							TMP.add(next + 1);
							TMP.add(next - 1);

							que.add(TMP);
						}
					}
				}

			}

		}

		return 0;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		System.out.println(bfs(x, y));

	}

}
