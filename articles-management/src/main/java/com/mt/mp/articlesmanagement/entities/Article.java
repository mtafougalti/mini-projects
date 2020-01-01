package com.mt.mp.articlesmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Article {
    @Id
    private Long id;
    @NotBlank(message = "Title field is required")
    @Size(min = 3, max = 25, message = "Title field size must be between 3 and 25")
    private String title;
    @NotBlank(message = "Link field is required")
    private String link;
}
