package org.dmitry.testtask.config;

import lombok.extern.slf4j.Slf4j;
import org.dmitry.testtask.trie.Trie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@Slf4j
public class TrieConfig {
    private final String filePath;

    public TrieConfig(@Value("${file-path}") String filePath) {
        this.filePath = filePath;
    }

    @Bean
    public Trie trie() {
        var trie = new Trie();

        try (Stream<String> stream = Files.lines(Paths.get(filePath)).parallel()) {
            List<String> list = stream.collect(Collectors.toList());

            for (String string : list) {
                String[] arr = string.replaceAll("([^A-Za-zА-Яа-я\\s])", " ")
                        .trim()
                        .split("\\s+");

                for (String s : arr) {
                    trie.insert(s);
                }
            }

        } catch (FileNotFoundException e) {
            log.error("Файл не найден!");
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return trie;
    }
}
