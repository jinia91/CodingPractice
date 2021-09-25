package JustPractice;


import java.io.*;
import java.util.*;

public class no17408 {

    static int N, M;
    static int[] arr;
    static Node[] tree;

    public static void main(String... args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	
    	N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new Node[1 << (int)Math.ceil(Math.log(N) / Math.log(2)) + 1];
        StringBuilder res = new StringBuilder();
        
		
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, N);

        M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        
        for (int i = 0; i < M; i++) {
            int q = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
            if (q == 1)
                update(l, r, 1, 1, N);
            else {
                Node first = query(l, r, 1, 1, N);
                Node left = query(l, first.idx - 1, 1, 1, N);
                Node right = query(first.idx + 1, r, 1, 1, N);
                res.append(first.val + Math.max(left.val, right.val)).append('\n');
            }
        }
        
        System.out.println(res);
        
    }

    private static Node init(int n, int s, int e) {
        if (s == e)
            return tree[n] = new Node(arr[s], s);
        int m = s + e >>> 1;
        Node left = init(2 * n, s, m), right = init(2 * n + 1, m + 1, e);
        return tree[n] = left.val > right.val ? left : right;
    }

    private static Node update(int i, int v, int n, int s, int e) {
        if (i > e || i < s)
            return tree[n];
        if (s == e) {
            tree[n].val = v;
            tree[n].idx = i;
            return tree[n];
        }
        int m = s + e >>> 1;
        Node left = update(i, v, 2 * n, s, m), right = update(i, v, 2 * n + 1, m + 1, e);
        return tree[n] = left.val > right.val ? left : right;
    }

    private static Node query(int l, int r, int n, int s, int e) {
        if (l > e || r < s)
            return new Node(-1, -1);
        if (l <= s && e <= r)
            return tree[n];
        int m = s + e >>> 1;
        Node left = query(l, r, 2 * n, s, m), right = query(l, r, 2 * n + 1, m + 1, e);
        return left.val > right.val ? left : right;
    }

}

class Node {
    int val, idx;

    public Node(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
