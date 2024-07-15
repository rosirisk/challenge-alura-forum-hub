package br.com.forumhub.controller;

import br.com.forumhub.model.dto.LoginDTO;
import br.com.forumhub.service.TokenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<TokenDTO> loginUser(
      @RequestBody @Valid LoginDTO loginDTO) {

    UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(loginDTO.email(),
        loginDTO.password());

    Authentication authentication = authManager.authenticate(userAuth);

    String token = tokenService.generateToken(authentication);

    return ResponseEntity.ok().body(new TokenDTO(token));
  }
}
