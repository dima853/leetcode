package org.lessons.tree.trie;

class TrieNode {
    private final int ALPHABET_SIZE = 26;
    private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    private boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}

public class Trie {
    private static final int ALPHABET_SIZE = 26;
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setEndOfWord(true);
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (current.getChildren()[index] == null) {
                return false;
            }
            current = current.getChildren()[index];
        }
        return current != null && current.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = new TrieNode();
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (current.getChildren()[index] == null) {
                return false;
            }
            current = current.getChildren()[index];
        }
        return current != null;
    }

    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return isEmptyNode(current);  
        }
        char ch = word.charAt(index);
        int charIndex = ch - 'a';
        TrieNode next = current.getChildren()[charIndex];

        if (next == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = deleteHelper(next, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.getChildren()[charIndex] = null;
            return isEmptyNode(current) && !current.isEndOfWord();
        }

        return false;
    }

    private boolean isEmptyNode(TrieNode node) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.getChildren()[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");

        System.out.println("Search 'apple': " + trie.search("apple"));   // true
        System.out.println("Search 'app': " + trie.search("app"));       // true
        System.out.println("Search 'ap': " + trie.search("ap"));        // false
        System.out.println("startsWith 'app': " + trie.startsWith("app")); // true
        System.out.println("startsWith 'bana': " + trie.startsWith("bana")); // true

        trie.delete("apple");
        System.out.println("Search 'apple' after delete: " + trie.search("apple")); // false
        System.out.println("Search 'app' after delete: " + trie.search("app"));    // true (app все еще есть)
    }
}