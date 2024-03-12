package org.dmitry.testtask.service;

import lombok.RequiredArgsConstructor;
import org.dmitry.testtask.dto.CountWordsResponse;
import org.dmitry.testtask.trie.Trie;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrieServiceImpl implements TrieService {
    public static final String INVALID_PARAMETER = "Невалидный парметр!";
    private final Trie trie;

    @Override
    public CountWordsResponse countWord(String word) {
        if (word.isBlank()) {
            throw new IllegalArgumentException(INVALID_PARAMETER);
        }

        return new CountWordsResponse(trie.countWords(word));
    }
}
