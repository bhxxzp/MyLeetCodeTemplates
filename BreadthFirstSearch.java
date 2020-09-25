package template;
import java.util.*;

public class BreadthFirstSearch {
	/**
	 * @param root: The root of binary tree.
	 * @return: Level order a list of lists of integer
	 */
	public List<List<Integer>> bfs(TreeNode root) {
		List<List<Integer>> results = new ArrayList<>();
		if (root == null) {
			return results;
		}
		
		// interface
		// 1. 创建一个队列，把起始节点都放到里面去(第1层节点)
		// 1. put start node into queue
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		// 2. while队列不空，处理队列中的节点，并拓展出新的节点
		// 2. while queue is not empty
		while (!queue.isEmpty()) {
			// for 上一层的节点，拓展下一层的节点
			// 因为queue.size()会变，所以size要先取出
			// 3. level x -> x + 1
			// 分层遍历
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			
			results.add(level);
		}
		
		return results;
	}
}
