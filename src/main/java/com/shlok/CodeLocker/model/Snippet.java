package com.shlok.CodeLocker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "snippets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snippet {

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