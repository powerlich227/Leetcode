import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] graph = new int[numCourses][numCourses];
		int[] indegree = new int[numCourses];
		for (int[] pre : prerequisites) {
			// pre: pre[1]; course: pre[0]
			if (graph[pre[1]][pre[0]] == 0)
				indegree[pre[0]]++; // indegree of course
			graph[pre[1]][pre[0]] = 1;
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}
		int count = 0;
		while (!q.isEmpty()) {
			int pre = q.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {  
				if (graph[pre][i] == 1) {
					if (--indegree[i] == 0)
						q.offer(i);
				}
			}
		}
		return count == numCourses;
	}
}
