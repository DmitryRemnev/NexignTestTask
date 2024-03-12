package org.dmitry.testtask.service;

import lombok.RequiredArgsConstructor;
import org.dmitry.testtask.dto.Response;
import org.dmitry.testtask.trie.Trie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TrieServiceImpl implements TrieService {
    private final Trie trie;

    @Override
    public Response countWord(String word) {
        return new Response(trie.countWords(word), null);
    }
}
