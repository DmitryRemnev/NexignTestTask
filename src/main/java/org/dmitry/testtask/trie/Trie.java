package org.dmitry.testtask.trie;

public class Trie {
    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;

        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);

            if (!current.getChildren().containsKey(c)) {

                var node = new TrieNode();
                current.getChildren().put(c, node);
                current.getNum().put(c, 1);
            } else {

                current.getNum().put(c, current.getNum().get(c) + 1);
            }

            current = current.getChildren().get(c);
        }

        current.setEndOfWord(true);
    }

    public int countWords(String word) {
        TrieNode current = root;
        char c;
        int wordCount = 0;

        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);

            if (!current.getChildren().containsKey(c)) {
                wordCount = 0;
                break;
            }

            if (current.getChildren().get(c).isEndOfWord()) {
                wordCount = current.getNum().get(c);
            }

            current = current.getChildren().get(c);
        }

        return wordCount;
    }
}
