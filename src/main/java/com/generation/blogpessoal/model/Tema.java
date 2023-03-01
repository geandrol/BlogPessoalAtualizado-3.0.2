package com.generation.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity //relação entidades
@Table(name = "tb_temas") //criar tabela
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//anotação para configurar o auto incremente
    private Long id;

    @NotNull(message = "O Atributo Descrição é obrigatório")
    private String descricao;

    //Lista de retorno da chave estrangeira
    @OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("tema")
    private List<Postagem> postagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagem() {
        return this.postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
}

