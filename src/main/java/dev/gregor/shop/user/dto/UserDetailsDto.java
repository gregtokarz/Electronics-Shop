package dev.gregor.shop.user.dto;

import dev.gregor.shop.user.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserDetailsDto {

  ObjectId id;
  String firstName;
  String lastName;
  String email;
  Role role;
}
