package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Index {

	int x, y, distance;
	boolean jump;

	public Index(int x, int y, int distance, boolean jump) {

		this.x = x;
		this.y = y;
		this.distance = distance;
		this.jump = jump;
	}

}

public class no2206 {

	static int[][] map;
	static int[][][] visitedCheck;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N,M;
	static int answer = Integer.MAX_VALUE;

	static void bfs() {

		LinkedList<Index> que = new LinkedList<>();

		que.add(new Index(0, 0, 0, false));
		visitedCheck[0][0][0] = 1;

		
		while (!que.isEmpty()) {

			Index now = que.poll();

			for (int i = 0; i < 4; i++) {

				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if(nextX == N-1 && nextY == M-1) {
					answer = Math.min(answer, now.distance+1);
					continue;
				}
				
				// 이동할수 있는 경우만 확인하기
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					
					//1. 벽일때 벽뚫기를 아직 안했고, 뚫어본 벽도 아닌경우
					if (map[nextX][nextY] == 1&&!now.jump&&visitedCheck[1][nextX][nextY] == 0) {
						que.add(new Index(nextX,nextY,now.distance+1,true));
						visitedCheck[1][nextX][nextY] = 1;
					}
										
					//2. 길인경우 - 벽을 안뚫어본 경우
					if (map[nextX][nextY] == 0&&visitedCheck[0][nextX][nextY] == 0&&!now.jump) {
						que.add(new Index(nextX,nextY,now.distance+1, now.jump));
						visitedCheck[0][nextX][nextY] = 1;
					}
					
					//3. 길인경우 - 벽을 뚫어본 경우
					if (map[nextX][nextY] == 0&&visitedCheck[1][nextX][nextY] == 0&&now.jump) {
						que.add(new Index(nextX,nextY,now.distance+1, now.jump));
						visitedCheck[1][nextX][nextY] = 1;
					}
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visitedCheck = new int[2][N][M];
        
        for(int i =0; i<N; i++) {

        	String s = br.readLine();
        	
        	for(int j =0; j<M; j++) {
        		
        		map[i][j] = Integer.valueOf(s.charAt(j)+"");
        		
        	}
        	
        }
	
        bfs();
    
        if(N==1&M==1) System.out.println(1);
        
        else if(answer == Integer.MAX_VALUE) System.out.println(-1);
        
    
        
        else System.out.println(answer+1);
		
		
	}

}
