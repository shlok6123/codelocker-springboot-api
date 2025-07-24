package com.shlok.CodeLocker.service;

import com.shlok.CodeLocker.exception.ResourceNotFoundException;
import com.shlok.CodeLocker.model.Snippet;
import com.shlok.CodeLocker.model.User;
import com.shlok.CodeLocker.repository.SnippetRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import lombok.ToString;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnippetService {
    private final SnippetRepository snippetRepository;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude // Important: Prevents infinite loops
    private User user;


    public Snippet saveSnippet(Snippet snippet, User user) {
        snippet.setUser(user); // Set the owner
        return snippetRepository.save(snippet);
    }

    public List<Snippet> getAllSnippets(User user) {
        return snippetRepository.findByUser(user);
    }

    public List<Snippet> getAllSnippets() {
        return snippetRepository.findAll();
    }


    // In SnippetService.java
    public Snippet getSnippetById(Long id) {
        return snippetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snippet not found with id: " + id));
    }

    public Snippet updateSnippet(Long id,Snippet updatedSnippet){
        Snippet snippet = snippetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Snippet not found with id: " + id));

        snippet.setTitle(updatedSnippet.getTitle());
        snippet.setLanguage(updatedSnippet.getLanguage());
        snippet.setCode(updatedSnippet.getCode());
        return snippetRepository.save(snippet);
    }

    public void deleteSnippet(Long id) {
        snippetRepository.deleteById(id);
    }
}
