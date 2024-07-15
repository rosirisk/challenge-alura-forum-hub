package br.com.forumhub.controller;

import br.com.forumhub.model.dto.TopicoDTO;
import br.com.forumhub.model.entity.Topico;
import br.com.forumhub.model.mapper.TopicoMapper;
import br.com.forumhub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoService service;
    @GetMapping
    public ResponseEntity getAll(){
        List<Topico> topicoList = service.findAll();
        List<TopicoDTO> topicos = TopicoMapper.MAPPER.listEntitiesToListDTO(topicoList);
        return ResponseEntity.ok(topicos);
    }
    @GetMapping("/{id}")
    public ResponseEntity getId(@PathVariable Long id){
        Topico topico = service.findById(id);
        TopicoDTO topicoDTO = TopicoMapper.MAPPER.entityToDTO(topico);
        return ResponseEntity.ok(topicoDTO);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TopicoDTO topicoDTO){
        Topico topico = TopicoMapper.MAPPER.dtoToEntity(topicoDTO);
        topico = service.create(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody TopicoDTO topicoDTO){
        Topico topico = TopicoMapper.MAPPER.dtoToEntity(topicoDTO);
        Topico update = service.update(id, topico);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
