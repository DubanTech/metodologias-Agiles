package com.duban.exception;
public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}