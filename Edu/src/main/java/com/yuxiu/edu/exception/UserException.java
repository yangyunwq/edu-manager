package com.yuxiu.edu.exception;

/**
 * @author yangyun
 * @date 2019-08-06 21:46
 */
public class UserException extends RuntimeException {
    private String message;

    public UserException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
