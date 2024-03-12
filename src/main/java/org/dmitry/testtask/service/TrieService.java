package org.dmitry.testtask.service;

import org.dmitry.testtask.dto.CountWordsResponse;

public interface TrieService {

    CountWordsResponse countWord(String word);
}
