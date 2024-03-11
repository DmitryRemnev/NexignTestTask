package org.dmitry.testtask.service;

import org.dmitry.testtask.dto.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file-path}")
    private String filePath;

    @Override
    public Response readFile() {
        System.out.println(filePath);

        return new Response("Ok");
    }

    @Override
    public int countWord(String word) {
        return 0;
    }
}
