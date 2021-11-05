package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1477 {

	static int[] tmp;
	static int[] dis;
	static int N, M, L;

	static boolean flag;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		tmp = new int[N + 2];
		dis = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		tmp[0] = 0;
		tmp[N + 1] = L;

		for (int i = 1; i <= N; i++) {

			tmp[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(tmp);

		for (int i = 0; i < N + 1; i++) {

			dis[i] = tmp[i + 1] - tmp[i];

		}

		System.out.println(binarySearch());
		

	}

	private static int binarySearch() {

		int s = 0;

		int e = L+1;

		while (s < e) {

			int mid = (s + e) / 2;
			
			if(mid == 0) {
				mid++; s++;
			}

			if (calP(mid) > M) {
				s = mid + 1;
			}

			else {
				e = mid;
			}

			flag= false;
		}
		
		return e;

	}

	private static int calP(int mid) {

		int cnt = 0;

		for (int i = 0; i < N + 1; i++) {

			int rs = (dis[i]-1) / mid;
			
			cnt += rs;

		}

		return cnt;
	}

}
