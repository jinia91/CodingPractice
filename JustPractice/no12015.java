package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no12015 {

	static int[] arr;
	static ArrayList<Integer> memo = new ArrayList<>();

	static void dp(int x) {

		if (x > memo.get(memo.size() - 1)) {
			memo.add(x);
			return;
		}

// 완탐에 return으로 탈출해서 탐색수를 줄여봤지만 시간초과나옴, 탐색을 이분탐색으로 바꿔야 조건 만족
//		for (int i = memo.size()-1; i >= 0; i--) {
//
//			if (x>memo.get(i)) {
//			
//				if(i == memo.size()-1) memo.add(x);
//				
//				else {
//					memo.set(i+1, x);
//				}
//				
//				return;
//			}
//			
//			if(i == 0&&memo.get(i)>x) {
//				
//				memo.set(i, x);
//				
//			}
		
		// 이분탐색통해 x가 갱신될 memo 위치 탐색
		int idx = upperBound(x);

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

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		memo.add(arr[0]);

		for (int i = 1; i < N; i++) {
			dp(arr[i]);
		}

		System.out.println(memo.size());

	}

}
