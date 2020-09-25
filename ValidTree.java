package template;

import java.util.*;
// Leetcode 261
// 灌水法
// 求连通性
public class ValidTree {
	/**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
	public boolean validTree(int n, int[][] edges) {
		if (n == 0) return false;
		
		if (edges.length != n - 1) {
			return false;
		}
		
		// 邻接表来表示图
		Map<Integer, Set<Integer>> graph = initializeGraph(n, edges); 
		
		// bfs
		// Queue 和 Hash 通常一块操作
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> hash = new HashSet<>();
		
		// 0 是第一个点
		queue.offer(0);
		hash.add(0);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			// 不需要分层遍历
			// 但是需要判断是否用过
			for (Integer neighbor : graph.get(node)) {
				if (hash.contains(neighbor)) {
					continue;
				}
				hash.add(neighbor);
				queue.offer(neighbor);
			}
		}
		
		return (hash.size() == n);
	}
	
	private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		return graph;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {2, 3}, {2, 4}, {3, 4}};
		ValidTree sol = new ValidTree();
		System.out.println(sol.validTree(n, edges));
	}
}
