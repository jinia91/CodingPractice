import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1931 {

	static ArrayList<working> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(new working());
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			list.get(i).start = Integer.valueOf(st.nextToken());
			list.get(i).end = Integer.valueOf(st.nextToken());

		}

		Collections.sort(list);

		int count = 0;
		int endtime = 0;

		for (int i = 0; i < N; i++) {

			if (list.get(i).start >= endtime) {
				endtime = list.get(i).end;
				count++;
			}

		}
		
		System.out.println(count);

	}

}

class working implements Comparable<working> {

	int start;
	int end;

	@Override
	public int compareTo(working other) {

		if (this.end != other.end)
			return this.end - other.end;
		else
			return this.start - other.end;

	}

}
