package com.kh.variable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no1967 {

	static class Node {

		ArrayList<int[]> adjNodes = new ArrayList<>();

	}

	static int n, maxLenth, edgeNode;
	static StringTokenizer st;
	static ArrayList<Node> graph = new ArrayList<>();
	static boolean[] visited;

	static void dfs(int cur, int dis) {

		visited[cur] = true;

		for (int i = 0; i < graph.get(cur).adjNodes.size(); i++) {
			int[] adj = graph.get(cur).adjNodes.get(i);

			if (!visited[adj[0]]) {

				if (maxLenth < dis + adj[1]) {

					maxLenth = dis + adj[1];
					edgeNode = adj[0];
				}

				dfs(adj[0], dis + adj[1]);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {

			graph.add(new Node());

		}

		
		for(int i =0; i<n-1; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int curNodeIdx = Integer.parseInt(st.nextToken());
			
			int adjIdx = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			int[] adjNode = {adjIdx, length};
			int[] curNode = {curNodeIdx, length};
			
			graph.get(curNodeIdx).adjNodes.add(adjNode);
			graph.get(adjIdx).adjNodes.add(curNode);
			
		}
		
		dfs(1, 0);

		visited = new boolean[n + 1];
		maxLenth = 0;

		dfs(edgeNode, 0);

		System.out.println(maxLenth);

	}

}
