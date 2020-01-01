package com.mt.mp.articlesmanagement.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class ErrorDetails {
    private String status;
    private String path;
    private List<String> messages;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    public ErrorDetails(String status, String path) {
        this.status = status;
        this.path = path;
        this.messages = new ArrayList<>();
        this.timestamp =  LocalDateTime.now();
    }

    public ErrorDetails() {
        this.timestamp = LocalDateTime.now();
        this.messages = new ArrayList<>();
    }

    public void addErrorMessage(String message){
        this.messages.add(message);
    }
}
