package com.example.solid_demo.utils;

/**
 * A generic wrapper for handling UI states (Success/Failure) professionally.
 */
public class Result<T> {
    private final T data;
    private final String message;
    private final boolean isSuccess;

    private Result(T data, String message, boolean isSuccess) {
        this.data = data;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> success(T data) { return new Result<>(data, null, true); }
    public static <T> Result<T> failure(String msg) { return new Result<>(null, msg, false); }

    public boolean isSuccess() { return isSuccess; }
    public T getData() { return data; }
    public String getMessage() { return message; }
}