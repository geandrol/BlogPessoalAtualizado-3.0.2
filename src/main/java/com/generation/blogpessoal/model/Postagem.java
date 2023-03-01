package com.generation.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name= "tb_postagens")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Atributo título é Obrigatório!")
    @Size(min = 5 , max = 100 , message = "A atributo titulo, no minimo 5 e no maximo 100!")
    private String titulo;

    @NotBlank(message = "O Atributo texto é Obrigatório!")
    @Size(min = 5 , max = 100 , message = "A atributo texto, no minimo 5 e no maximo 100!")
    private String texto;

    @UpdateTimestamp
    private LocalDateTime data;

    //chave estrangeira - relação bidirecional
    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;
    // Essa variavel será foreingkey
    //////////////////////////////////////////
    //chave estrangeira - relação bidirecional
    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Usuario usuario;
    // Essa variavel será foreingkey


    public Long getId() { return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Tema getTema() { return tema; }

    public void setTema(Tema tema) { this.tema = tema; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
