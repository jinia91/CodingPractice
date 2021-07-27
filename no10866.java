import java.io.*;

import java.util.*;

public class no10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();

		int N = Integer.valueOf(S);

		LinkedList que = new LinkedList();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {

			String x = br.readLine();

			if (x.contains("push_back")) {

				String[] y = x.split(" ");
				int p = Integer.valueOf(y[1]);
				que.offer(p);
			}
			
			else if (x.contains("push_front")) {

				String[] y = x.split(" ");
				int p = Integer.valueOf(y[1]);
				que.offerFirst(p);
			}
			

			else if (x.equals("pop_front")) {

				if (!que.isEmpty())
					sb.append(que.poll()).append("\n");
				else
					sb.append("-1").append("\n");
			}
			else if (x.equals("pop_back")) {

				if (!que.isEmpty())
					sb.append(que.pollLast()).append("\n");
				else
					sb.append("-1").append("\n");
			}

			else if (x.equals("size")) {
				sb.append(que.size()).append("\n");
			}

			else if (x.equals("empty")) {
				if (que.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
			}

			else if (x.equals("front")) {
				if (que.isEmpty())
					sb.append("-1").append("\n");
				else sb.append(que.peekFirst()).append("\n");
			} 
			else if (x.equals("back")) {
				if (que.isEmpty())
					sb.append("-1").append("\n");
				else sb.append(que.peekLast()).append("\n");
			}
		}

		System.out.println(sb);

	}

}
