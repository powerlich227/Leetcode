/*
 * LeetCode 211 Medium
 * 
 * Design Add and Search Words Data Structure
 * 
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. 
word may contain dots '.' where dots can be matched with any letter.
 

Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:
1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.
 */
public class DesignAddAndSearchWordsDataStructure {
    class TrieNode {
        private TrieNode[] link;
        private boolean isEnd;
        
        public TrieNode() {
            link = new TrieNode[26];
        }
        public boolean containsKey(char c) {
            return link[c - 'a'] != null;
        }
        public void put(char c, TrieNode node) {
            link[c - 'a'] = node;
        }
        public TrieNode get(char c) {
            return link[c - 'a'];
        }
        public TrieNode[] getLink() {
            return link;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    /** Initialize your data structure here. */
    private TrieNode root;
    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c))
                node.put(c, new TrieNode());
            node = node.get(c);
        }
        node.setEnd();
    }
    
    /** search **/   
    public boolean dfs(String word, int k, TrieNode node) {     
        if (k == word.length())
            return node.isEnd();
        char c = word.charAt(k);
        if (c != '.')
            return node.containsKey(c) && dfs(word, k + 1, node.get(c));
        else {
            for (int i = 0; i < node.getLink().length; i++) {
                if (node.getLink()[i] != null) {
                    if (dfs(word, k + 1, node.getLink()[i]))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}
