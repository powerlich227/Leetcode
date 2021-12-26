import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * LeetCode 207 Schedule
 * 
 * Course Schedule
 * 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
Constraints:

1 <= numCourses <= 10^5
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
	public static void main(String[] args) {
		int num = 2;
		int pre[][] = {{0,1}, {1,0}};
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(num, pre));
	}
	
	/* Topological Sorting
	 * DFS
	 */
	boolean hasCycle;
	boolean[] visited, onPath;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = buildGraph(numCourses, prerequisites);
		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			traverse(graph, i);
		return !hasCycle;
	}
	public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] pre : prerequisites) {
			int from = pre[1], to = pre[0];
			graph[from].add(to);
		}
		return graph;
	}
	public void traverse(List<Integer>[] graph, int v) {
		if (onPath[v])
			hasCycle = true;
		if (visited[v] || hasCycle)
			return;
		visited[v] = true;
		onPath[v] = true;
		for (int i = 0; i < graph.length; i++)
			traverse(graph, i);
		onPath[v] = false;
	}
}
