package br.com.forumhub;

import br.com.forumhub.model.entity.Perfil;
import br.com.forumhub.model.entity.Usuario;
import br.com.forumhub.model.enums.RoleEnum;
import br.com.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ForumHubApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ForumHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Optional<Usuario> optional = usuarioRepository.findByEmail("teste@teste.com");
			if (optional.isEmpty()) {
				Perfil perfil = Perfil.builder()
						.nome(RoleEnum.ADMIN)
						.build();
				Usuario usuario = Usuario.builder()
						.email("teste@teste.com")
						.nome("Teste")
						.senha(passwordEncoder.encode("senha12345"))
						.perfis(List.of(perfil))
						.build();
				usuarioRepository.save(usuario);
			}
			System.out.println("Para fins de teste utilizar as credenciais teste@teste.com | senha12345");
		}
}
