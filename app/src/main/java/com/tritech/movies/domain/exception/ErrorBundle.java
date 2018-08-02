package com.tritech.movies.domain.exception;

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}