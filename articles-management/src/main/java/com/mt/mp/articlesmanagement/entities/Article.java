package com.mt.mp.articlesmanagement.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Details about articles")
public class Article {
    @Id
    @ApiModelProperty(notes = "The unique id of the article", required = true)
    private Long id;
    @NotBlank(message = "Title field is required")
    @Size(min = 3, max = 25, message = "Title field size must be between 3 and 25")
    @ApiModelProperty(notes = "The article's title", required = true)
    private String title;
    @NotBlank(message = "Link field is required")
    @ApiModelProperty(notes = "The article's link", required = true)
    private String link;
}
