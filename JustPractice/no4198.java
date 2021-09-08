package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class no4198 {

	static int[] arr;
	static ArrayList<Integer> memo = new ArrayList<>();
	static ArrayList<Integer> memo3 = new ArrayList<>();

	static void dp1(int x, int i) {

		if (x > memo.get(memo.size() - 1)) {
			memo.add(x);
			return;
		}

		int idx = upperBound(x);
		if (idx != 0)
			memo.set(idx, x);
	}

	static void dp2(int x, int i) {

		if (x < memo3.get(memo3.size() - 1)) {
			memo3.add(x);
			return;
		}

		int idx = upperBound2(x);

		if (idx != 0)
			memo3.set(idx, x);
	}

	private static int upperBound(int x) {
		int left = 0;
		int right = memo.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (memo.get(mid) < x) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}

		return right;
	}

	private static int upperBound2(int x) {
		int left = 0;
		int right = memo3.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;
			if (memo3.get(mid) > x) {
				left = mid + 1;
			} else {
				right = mid;
			}

		}

		return right;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		
		for (int i = 0; i < N; i++) {

			memo.add(arr[i]);
			memo3.add(arr[i]);
			
			for (int j = i + 1; j < N; j++) {
				dp1(arr[j], i);
				dp2(arr[j], i);
			}

			int length = memo.size();
			int length2 = memo3.size();
			
//			System.out.println(length);
//			System.out.println(length2);
			
			
			max = Math.max((length + length2 -1),max);
			
			memo.clear();
			memo3.clear();
		}

	
		System.out.println(max);

	}

}
