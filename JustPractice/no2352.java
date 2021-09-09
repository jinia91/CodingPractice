package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no2352 {

	static int[] arr;
	static int[] memo2;
	static ArrayList<Integer> memo = new ArrayList<>();

	static void dp(int x, int i) {

		if (x > memo.get(memo.size() - 1)) {
			memo.add(x);
			memo2[i] = memo.size()-1;
			return;
		}

		int idx = upperBound(x);

		memo2[i] = idx;
		memo.set(idx, x);
	}

	private static int upperBound(int x) {
		int left = 0;
		int right = memo.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if(memo.get(mid)<x) {
				left = mid+1;
			}
			else {
				right = mid;
			}
			
		}
		
		return right;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N];
		memo2 = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		memo.add(arr[0]);

		for (int i = 1; i < N; i++) {
			dp(arr[i], i);
		}
		
		
		int length = memo.size();

		System.out.println(length);
	
	}

}
