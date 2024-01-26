package dev.gregor.shop.user;

import dev.gregor.shop.user.dto.UserDetailsDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserInfo extends UserDetails {
  UserDetailsDto getUserDetails();
}
