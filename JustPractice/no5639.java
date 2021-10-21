package JustPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no5639 {

	static class Node {

		int idx;
		Node lChild;
		Node rChild;

		public Node(int idx) {
			this.idx = idx;
		}

		// 루트에서부터 입력 노드의 논리적 위치를 찾아 생성하기
		public void makeNode(int idx) {

			// 현 노드보다 작을경우 왼쪽 자식 노드 보기
			if (idx < this.idx) {

				// 왼쪽자식노드가 비었으면 거기에 삽입
				if (this.lChild == null) {

					lChild = new Node(idx);

				}

				// 왼쪽 자식 노드가 존재한다면 왼쪽자식노드로 인자를 넘겨 재귀로 위치찾기
				else {

					lChild.makeNode(idx);

				}

			}

			// 현 노드보다 클경우 오른쪽 자식 노드 보기
			else {

				if (this.rChild == null) {

					rChild = new Node(idx);

				}

				else {

					rChild.makeNode(idx);

				}

			}

		}

	}

	static StringBuilder sb = new StringBuilder();

	static void postOrder(Node start) {

		if (start.lChild != null) {

			postOrder(start.lChild);
			
		}
		
		if (start.rChild != null) {

			postOrder(start.rChild);
			
		}

		sb.append(start.idx+"\n");

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// PreOrder이므로 최초값이 root
		int rootIdx = Integer.parseInt(br.readLine());

		Node root = new Node(rootIdx);

		String input;
		while ((input = br.readLine()) != null) {
			int idx = Integer.parseInt(input);

			root.makeNode(idx);
		}

		postOrder(root);
		
		System.out.println(sb);
		
	}

}
