package com.shlok.CodeLocker.controller;

import com.shlok.CodeLocker.model.Snippet;
import com.shlok.CodeLocker.model.User;
import com.shlok.CodeLocker.repository.UserRepository;
import com.shlok.CodeLocker.service.SnippetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/snippets")
@RequiredArgsConstructor
public class SnippetController {
    private final SnippetService snippetService;

    private final UserRepository userRepository; // Add this

    @PostMapping
    public Snippet createSnippet(@Valid @RequestBody Snippet snippet, Principal principal) {
        User currentUser = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return snippetService.saveSnippet(snippet, currentUser);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Snippet> getSnippetById(@PathVariable Long id) {
        Snippet snippet = snippetService.getSnippetById(id);
        return ResponseEntity.ok(snippet);
    }


    @GetMapping
    public List<Snippet> getAllSnippets(Principal principal) {
        User currentUser = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return snippetService.getAllSnippets(currentUser);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable Long id, @Valid @RequestBody Snippet snippetDetails) {
        Snippet updatedSnippet = snippetService.updateSnippet(id, snippetDetails);
        return ResponseEntity.ok(updatedSnippet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSnippet(@PathVariable Long id) {
        snippetService.deleteSnippet(id);
        return ResponseEntity.noContent().build();
    }
}
