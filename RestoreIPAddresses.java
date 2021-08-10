import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 93 Medium
 * 
 * Restore IP Addresses
 * 
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. 
For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 

Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:
Input: s = "1111"
Output: ["1.1.1.1"]

Example 4:
Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]

Example 5:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 
Constraints:
0 <= s.length <= 3000
s consists of digits only.
 */
public class RestoreIPAddresses {
	// DFS
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, "", 0, res);
        return res;
    }
    // k: level from 0 to 3
    public void helper(String s, String out, int k, List<String> res) {
        if (k == 4) {
            if (s.isEmpty())
                res.add(out);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i > s.length())
                break;
            String cur = s.substring(0, i);
            int val = Integer.parseInt(cur);
            if (val > 255 || i != String.valueOf(val).length())
                continue;
            helper(s.substring(i), out + cur + (k == 3 ? "" : "."), k + 1, res);
        }
    }
	public static void main(String[] args) {
		RestoreIPAddresses test = new RestoreIPAddresses();
		System.out.println(test.restoreIpAddresses("25525511135"));
		System.out.println(test.restoreIpAddresses("0"));
		System.out.println(test.restoreIpAddresses("1111"));
		System.out.println(test.restoreIpAddresses("010010"));
		System.out.println(test.restoreIpAddresses("101023"));

	}
}
