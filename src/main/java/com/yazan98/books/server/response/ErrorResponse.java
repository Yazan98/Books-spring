package com.yazan98.books.server.response;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:00 AM
 */

public class ErrorResponse implements BaseResponse {

    private int code;
    private String message;
    private Instant timestamp = Instant.now();
    private String path;
    private String status;
    private StackTraceElement[] stackTrace;

    public ErrorResponse() {

    }

    public ErrorResponse(int code, String message, Instant timestamp, String path, String status, StackTraceElement[] stackTrace) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
        this.status = status;
        this.stackTrace = stackTrace;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponse that = (ErrorResponse) o;
        return code == that.code &&
                Objects.equals(message, that.message) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(path, that.path) &&
                Objects.equals(status, that.status) &&
                Arrays.equals(stackTrace, that.stackTrace);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(code, message, timestamp, path, status);
        result = 31 * result + Arrays.hashCode(stackTrace);
        return result;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", path='" + path + '\'' +
                ", status='" + status + '\'' +
                ", stackTrace=" + Arrays.toString(stackTrace) +
                '}';
    }
}
