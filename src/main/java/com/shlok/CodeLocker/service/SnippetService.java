package com.shlok.CodeLocker.service;

import com.shlok.CodeLocker.model.Snippet;
import com.shlok.CodeLocker.repository.SnippetRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnippetService {
    private final SnippetRepository snippetRepository;



    public Snippet saveSnippet(Snippet snippet) {
        return snippetRepository.save(snippet);
    }

    public List<Snippet> getAllSnippets() {
        return snippetRepository.findAll();
    }


    public Optional<Snippet> getSnippetById(Long id){
        return snippetRepository.findById(id);
    }

    public Snippet updateSnippet(Long id,Snippet updatedSnippet){
        return snippetRepository.findById(id).
                map(snippet -> {
                    snippet.setTitle(updatedSnippet.getTitle());
                    snippet.setLanguage(updatedSnippet.getLanguage());
                    snippet.setCode(updatedSnippet.getCode());
                    return snippetRepository.save(snippet);
                })
                .orElse(null);
    }

    public void deleteSnippet(Long id) {
        snippetRepository.deleteById(id);
    }
}
