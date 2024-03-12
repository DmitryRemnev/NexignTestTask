package org.dmitry.testtask.service;

import lombok.RequiredArgsConstructor;
import org.dmitry.testtask.dto.Response;
import org.dmitry.testtask.trie.Trie;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrieServiceImpl implements TrieService {
    public static final String INVALID_PARAMETER = "Невалидный парметр!";
    private final Trie trie;

    @Override
    public Response countWord(String word) {
        if (word.isBlank()) {
            return new Response(null, INVALID_PARAMETER);
        }

        int result;
        try {
            result = trie.countWords(word);
        } catch (Exception e) {
            return new Response(null, e.getMessage());
        }

        return new Response(result, null);
    }
}
