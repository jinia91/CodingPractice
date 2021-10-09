package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no14502 {

	static int[][] map;
	static int[][] mapTmp;
	static boolean[][] visited;
	static int N, M;
	static int maxCnt = 0;
	static StringTokenizer st;
	static ArrayList<Node> virus = new ArrayList<>();
	static int[] dN = { -1, 0, 1, 0 };
	static int[] dM = { 0, 1, 0, -1 };

	static class Node {

		int x;
		int y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static void bfs() {

		LinkedList<Node> que = new LinkedList<>();

		for (Node start : virus) {

			que.add(start);
			visited[start.x][start.y] = true;

		}

		while (!que.isEmpty()) {

			Node node = que.poll();

			for (int i = 0; i < 4; i++) {

				if (0 <= node.x + dN[i] && node.x + dN[i] < N && 0 <= node.y + dM[i] && node.y + dM[i] < M) {

					Node nextN = new Node(node.x + dN[i], node.y + dM[i]);

					if (mapTmp[nextN.x][nextN.y] != 1 && mapTmp[nextN.x][nextN.y] != 2 && !visited[nextN.x][nextN.y]) {
						visited[nextN.x][nextN.y] = true;
						mapTmp[nextN.x][nextN.y] = 2;

						que.add(nextN);
					}

				}

			}

		}

	}

	static int safeZone(int[][] map) {

		int count = 0;

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (map[i][j] == 0)
					count++;

			}

		}

		return count;

	}

	static void copyMap() {

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				mapTmp[i][j] = map[i][j];

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		mapTmp = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {

				int x = Integer.parseInt(st.nextToken());

				map[i][j] = x;
				mapTmp[i][j] = x;

				if (map[i][j] == 2) {

					virus.add(new Node(i, j));
				}
			}
		}

		
		
		// dfs 순열로 풀었어야했는데... 생각하기 귀찮아서 반복문 굴리다가 시간손해만봄 ㅅㅂ
		for (int n = 0; n < N; n++) {

			for (int m = 0; m < M; m++) {

				if (mapTmp[n][m] == 0)
					mapTmp[n][m] = 1;

				else
					continue;

				for (int n2 = 0; n2 < N; n2++) {

					for (int m2 = 0; m2 < M; m2++) {

						if (mapTmp[n2][m2] == 0)
							mapTmp[n2][m2] = 1;

						else
							continue;

						for (int n3 = 0; n3 < N; n3++) {

							for (int m3 = 0; m3 < M; m3++) {

								if (mapTmp[n3][m3] == 0) {
									mapTmp[n3][m3] = 1;

									bfs();

									visited = new boolean[N][M];
									maxCnt = Math.max(maxCnt, safeZone(mapTmp));

									if (maxCnt == 29) {

										System.out.println(maxCnt);

									}

									copyMap();
									mapTmp[n][m] = 1;
									mapTmp[n2][m2] = 1;
								}

							}

						}

						mapTmp[n2][m2] = 0;

					}

				}

				mapTmp[n][m] = 0;

			}

		}

		System.out.println(maxCnt);

	}

}
