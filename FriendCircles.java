import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
	public static void main(String[] args) {
		System.out.println();
	}
	public int findCircleNum(int[][] M) {
		int res = 0;
		int m = M.length;
		boolean[] visited = new boolean[m];
        Queue<Integer> q = new LinkedList<>();
        
		for (int i = 0; i < m; i++) {
			if(!visited[i]) {
				q.add(i);
				visited[i] = true;
				res++;
				while(!q.isEmpty()) {
					int n = q.poll();
					for (int j = 0; j < m; j++) {
						if(M[n][j] == 1 && !visited[j]) {
							visited[j] = true;
							q.add(j);
                        }
					}
				}
			}
		}
		return res;
	}
}
