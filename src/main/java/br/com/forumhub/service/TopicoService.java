package br.com.forumhub.service;

import br.com.forumhub.model.entity.Topico;
import br.com.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public List<Topico> findAll() {
        return repository.findAll();
    }

    public Topico findById(Long id) {

        Optional<Topico> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404),"Topico não econtrado");
        }
        return optional.get();

    }

    public Topico create(Topico curso) {
        return repository.save(curso);
    }

    public Topico update(Long id, Topico newTopico) {
        Topico curso = findById(id);
        newTopico.setId(curso.getId());
        return repository.save(newTopico);
    }


    public void deleteById(Long id) {
        Topico curso = findById(id);
        repository.delete(curso);
    }
}
