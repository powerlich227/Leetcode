import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		System.out.println();
	}
	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		return helper(head, map);
	}
	public Node helper(Node node, Map<Node, Node> map) {
		if (node == null)
			return null;
		if (map.containsKey(node))
			return map.get(node);
		Node res = new Node(node.val);
		map.put(node, res);
		res.next = helper(node.next, map);
		res.random = helper(node.random, map);
		return res;
	}
	
}
