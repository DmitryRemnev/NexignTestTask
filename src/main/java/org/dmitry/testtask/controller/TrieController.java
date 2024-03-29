package org.dmitry.testtask.controller;

import lombok.RequiredArgsConstructor;
import org.dmitry.testtask.dto.CountWordsResponse;
import org.dmitry.testtask.service.TrieService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class TrieController {
    private final TrieService trieService;

    @GetMapping("/count/{word}")
    public ResponseEntity<CountWordsResponse> cowntWord(@PathVariable String word) {
        return ResponseEntity.ok(trieService.countWord(word));
    }
}
