package com.shlok.CodeLocker.repository;
import com.shlok.CodeLocker.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, Long>{
}
