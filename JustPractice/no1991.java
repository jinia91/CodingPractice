package JustPractice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node {
	int parent;
	int left;
	int right;

}

public class no1991 {

	static StringTokenizer st;
	static ArrayList<Node> graph = new ArrayList<>();
	static int root;
	static StringBuilder sb = new StringBuilder();

	static void preOrder(int root) {

		sb.append((char) (root + 64));
		
		if (graph.get(root).left > 0) {
			preOrder(graph.get(root).left);
		}
		if (graph.get(root).right > 0) {
			preOrder(graph.get(root).right);
		}

	}

	static void inOrder(int root) {

		if (graph.get(root).left > 0) {
			inOrder(graph.get(root).left);
		}

		sb.append((char) (root + 64));
		
		if (graph.get(root).right > 0) {
			inOrder(graph.get(root).right);
		}

	}

	static void postOrder(int root) {

		if (graph.get(root).left > 0) {
			postOrder(graph.get(root).left);
		}
		if (graph.get(root).right > 0) {
			postOrder(graph.get(root).right);
		}
		sb.append((char) (root + 64));

		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N + 1; i++) {

			graph.add(new Node());

		}

		for (int i = 1; i < N + 1; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			int self = st.nextToken().charAt(0) - 64;
			int left = st.nextToken().charAt(0) - 64;
			int right = st.nextToken().charAt(0) - 64;

			if (left > 0) {
				graph.get(left).parent = self;
				graph.get(self).left = left;
			}
			if (right > 0) {
				graph.get(right).parent = self;
				graph.get(self).right = right;
			}

		}
		
		preOrder(1);
		sb.append("\n");
		inOrder(1);
		sb.append("\n");
		postOrder(1);
		
		System.out.println(sb);

	
	}

}
