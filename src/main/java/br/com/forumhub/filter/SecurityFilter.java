package br.com.forumhub.filter;

import java.io.IOException;

import br.com.forumhub.repository.UsuarioRepository;
import br.com.forumhub.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UsuarioRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    String token = tokenService.stripBearer(request);

    if (token != null) {

      String email = tokenService.getSubject(token);
      UserDetails usuario = userRepository.findByEmail(email).get();

      UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(usuario, null,
          usuario.getAuthorities());

      SecurityContextHolder.getContext().setAuthentication(userAuth);
    }

    filterChain.doFilter(request, response);
  }

}
