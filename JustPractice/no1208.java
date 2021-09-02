package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1208 {

	static int N, S;
	static long cnt;
	static int[] arr;

	static ArrayList<Long> partA = new ArrayList<>();
	static ArrayList<Long> partB = new ArrayList<>();

	static void bF(ArrayList<Long> part, int s, int e, long sum) {

		if (s > e) {
			part.add(sum);
			return;
		}

		bF(part, s + 1, e, sum);
		bF(part, s + 1, e, sum + arr[s]);
	}

	static void tPointer() {

		int s = 0;

		int e = partB.size() - 1;

		while (s < partA.size() && e >= 0) {

			long sum = partA.get(s) + partB.get(e);
			
			if (sum > S)
				e--;
			else if (sum < S)
				s++;

			else {

				long a = partA.get(s);
				long b = partB.get(e);

				long countA = 0;
				long countB = 0;

				while (s < partA.size() && a == partA.get(s)) {

					s++;
					countA++;

				}

				while (e >= 0 && b == partB.get(e)) {

					e--;
					countB++;

				}
				
				cnt += countA*countB;

			}

		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bF(partA, 0, N / 2, 0);
		bF(partB, N / 2 + 1, N - 1, 0);

		Collections.sort(partA);
		Collections.sort(partB);
		
		tPointer();

		if (S == 0)
			System.out.println(cnt - 1);
		else
			System.out.println(cnt);
	}

}
