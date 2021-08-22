import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1806 {

	static int start, end, sum, anS, anE, tmp;
	static int minlenth = Integer.MAX_VALUE;
	static StringTokenizer st;
	static int[] arr;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];

		for (int i = 0; i < N; i++) {

			arr[i] = Integer.valueOf(st.nextToken());
		}

		for (start = 0; start < N; start++) {

			while (end < N && sum < M) {

				sum += arr[end];

				end++;

			}
			
			tmp = end-start;

			if (minlenth > tmp&&sum>=M) {
				minlenth=tmp;
				flag = true;
			}

			sum -= arr[start];

		}

		
	
		if(flag) System.out.println(minlenth);
		else System.out.println(0);
	}

}
