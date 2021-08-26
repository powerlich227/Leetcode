/*
 * LeetCode 208 Medium
 * 
 * Implement Trie
 * 
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 
Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:
1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 */
public class ImplementTrie {
	
	private class TrieNode {
		private TrieNode[] nodes;
		private boolean isEnd;
		public TrieNode() {
			nodes = new TrieNode[26];
		}
		public boolean containsKey(char c) {
			return nodes[c - 'a'] != null;
		}
		public TrieNode get(char c) {
			return nodes[c - 'a'];
		}
		public void put(char c, TrieNode node) {
			nodes[c - 'a'] = node;
		}
		public void setEnd() {
			isEnd = true;
		}
		public boolean isEnd() {
			return isEnd;
		}
	}
	
	private TrieNode root;
	
	/** Initialize your data structure here. **/
	public ImplementTrie() {
		root = new TrieNode();
	}
	/** Insert a word into the trie.
	 * O(m) **/
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (!node.containsKey(cur))
				node.put(cur, node);
			node = node.get(cur);
		}
		node.setEnd();
	}
	
	private TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (node.containsKey(cur))
				node = node.get(cur);
			else
				return null;
		}
		return node;
	}
	/** Returns if the word is in the trie. **/
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node != null && node.isEnd();
	}
	
	/** Returns if there is any word in the trie that starts with the given prefix. **/
	public boolean startsWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}
}
