//Implement Trie (Prefix Tree)

//PROBLEM:
/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

//SOLUTION:
class Node {
    boolean isWord;
    Node[] children = new Node[26];
}

class Trie {
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node temp = root;
        
        for (char c : word.toCharArray()) {
            int bucket = getBucketId(c);
            
            if (temp.children[bucket] == null) {
                temp.children[bucket] = new Node();
            }
            
            temp = temp.children[bucket];
        }
        
        temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node temp = root;
        
        for (char c : word.toCharArray()) {
            int bucket = getBucketId(c);
            
            if (temp.children[bucket] == null) {
                return false;
            }
            
            temp = temp.children[bucket];
        }
        
        return (temp.isWord);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node temp = root;
        
        for (char c : prefix.toCharArray()) {
            int bucket = getBucketId(c);
            
            if (temp.children[bucket] == null) {
                return false;
            }
            
            temp = temp.children[bucket];
        }
        
        return true;
    }
    
    private int getBucketId(char c) {
        return c - 'a';
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
