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

		// ��Ʈ�������� �Է� ����� ���� ��ġ�� ã�� �����ϱ�
		public void makeNode(int idx) {

			// �� ��庸�� ������� ���� �ڽ� ��� ����
			if (idx < this.idx) {

				// �����ڽĳ�尡 ������� �ű⿡ ����
				if (this.lChild == null) {

					lChild = new Node(idx);

				}

				// ���� �ڽ� ��尡 �����Ѵٸ� �����ڽĳ��� ���ڸ� �Ѱ� ��ͷ� ��ġã��
				else {

					lChild.makeNode(idx);

				}

			}

			// �� ��庸�� Ŭ��� ������ �ڽ� ��� ����
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

		// PreOrder�̹Ƿ� ���ʰ��� root
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
