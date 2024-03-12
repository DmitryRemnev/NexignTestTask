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
    public static final String CHARACTER_REGEX = "([^A-Za-zА-Яа-я\\s])";
    public static final String FILE_NOT_FOUND = "Файл не найден!";
    private final String filePath;

    public TrieConfig(@Value("${file-path}") String filePath) {
        this.filePath = filePath;
    }

    @Bean
    public Trie trie() {
        var trie = new Trie();

        try (Stream<String> stream = Files.lines(Paths.get(filePath)).parallel()) {
            stream.forEach(line -> {
                String[] arr = createArrayFromLine(line);

                for (String s : arr) {
                    trie.insert(s);
                }
            });

        } catch (FileNotFoundException e) {
            log.error(FILE_NOT_FOUND);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return trie;
    }

    private String[] createArrayFromLine(String line) {
        return line.replaceAll(CHARACTER_REGEX, " ")
                .trim()
                .split("\\s+");
    }
}
