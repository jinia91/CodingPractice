import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class no14567 {

	static int[] degree;
	static ArrayList<ArrayList<Integer>> edgelist = new ArrayList<>();
	static int[] session;

	static void TS() {

		Queue<Integer> sorting = new LinkedList<>();
		int sess = 0;
		session[0] = 1;

		while (true) {

			sess++;

			for (int i = 1; i < degree.length; i++) {

				if (session[i] == 0 && degree[i] == 0) {

					sorting.offer(i);
					session[i] = sess;
				}

			}

			while (!sorting.isEmpty()) {

				int now = sorting.poll();

				for (int i = 0; i < edgelist.get(now).size(); i++) {

					degree[edgelist.get(now).get(i)] -= 1;

				}

			}

			boolean contains = IntStream.of(session).anyMatch(x -> x== 0);
			if(!contains) break;
			
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		degree = new int[N + 1];
		session = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {

			edgelist.add(new ArrayList<Integer>());

		}

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int sA = Integer.valueOf(st.nextToken());
			int sB = Integer.valueOf(st.nextToken());

			degree[sB]++;
			edgelist.get(sA).add(sB);

		}

		TS();

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < N + 1; i++) {

			sb.append(session[i]).append(" ");

		}

		System.out.println(sb);

	}

}
