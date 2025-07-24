package com.shlok.CodeLocker.repository;
import com.shlok.CodeLocker.model.Snippet;
import com.shlok.CodeLocker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, Long>{
    List<Snippet> findByUser(User user);
}
