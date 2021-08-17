import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1780 {

	static StringTokenizer st;
	static int[][] board;
	static int cnt_p1, cnt_0, cnt_m1;
	static int N;

	static boolean checkColor(int x, int y, int size) {

		int color = board[x][y];

		for (int i = x; i < x + size; i++) {

			for (int j = y; j < y+ size; j++) {

				if (board[i][j] != color)
					return false;

			}

		}

		return true;

	}

	static void divQ(int x, int y, int size) {

		if (checkColor(x, y, size)) {
			switch (board[x][y]) {

			case -1:
				cnt_m1++;
				break;
			case 0:
				cnt_0++;
				break;
			case 1:
				cnt_p1++;
				break;
			}
			
			return;
		}
		
		size = size/3;
		
		divQ(x,y,size);
		divQ(x,y+size,size);
		divQ(x,y+size+size,size);
		divQ(x+size,y,size);
		divQ(x+size,y+size,size);
		divQ(x+size,y+size+size,size);
		divQ(x+size+size,y,size);
		divQ(x+size+size,y+size,size);
		divQ(x+size+size,y+size+size,size);
		

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {

				board[i][j] = Integer.parseInt(st.nextToken());

			}

		}

		divQ(0,0,N);
		
		System.out.println(cnt_m1);
		System.out.println(cnt_0);
		System.out.println(cnt_p1);
		
	}

}
