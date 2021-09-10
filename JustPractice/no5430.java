package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class no5430 {

	static int T;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		loop: for (int i = 0; i < T; i++) {

			String oper = br.readLine();
			int N = Integer.parseInt(br.readLine());

			String arr = br.readLine();
			arr = arr.substring(1, arr.length() - 1);
			StringTokenizer st = new StringTokenizer(arr, ",");

			LinkedList<Integer> dq = new LinkedList<>();

			for (int j = 0; j < N; j++) {

				dq.add(Integer.parseInt(st.nextToken()));

			}

			boolean reverseFlag = false;

			for (int j = 0; j < oper.length(); j++) {

				if (oper.charAt(j) == 'R') {
					reverseFlag = !reverseFlag;
				}

				else if (oper.charAt(j) == 'D') {

					if (dq.isEmpty()) {

						answer.append("error").append("\n");
						continue loop;

					} else {
						if (!reverseFlag) {
							dq.pollFirst();
						} else {
							dq.pollLast();
						}
					}
				}

			}

			if (!reverseFlag) {

				Integer[] ansInt = dq.toArray(new Integer[dq.size()]);

				String tmp = Arrays.toString(ansInt);

				String ans = tmp.replaceAll(" ", "");

				answer.append(ans).append("\n");

			}

			else if (reverseFlag) {

				Collections.reverse(dq);

				Integer[] ansInt = dq.toArray(new Integer[dq.size()]);

				String tmp = Arrays.toString(ansInt);

				String ans = tmp.replaceAll(" ", "");

				answer.append(ans).append("\n");

			}

		}

		System.out.println(answer);

	}

}
