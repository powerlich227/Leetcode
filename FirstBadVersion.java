public class FirstBadVersion extends VersionControl {

	public int firstBadVersion(int n) {
//		for (int i = 1; i <= n; i++) {
//			if (isBadVersion(i))
//				return i;
//		}
//		return n;
		int l = 1, r = n;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (isBadVersion(m))
				r = m;
			else
				l = m + 1;
		}
		return r;
	}
}
