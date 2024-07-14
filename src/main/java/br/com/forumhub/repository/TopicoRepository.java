package br.com.forumhub.repository;


import br.com.forumhub.model.entity.Curso;
import br.com.forumhub.model.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
