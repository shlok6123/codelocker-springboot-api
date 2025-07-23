package com.shlok.CodeLocker.controller;

import com.shlok.CodeLocker.model.Snippet;
import com.shlok.CodeLocker.service.SnippetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snippets")
@RequiredArgsConstructor
public class SnippetController {
    private final SnippetService snippetService;



    @PostMapping
    public Snippet createSnippet(@Valid @RequestBody Snippet snippet)
    {
       return snippetService.saveSnippet(snippet);
    }

    @GetMapping
    public List<Snippet> getAllSnippets() {
        return snippetService.getAllSnippets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Snippet> getSnippetById(@PathVariable Long id) {
        return snippetService.getSnippetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Snippet> updateSnippet(@Valid @PathVariable Long id, @RequestBody Snippet snippetDetails) {
        Snippet updatedSnippet = snippetService.updateSnippet(id, snippetDetails);
        if (updatedSnippet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSnippet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSnippet(@PathVariable Long id) {
        snippetService.deleteSnippet(id);
        return ResponseEntity.noContent().build();
    }
}
