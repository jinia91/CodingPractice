package JustPractice;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no14503 {

	static int N, M;
	static int[][] map;

	static class Robot {

		// 북 = 0 부터 시계방향
		private int direction;
		private int idxR, idxC;
		private boolean[][] cleaned;
		int cleanCnt;

		public Robot(int direction, int idxR, int idxC, int N, int M) {
			this.direction = direction;
			this.idxR = idxR;
			this.idxC = idxC;
			this.cleaned = new boolean[N][M];
		}

		void clean() {
			loop: while (true) {
				cleaned[idxR][idxC] = true;
				cleanCnt++;

				int rotateCnt = 0;
				while (!findLeftAndMove()) {
					rotateL();
					rotateCnt++;
					if (rotateCnt == 4) {
						if (!backMove()) {
							break loop;
						}
						else {rotateCnt = 0;}
					}
				}
			}
		}

		boolean findLeftAndMove() {

			if (direction == 0) {
				if (idxC - 1 >= 0 && !cleaned[idxR][idxC - 1] && map[idxR][idxC - 1] != 1) {

					direction = 3;
					idxC--;
					return true;
				}
			} else if (direction == 1) {
				if (idxR - 1 >= 0 && !cleaned[idxR - 1][idxC] && map[idxR - 1][idxC] != 1) {

					direction = 0;
					idxR--;
					return true;
				}
			} else if (direction == 2) {
				if (idxC + 1 <= M && !cleaned[idxR][idxC + 1] && map[idxR][idxC + 1] != 1) {

					direction = 1;
					idxC++;
					return true;
				}
			} else if (direction == 3) {
				if (idxR + 1 <= N && !cleaned[idxR+1][idxC] && map[idxR+1][idxC] != 1) {

					direction = 2;
					idxR++;
					return true;
				}
			}

			return false;
		}

		void rotateL() {

			if (direction == 0) {
				direction = 3;
			} else if (direction == 1) {
				direction = 0;
			} else if (direction == 2) {
				direction = 1;
			} else if (direction == 3) {
				direction = 2;
			}

		}

		boolean backMove() {

			if (direction == 0) {
				if (idxR + 1 <= N && map[idxR + 1][idxC] != 1) {

					idxR++;
					return true;
				}
			} else if (direction == 1) {
				if (idxC - 1 >= 0 && map[idxR][idxC - 1] != 1) {

					idxC--;
					return true;
				}
			} else if (direction == 2) {
				if (idxR - 1 >= 0 && map[idxR - 1][idxC] != 1) {

					idxR--;
					return true;
				}
			} else if (direction == 3) {
				if (idxC + 1 <= M && map[idxR][idxC + 1] != 1) {

					idxC++;
					return true;
				}
			}

			return false;

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int idxR = Integer.parseInt(st.nextToken());
		int idxC = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		
		Robot autoCleaner = new Robot(d,idxR,idxC,N,M);
		
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {

				map[i][j] = Integer.parseInt(st.nextToken());

			}

		}
		
		autoCleaner.clean();
		
		System.out.println(autoCleaner.cleanCnt);
		
	}

}
