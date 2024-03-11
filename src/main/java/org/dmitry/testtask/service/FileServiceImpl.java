package org.dmitry.testtask.service;

import org.dmitry.testtask.dto.Response;
import org.dmitry.testtask.trie.Trie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file-path}")
    private String filePath;

    @Override
    public Response readFile() {
        Trie trie = createExampleTrie();
        int count = trie.countWords("Волга");

        System.out.println(count);

        return new Response("Ok");
    }

    @Override
    public int countWord(String word) {
        return 0;
    }

    private Trie createExampleTrie() {
        Trie trie = new Trie();

        trie.insert("Волга");
        trie.insert("Волга");
        trie.insert("Урал");

        return trie;
    }
}
