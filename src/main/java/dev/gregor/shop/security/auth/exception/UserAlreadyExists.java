package dev.gregor.shop.security.auth.exception;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserAlreadyExists extends RuntimeException {
  public UserAlreadyExists(String errorMessage) {
    super(errorMessage);
  }
}
