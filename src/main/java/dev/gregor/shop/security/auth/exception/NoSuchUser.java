package dev.gregor.shop.security.auth.exception;

public class NoSuchUser extends RuntimeException {
    public NoSuchUser(String errorMessage) {
        super(errorMessage);
    }
}
