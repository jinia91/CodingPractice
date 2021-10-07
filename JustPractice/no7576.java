import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class no7576 {

	static int[][] board;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int M, N;

	static void bfs() {

		LinkedList<node10> que = new LinkedList<>();

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (board[i][j] == 1) {
					que.add(new node10(j, i));
				}
			}

		}

		while (!que.isEmpty()) {

			node10 node = que.poll();

			for (int i = 0; i < 4; i++) {

				int nextx = node.x + dx[i];
				int nexty = node.y + dy[i];

				if (nextx < 0 || nextx >= M || nexty < 0 || nexty >= N)
					continue;
				if (board[nexty][nextx] != 0)
					continue;

				if (board[nexty][nextx] == 0) {

					board[nexty][nextx] = board[node.y][node.x] + 1;

					que.add(new node10(nextx, nexty));
				}
			}

		}

		int maxDay = 0;
		
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (board[i][j] == 0) {
					System.out.println(-1);
					return;}

				if(board[i][j]>maxDay) maxDay = board[i][j];
				
			}
		}
		
		
		System.out.println(maxDay-1);

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {

				board[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		bfs();
		
	}

}
