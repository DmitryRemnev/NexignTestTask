package org.dmitry.testtask.controller;

import lombok.RequiredArgsConstructor;
import org.dmitry.testtask.dto.Response;
import org.dmitry.testtask.service.TrieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrieController {
    private final TrieService trieService;

    @GetMapping("/count/{word}")
    public ResponseEntity<Response> cowntWord(@PathVariable String word) {
        return ResponseEntity.ok(trieService.countWord(word));
    }
}
