package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1450 {

	static int N, C, answer;

	static int[] items;
	static ArrayList<Integer> partA = new ArrayList<>();
	static ArrayList<Integer> partB = new ArrayList<>();

	static void bruteForceSum(ArrayList<Integer> part, int start, int end, int sum) {

		if (sum > C)
			return;
		if (start > end) {
			part.add(sum);
			return;
		}

		bruteForceSum(part, start + 1, end, sum);
		bruteForceSum(part, start + 1, end, sum + items[start]);
	}

	static int uBSearch(ArrayList<Integer> part, int target) {

		int s = 0;
		
		// part.size()-1??????? 이게 왜맞지?????
		int e = part.size();

		while (s < e) {
			int mid = (s + e) / 2;
			
			if(part.get(mid) <= target) {
				s = mid+1;
			}
			else e = mid;
		}

		return e;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		items = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		// 풀이 시작
		bruteForceSum(partA, 0, N / 2, 0);
		bruteForceSum(partB, N / 2 + 1, N - 1, 0);

		Collections.sort(partA);
		Collections.sort(partB);

		for(int i = 0; i< partA.size(); i++) {
			
			int target = C - partA.get(i);
			if (target<0) continue;
			
			answer += uBSearch(partB, target);
		}
		
		System.out.println(answer);
	}

}
