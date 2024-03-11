package org.dmitry.testtask.trie;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TrieNode {

    private final Map<Character, TrieNode> children = new HashMap<>();

    private boolean isEndOfWord = false;

    private Map<Character, Integer> num = new HashMap<>();
}
