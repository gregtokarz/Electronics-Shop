package dev.gregor.shop.security.auth;



import dev.gregor.shop.security.auth.exception.InvalidEmailAddressException;
import dev.gregor.shop.security.auth.exception.NoSuchUser;
import dev.gregor.shop.security.auth.exception.UserAlreadyExists;
import dev.gregor.shop.security.config.JwtService;
import dev.gregor.shop.user.Role;
import dev.gregor.shop.user.User;
import dev.gregor.shop.user.UserRepository;
import dev.gregor.shop.user.dto.UserDetailsDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

  UserRepository repository;
  PasswordEncoder passwordEncoder;
  JwtService jwtService;
  AuthenticationManager authenticationManager;

  public boolean register(RegisterRequest request) {
    if (invalidEmailAddress(request.getEmail())) {
      throw new InvalidEmailAddressException("Invalid address email");
    }
    if (userExists(request.getEmail())) {
      throw new UserAlreadyExists("User with email " + request.getEmail() + " is already exist");
    }
    var user = User.builder()
            .name(request.getName())
            .surname(request.getSurname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();
    repository.save(user);
    return true;
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    if (invalidEmailAddress(request.getEmail())) {
      throw new InvalidEmailAddressException("Invalid address email");
    }
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = repository.findByEmail(request.getEmail()).orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
  }

  private boolean userExists(String email) {
    return repository.findByEmail(email).isPresent();
  }

  private static boolean invalidEmailAddress(String email) {
    return !ValidateEmail.validateEmail(email);
  }

  public UserDetailsDto getUserDetails(ObjectId id) {
    User user = repository.findById(id).orElseThrow(() -> new NoSuchUser("User with given id doesn't exist"));
    return user.getUserDetails();
  }

  public void cleanup() {
    repository.deleteAll();
  }
}
