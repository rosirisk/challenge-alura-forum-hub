package br.com.forumhub.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"titulo","mensagem"}))
public class Topico {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String mensagem;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private String status;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Usuario autor;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Curso curso;

    @OneToMany(targetEntity = Resposta.class, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Resposta> respostas;

}
