package com.shlok.CodeLocker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "snippets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snippet {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude // Important: Prevents infinite loops
    @EqualsAndHashCode.Exclude
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Title Cannot be Blank")
    private String title;

    @NotBlank(message = "Code cannot be Blank")
    @Column(columnDefinition = "TEXT")
    private String code;

    @NotBlank(message = "Language Cannot be Blank")
    private String language;


}