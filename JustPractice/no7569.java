package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no7569 {

	static int[][][] board;
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 0, -1, 1 };
	static int[] dz = { 1, -1, 0, 0, 0, 0 };
	static int M, N, H;

	static class Node {

		int x;
		int y;
		int z;

		Node(int x, int y, int z) {

			this.x = x;
			this.y = y;
			this.z = z;

		}

	}

	static void bfs() {

		LinkedList<Node> que = new LinkedList<>();

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				for (int k = 0; k < H; k++) {
					if (board[i][j][k] == 1) {
						que.add(new Node(j, i, k));
					}
				}
			}

		}

		while (!que.isEmpty()) {

			Node node = que.poll();

			for (int i = 0; i < 6; i++) {

				int nextx = node.x + dx[i];
				int nexty = node.y + dy[i];
				int nextz = node.z + dz[i];

				if (nextx < 0 || nextx >= M || nexty < 0 || nexty >= N || nextz >= H || nextz < 0)
					continue;
				if (board[nexty][nextx][nextz] != 0)
					continue;

				if (board[nexty][nextx][nextz] == 0) {

					board[nexty][nextx][nextz] = board[node.y][node.x][node.z] + 1;

					que.add(new Node(nextx, nexty, nextz));
				}
			}

		}

		int maxDay = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				for (int k = 0; k < H; k++) {
					if (board[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}

					if (board[i][j][k] > maxDay)
						maxDay = board[i][j][k];
				}
			}
		}

		System.out.println(maxDay - 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		board = new int[N][M][H];

		for (int k = 0; k < H; k++) {

			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < M; j++) {

					board[i][j][k] = Integer.parseInt(st.nextToken());
				}

			}
		}

		bfs();

	}

}
