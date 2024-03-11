package org.dmitry.testtask.service;

import org.dmitry.testtask.dto.Response;

public interface FileService {
    Response readFile();

    int countWord(String word);
}
