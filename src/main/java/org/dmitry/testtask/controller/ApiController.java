package org.dmitry.testtask.controller;

import lombok.RequiredArgsConstructor;
import org.dmitry.testtask.dto.Response;
import org.springframework.http.ResponseEntity;
import org.dmitry.testtask.service.FileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final FileService fileService;

    @GetMapping("/read")
    public ResponseEntity<Response> readFile() {
        return ResponseEntity.ok(fileService.readFile());
    }
}
