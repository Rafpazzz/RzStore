package com.RzStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String emEstoque;

    @Column(nullable = false)
    private String imagemUrl;

    @ManyToMany(mappedBy = "produtos")
    private Set<NotaFiscal> notasFiscais = new HashSet<>();

}
