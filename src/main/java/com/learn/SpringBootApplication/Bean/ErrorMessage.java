package com.learn.SpringBootApplication.Bean;

import java.time.LocalDateTime;

public class ErrorMessage {

    private LocalDateTime timestamp;
    private String Message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ErrorMessage(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        Message = message;
        this.details = details;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    private String details;


}
